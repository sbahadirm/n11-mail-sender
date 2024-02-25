package com.bahadirmemis.n11mailsender.response;

import java.time.LocalDateTime;

/**
 * @author bahadirmemis
 */
public record MailInfoDTO(String receiver, String sender, LocalDateTime mailDate, String topic) {

}
