package com.volvo.invoice.dto;

import lombok.Getter;

/**
 * 日志 推送服务应用场景
 */
@Getter
public enum LogSinceType {
    //应用场景：1，推送诺税 ，2，推送商城，3，推送充电
    NUO_SHUI("1","推送诺税"),
    MALL("2","推送商城"),
    CHARGE("3","推送充电"),
    DIRECT("4","直售"),
    QST_DATA_SYNC("5","企税通同步"),
    SMM_DATA_SYNC("6","SMM同步"),
    DELIVERY_INVOICE("7","发票交付"),
    UPDATE_FACTORY("8","发票修改合格证信息同步车辆中心"),
    ;

    private String code;

    private String name;

    LogSinceType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
