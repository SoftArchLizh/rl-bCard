package com.rongl.config;

import com.rongl.common.BCardUtils;
import com.rongl.common.PropertiesCommon;
import com.rongl.common.ReturnResult;
import com.volvo.invoice.service.impl.VJdcfphzServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.UUID;

/**
 * Author: 李中华
 * Date: 2024/3/6 12:38
 **/
@Slf4j
@Configuration
public class BeanConfig  implements WebMvcConfigurer {


    @Value("${bCard-path-win}")
    private String pathWin;
    @Value("${bCard-path-linux}")
    private String pathLinux;

   // @Bean
    public VJdcfphzServiceImpl getVJdcfphzServiceImpl() {
        VJdcfphzServiceImpl  vJdcfphzServiceImpl = new VJdcfphzServiceImpl();
        return vJdcfphzServiceImpl;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //自定义路径mypic，  addResourceLocations指定访问资源所在目录



        UUID uuid = UUID.randomUUID();
        String uploadfile = "";
        String  openaiPath = "";
        if (BCardUtils.getCurrentOS().equals( PropertiesCommon.OSwin)) {

            registry.addResourceHandler("/api/bCard/**").addResourceLocations("file:"+pathWin);
        }else if (BCardUtils.getCurrentOS().equals( PropertiesCommon.OSlinux)) {
            registry.addResourceHandler("/api/bCard/**").addResourceLocations("file:"+pathLinux);

        }else if (BCardUtils.getCurrentOS().equals( PropertiesCommon.OSmac)) {
            registry.addResourceHandler("/api/bCard/**").addResourceLocations("file:"+pathLinux);
        }else {

        }



        //自定义路径webjars访问，addResourceLocations映射该路径下的资源，resourceChain资源链
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/").resourceChain(true);
    }



}
