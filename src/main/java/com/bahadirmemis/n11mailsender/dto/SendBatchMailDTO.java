package com.bahadirmemis.n11mailsender.dto;

import java.util.List;

/**
 * @author bahadirmemis
 */
public record SendBatchMailDTO(List<String> receivers, String topic, String mailBody) {

}
