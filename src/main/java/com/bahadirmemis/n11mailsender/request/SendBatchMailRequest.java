package com.bahadirmemis.n11mailsender.request;

import java.util.List;

/**
 * @author bahadirmemis
 */
public record SendBatchMailRequest(List<String> receivers, String topic, String mailBody) {

}
