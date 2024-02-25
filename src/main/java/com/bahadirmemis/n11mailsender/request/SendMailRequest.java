package com.bahadirmemis.n11mailsender.request;

/**
 * @author bahadirmemis
 */
public record SendMailRequest(String receiver, String topic, String mailBody) {

}
