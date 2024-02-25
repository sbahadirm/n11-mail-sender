package com.bahadirmemis.n11mailsender.controller;

import com.bahadirmemis.n11mailsender.response.MailInfoDTO;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bahadirmemis
 */
@RestController
@RequestMapping("api/v1/mails")
public class MailController {

  @GetMapping("/default")
  public String getDefaultMailAddress() {
    return "sbahadirm@gmail.com";
  }

  @GetMapping("{id}/infos")
  public MailInfoDTO getMailSendInfoDTO(@PathVariable Long id) {
    return new MailInfoDTO("yusuf@memis.com", "sbahadirm@gmail.com", LocalDateTime.now(), "Naber oğlum!");
  }
}
