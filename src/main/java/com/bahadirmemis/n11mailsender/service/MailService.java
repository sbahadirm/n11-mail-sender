package com.bahadirmemis.n11mailsender.service;

import com.bahadirmemis.n11mailsender.dto.SendBatchMailDTO;
import com.bahadirmemis.n11mailsender.dto.SendMailDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@Service
@RequiredArgsConstructor
public class MailService {

  private final JavaMailSender javaMailSender;

  @Value("${n11-mail-sender.default-mail-address}")
  private String DEFAULT_MAIL_ADDRESS;

  public int sendBatchMail(SendBatchMailDTO sendBatchMailDTO) {

    List<String> receivers = sendBatchMailDTO.receivers();

    List<SendMailDTO> sendMailDTOList = receivers.stream()
                                                 .map(receiver -> new SendMailDTO(receiver, DEFAULT_MAIL_ADDRESS,
                                                                                  sendBatchMailDTO.topic(),
                                                                                  sendBatchMailDTO.mailBody()))
                                                 .toList();

    int successCount = 0;
    for (SendMailDTO sendMailDTO : sendMailDTOList) {
      boolean isSuccess = sendMail(sendMailDTO);
      if (isSuccess) {
        successCount++;
      }
    }

    return successCount;
  }

  public boolean sendMail(SendMailDTO sendMailDTO) {

    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

    try {
      mimeMessageHelper.addTo(sendMailDTO.to());
      mimeMessageHelper.setFrom(sendMailDTO.from());
      mimeMessageHelper.setSubject(sendMailDTO.topic());
      mimeMessageHelper.setText(sendMailDTO.mailBody());
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }

    javaMailSender.send(mimeMessage);

    return true;
  }
}
