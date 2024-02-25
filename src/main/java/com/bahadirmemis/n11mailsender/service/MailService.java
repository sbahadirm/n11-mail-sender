package com.bahadirmemis.n11mailsender.service;

import com.bahadirmemis.n11mailsender.dto.SendMailDTO;
import com.bahadirmemis.n11mailsender.request.SendMailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
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

  public boolean sendMail(SendMailDTO sendMailDTO){

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
