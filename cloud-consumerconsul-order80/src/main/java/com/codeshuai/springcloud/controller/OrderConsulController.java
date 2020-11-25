package com.codeshuai.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ：codeshuai
 * @date ：Created in 2020/11/23 0:41
 */
@RestController
@Slf4j
public class OrderConsulController {

    public static final String INVOKE_TRL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_TRL + "/payment/consul", String.class);
        return result;
    }
}
