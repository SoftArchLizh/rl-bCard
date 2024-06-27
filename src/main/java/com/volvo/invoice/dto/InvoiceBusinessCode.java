package com.volvo.invoice.dto;

import lombok.Getter;

/**
 * 发票业务方编码
 */
@Getter
public enum InvoiceBusinessCode {
    //由发票中心定义枚举；mall：商城；direct:直售；charge：充电；
    MALL("mall","商城",LogSinceType.MALL),
    DIRECT("direct","直售",LogSinceType.DIRECT),
    CHARGE("charge","充电",LogSinceType.CHARGE);

    private String code;
    private String desc;
    private LogSinceType logSinceType;

    InvoiceBusinessCode(String code, String desc, LogSinceType logSinceType) {
        this.code = code;
        this.desc = desc;
        this.logSinceType = logSinceType;
    }

    /**
     * 根据code查看枚举是否存在
     * @param code
     * @return
     */
    public static boolean checkCodeExist(String code){
        for (InvoiceBusinessCode value : InvoiceBusinessCode.values()) {
            String code1 = value.getCode();
            if(code1.equals(code)){
                return true;
            }
        }
        return false;
    }

    /**
     * 根据code获取InvoiceBusinessCode枚举值
     * @param code
     * @return
     */
    public static InvoiceBusinessCode getEnumByCode(String code){
        for (InvoiceBusinessCode value : InvoiceBusinessCode.values()) {
            if(value.getCode().equals(code)){
                return value;
            }
        }
        return null;
    }
}
