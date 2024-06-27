package com.volvo.invoice.dto;

//import com.volvo.midend.invoice.dto.base.NuoShuiInvoiceBaseDTO;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

//import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

/**
 * 开票/红冲 发票2.0接口请求对象
 */
@Data
public class OpenRushStandardInvoiceReqDTO extends NuoShuiInvoiceBaseDTO {
    @ApiModelProperty("业务方的订单编号，由上游业务方传进来;为业务方的订单编号")
    @NotBlank(message = "业务方的订单编号不能为空！")
    private String businessOrderNo;

    /**
     * 主体商户号，区分枚举值：FPZT001，FPZT002
     * 用此字段从tc_invoice_sales_config表中获取销方信息
     */
    @ApiModelProperty("开票主体编号")
    @NotBlank(message = "开票主体编号不能为空！")
    private String mainMerchantCode;

    @ApiModelProperty("上游回调地址")
    @NotBlank(message = "上游回调地址不能为空！")
    private String upstreamCallback;

    @ApiModelProperty("幂等值")
    private String idempotent;
    /**
     * 开票请求detail入参
     */
    private List<DetailDTO> detail;

    private String invoiceId;

    private Long id;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpenRushStandardInvoiceReqDTO)) return false;
        if (!super.equals(o)) return false;
        OpenRushStandardInvoiceReqDTO that = (OpenRushStandardInvoiceReqDTO) o;
        return Objects.equals(getBusinessOrderNo(), that.getBusinessOrderNo()) && Objects.equals(getMainMerchantCode(), that.getMainMerchantCode()) && Objects.equals(getUpstreamCallback(), that.getUpstreamCallback()) && Objects.equals(getDetail(), that.getDetail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBusinessOrderNo(), getMainMerchantCode(), getUpstreamCallback(), getDetail());
    }
}
