package com.codeshuai.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author ：codeshuai
 * @date ：Created in 2020/11/22 1:24
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String payment() {
        return "Srpingcloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
