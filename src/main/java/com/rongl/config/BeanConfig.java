package com.rongl.config;

import com.volvo.invoice.service.impl.VJdcfphzServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author: 李中华
 * Date: 2024/3/6 12:38
 **/
@Configuration
public class BeanConfig  implements WebMvcConfigurer {

   // @Bean
    public VJdcfphzServiceImpl getVJdcfphzServiceImpl() {
        VJdcfphzServiceImpl  vJdcfphzServiceImpl = new VJdcfphzServiceImpl();
        return vJdcfphzServiceImpl;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //自定义路径mypic，  addResourceLocations指定访问资源所在目录
        registry.addResourceHandler("/bCard/**").addResourceLocations("file:D:\\bCard\\png\\");
        //自定义路径webjars访问，addResourceLocations映射该路径下的资源，resourceChain资源链
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/").resourceChain(true);
    }



}
