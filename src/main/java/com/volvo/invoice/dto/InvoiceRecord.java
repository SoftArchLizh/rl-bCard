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
@ApiModel("订单记录表")
@TableName("tt_invoice_record")
public class InvoiceRecord {

    @ApiModelProperty("主键ID")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("订单编号")
    @TableField("order_number")
    private String orderNumber;
    @ApiModelProperty("订单金额")
    @TableField("order_amount")
    private BigDecimal orderAmount;
    @ApiModelProperty("发票编号")
    @TableField("invoice_number")
    private String invoiceNumber;
    @ApiModelProperty("开发票的日期")
    @TableField("invoice_date")
    private Date invoiceDate;
    @ApiModelProperty("车架号")
    private String vin;
    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;
}