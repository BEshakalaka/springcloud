package com.codeshuai.springcloud.controller;

import com.codeshuai.springcloud.entities.CommonResult;
import com.codeshuai.springcloud.entities.Payment;
import com.codeshuai.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.asn1.mozilla.PublicKeyAndChallenge;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author ：codeshuai
 * @date ：Created in 2020/11/19 1:44
 * <p>
 * 踩坑 1：
 * 80传过来post请求的create创建记录，但是serial为空，是因为没有加 @RequestBody
 * @RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)； GET方式无请求体，所以使用@RequestBody接收数据时，
 * @RequestBody最多只能有一个，而@RequestParam()可以有多个。
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("***************插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort:  " + serverPort + "   ", result);
        } else {
            return new CommonResult(444, "插入数据库失败,serverPort:   " + serverPort + "   ", result);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("***************查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询数据库成功,serverPort:   " + serverPort + "   ", payment);
        } else {
            return new CommonResult(444, "查询数据库失败，查询的id为,serverPort:   " + serverPort + "   " + id, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }


    @GetMapping(value = "/payment/fegin/timeout")
    public String paymentFeginTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }


}
