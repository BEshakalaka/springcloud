package com.codeshuai.springcloud.controller;

import com.codeshuai.springcloud.entities.CommonResult;
import com.codeshuai.springcloud.entities.Payment;
import com.codeshuai.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：codeshuai
 * @date ：Created in 2020/11/23 22:59
 */
@RestController
@Slf4j
public class OrderFeginController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }


    @GetMapping(value = "/consumer/payment/fegin/timeout")
    public String paymentFeginTimeout() {
        // 客户端一般默认等待一秒钟

        return paymentFeignService.paymentFeginTimeout();
    }


}
