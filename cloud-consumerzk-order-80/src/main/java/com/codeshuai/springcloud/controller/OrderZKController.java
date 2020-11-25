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
public class OrderZKController {

    public static final String INVOKE_TRL = "http://cloud-provider-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_TRL + "/payment/zk", String.class);
        return result;
    }
}
