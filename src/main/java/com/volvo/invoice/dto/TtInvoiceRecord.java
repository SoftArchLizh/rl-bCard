package com.volvo.invoice.dto;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("tt_invoice_record")
@ApiModel(value = "订单记录表")
public class TtInvoiceRecord {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    @ApiModelProperty(value = "订单金额")
    private BigDecimal orderAmount;

    @ApiModelProperty(value = "发票编号")
    private String invoiceId;

    @ApiModelProperty(value = "开发票的日期")
    private Date invoiceDate;

    @ApiModelProperty(value = "车架号")
    private String frameNumber;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}