package com.rongl.common;

import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.chat.*;
import com.unfbx.chatgpt.interceptor.OpenAILogger;
import com.unfbx.chatgpt.interceptor.OpenAiResponseInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Author: 李中华
 * Date: 2024/10/25 13:41
 **/
public class BCardUtils {



    public static String getCurrentOS(){
        // 判断当前的操作系统
        String os = System.getProperty("os.name");
        if(os.toLowerCase().contains("win")){
            return PropertiesCommon.OSwin;
        }else if(os.toLowerCase().contains("linux")){
            return PropertiesCommon.OSlinux;
        }else if(os.toLowerCase().contains("mac")){
            return PropertiesCommon.OSmac;
        }
        return  PropertiesCommon.OSunKnow;
    }

    public     static OpenAiClient initOpenAI() {

        OpenAiClient client=null    ;
        try {
            //可以为null
            //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890));
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new OpenAILogger());
            //！！！！千万别再生产或者测试环境打开BODY级别日志！！！！
            //！！！生产或者测试环境建议设置为这三种级别：NONE,BASIC,HEADERS,！！！
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
            OkHttpClient okHttpClient = new OkHttpClient
                    .Builder()
//                .proxy(proxy)
                    .addInterceptor(httpLoggingInterceptor)
                    .addInterceptor(new OpenAiResponseInterceptor())
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();


            client = OpenAiClient.builder()
                    //支持多key传入，请求时候随机选择
//                .apiKey(Arrays.asList("sk-6oDdN7HE06cB57Zp0dE620D9F79d47128e2dC8F814Fd3042"))
                    //自定义key的获取策略：默认KeyRandomStrategy
                    //.keyStrategy(new KeyRandomStrategy())
                    .keyStrategy(new FirstKeyStrategy())
                    .okHttpClient(okHttpClient)
                    //自己做了代理就传代理地址，没有可不不传,(关注公众号回复：openai ，获取免费的测试代理地址)
//                .apiHost("https://apple.hi3w.com/")
                    .apiKey(Arrays.asList("sk-KOyVSI5SOHQ4KcghQpPSSVAQyLOAmzFQ58ylsfoE1fdMFWcK"))
                    .apiHost("https://api.fe8.cn/")  // 购买的代理
                    .build();

        }catch (Exception ex) {
            ex.printStackTrace();
        }

        return  client;
    }






}
