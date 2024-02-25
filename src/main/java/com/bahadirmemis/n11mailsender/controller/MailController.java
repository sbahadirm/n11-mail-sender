package com.bahadirmemis.n11mailsender.controller;

import com.bahadirmemis.n11mailsender.request.SendMailRequest;
import com.bahadirmemis.n11mailsender.response.MailInfoDTO;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bahadirmemis
 */
@RestController
@RequestMapping("api/v1/mails")
@Slf4j
public class MailController {

  @GetMapping("/default")
  public String getDefaultMailAddress() {
    return "sbahadirm@gmail.com";
  }

  @GetMapping("{id}/infos")
  public MailInfoDTO getMailSendInfoDTO(@PathVariable Long id, @RequestParam String topic) {
    return new MailInfoDTO("yusuf@memis.com", "sbahadirm@gmail.com", LocalDateTime.now(), topic);
  }

  @PostMapping
  public MailInfoDTO sendMail(@RequestBody SendMailRequest request) {

    log.info("Mail send to " + request.receiver());
    log.info("Body: " + request.mailBody());

    return new MailInfoDTO(request.receiver(), getDefaultMailAddress(), LocalDateTime.now(), request.topic());
  }

  @PutMapping
  public void sendMailPut(@RequestBody SendMailRequest request) {

    log.info("Mail send to " + request.receiver());
    log.info("Body: " + request.mailBody());
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {

    log.info("deleted! id: " + id);
  }
}
