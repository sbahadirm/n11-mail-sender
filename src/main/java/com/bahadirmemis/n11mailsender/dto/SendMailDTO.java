package com.bahadirmemis.n11mailsender.dto;

/**
 * @author bahadirmemis
 */
public record SendMailDTO(String to, String from, String topic, String mailBody) {

}
