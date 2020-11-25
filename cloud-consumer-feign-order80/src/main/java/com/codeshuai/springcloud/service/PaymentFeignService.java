package com.codeshuai.springcloud.service;

import com.codeshuai.springcloud.entities.CommonResult;
import com.codeshuai.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：codeshuai
 * @date ：Created in 2020/11/23 22:56
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/fegin/timeout")
    public String paymentFeginTimeout();
}
