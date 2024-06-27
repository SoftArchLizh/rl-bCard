package com.volvo.invoice.dto;

//import com.volvo.midend.invoice.dto.base.NuoShuiInvoiceBaseDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Objects;

/**
 * 开票请求入参
 * @author hubin
 */

@Data
@Accessors(chain = true)
@ApiModel(value="开票请求入参", description="开票请求入参")
public class NuoShuiInvoiceDTO //extends NuoShuiInvoiceBaseDTO
{

    /**
     * 开票请求detail入参
     */
    private List<DetailDTO> detail;

    /**
     * 订单id，在发票1.0和1.5里需要用；2.0不需要此字段
     */
    private Long orderId;


    /**
     * 购销身份：
     * 0：我是销售方
     * 1：我是购买方
     */
    private Integer identity;

    /**
     * 税号
     */
    private String taxNum;

    /**
     * 快捷冲红类型 不填或者0为普通快捷冲红 1:数电发票快捷冲红(数电发票必传1
     */
    private Integer   fastRedType;




    /**
     * 红字确认单uuid
     */
    private String   billUuid;

    /**
     * 申请方身份：
     * 0 销方
     * 1 购方
     */
    private Integer applySource;


    private String  billStatus;


    private String startTime;


    private String  endTime;

    /**
     * 开票状态(0:开票中1:开票完成2:开票失败3:发票生成
     */
    private Integer  status;

    /**
     * 发票id
     */
    private String  invoiceId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NuoShuiInvoiceDTO)) return false;
        NuoShuiInvoiceDTO that = (NuoShuiInvoiceDTO) o;
        return Objects.equals(getDetail(), that.getDetail()) && Objects.equals(getOrderId(), that.getOrderId()) && Objects.equals(getIdentity(), that.getIdentity()) && Objects.equals(getTaxNum(), that.getTaxNum()) && Objects.equals(getFastRedType(), that.getFastRedType()) && Objects.equals(getBillUuid(), that.getBillUuid()) && Objects.equals(getApplySource(), that.getApplySource()) && Objects.equals(getBillStatus(), that.getBillStatus()) && Objects.equals(getStartTime(), that.getStartTime()) && Objects.equals(getEndTime(), that.getEndTime()) && Objects.equals(getStatus(), that.getStatus()) && Objects.equals(getInvoiceId(), that.getInvoiceId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDetail(), getOrderId(), getIdentity(), getTaxNum(), getFastRedType(), getBillUuid(), getApplySource(), getBillStatus(), getStartTime(), getEndTime(), getStatus(), getInvoiceId());
    }
}
