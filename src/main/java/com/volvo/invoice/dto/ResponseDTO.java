package com.volvo.invoice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Author: 李中华  wx: spllzh  email(qq): 28668817@qq.com
 * Date: 2024/4/21 14:03
 **/
public class ResponseDTO<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("返回代码，0表示成功，其他表示失败")
    private String returnCode;
    @ApiModelProperty("返回描述")
    private String returnMessage;
    @JsonIgnore
    @ApiModelProperty(
            value = "错误原因",
            hidden = true
    )
    private String cause;
    @ApiModelProperty("返回数据")
    private T data;

    public ResponseDTO() {
    }

    public String getReturnCode() {
        return this.returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return this.returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCause() {
        return this.cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String toString() {
        return "ResponseDTO{returnCode='" + this.returnCode + '\'' + ", returnMessage='" + this.returnMessage + '\'' + ", data=" + this.data + ", cause=" + this.cause + '}';
    }
}
