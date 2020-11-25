package com.codeshuai.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：codeshuai
 * @date ：Created in 2020/11/23 23:18
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feginLoggerLevel() {
        return Logger.Level.FULL;
    }
}
