package com.rongl.common;

import lombok.Data;

/**
 * Author: 李中华
 * Date: 2022/10/21 21:04
 **/
@Data
public class ReturnResult {
    int code;
    long page;
    long limit;
    long total;
    //"{\"code\":20000,\"data\":{\"token\":\"admin-token\"}}";
    Object data;

    public static ReturnResult OK(){
        ReturnResult r = new ReturnResult();
        r.setCode(20000);
        return  r;
    }
    public static ReturnResult Fail(){
        ReturnResult r = new ReturnResult();
        r.setCode(20001);

        return  r;
    }
    public static ReturnResult ErrorLogout(){
        ReturnResult r = new ReturnResult();
        r.setCode(50008);
        return  r;
    }


    public ReturnResult setPage(long page){
        this.page = page;
        return this;
    }
    public ReturnResult setLimit(long limit){
        this.limit = limit;
        return this;
    }

    public ReturnResult setTotal(long obj){
        this.total = obj;
        return this;
    }

    public ReturnResult setData(Object obj){
        this.data = obj;
        return this;
    }

}
