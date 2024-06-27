package com.volvo.invoice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Objects;

/**
 * 开票或者红冲时的请求对象
 */
@Data
public class OpenRushInvoiceReqDTO {

    @ApiModelProperty("业务方，由发票中心定义枚举；mall：商城；direct:直售；charge：充电；")

    private String businessCode;

    @ApiModelProperty("请求id 发票2.0必填 幂等")

    private String requestId;


    @ApiModelProperty("开票具体的内容")

    private OpenRushInvoiceContentReqDTO content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpenRushInvoiceReqDTO)) return false;
        OpenRushInvoiceReqDTO that = (OpenRushInvoiceReqDTO) o;
        return Objects.equals(getBusinessCode(), that.getBusinessCode()) && Objects.equals(getRequestId(), that.getRequestId()) && Objects.equals(getContent(), that.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBusinessCode(), getRequestId(), getContent());
    }
}
