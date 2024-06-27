package com.volvo.invoice.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 开票或者红冲的响应对象
 */
@Data
public class OpenRushInvoiceRespDTO {
    /**
     * 发票主表-业务方订单编号
     */
    String businessOrderNo;

    /**
     * 发票主表-订单编号
     */
    String orderNo;

    /**
     * 成功失败标志
     */
    boolean successFlag;

    /**
     * 主表错误code
     */
    String errorCode;
    /**
     * 主表错误信息
     */
    String errorMsg;

    /**
     * 成功的明细表id列表
     */
    List<Long> successDetailIdList;

    /**
     * 失败的明细表情况
     * key:明细表的主键Id；value：错误信息
     */
    Map<Long,String> errorDetailMap;


}
