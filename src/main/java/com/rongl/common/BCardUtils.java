package com.rongl.common;

import org.springframework.beans.factory.annotation.Value;

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




}
