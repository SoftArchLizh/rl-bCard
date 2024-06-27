package com.volvo.invoice.config;

import com.volvo.invoice.service.impl.VJdcfphzServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Author: 李中华  wx: spllzh  email(qq): 28668817@qq.com
 * Date: 2024/3/6 12:38
 **/
@Configuration
public class BeanConfig {

   // @Bean
    public VJdcfphzServiceImpl getVJdcfphzServiceImpl() {
        VJdcfphzServiceImpl  vJdcfphzServiceImpl = new VJdcfphzServiceImpl();
        return vJdcfphzServiceImpl;
    }
}
