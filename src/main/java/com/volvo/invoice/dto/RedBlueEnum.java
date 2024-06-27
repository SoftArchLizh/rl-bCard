package com.volvo.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 蓝票/红票
 * @Author yubiao.ju
 * @Date 2023年10月27日
 */

@Getter
@AllArgsConstructor
public enum RedBlueEnum {

    BLUE(1, "蓝票"),

    RED(2, "红票");

    private final Integer code;

    private final String desc;

}
