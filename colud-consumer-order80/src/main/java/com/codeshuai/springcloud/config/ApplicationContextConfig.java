package com.codeshuai.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：codeshuai
 * @date ：Created in 2020/11/21 17:28
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced  //使用@LoalBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
