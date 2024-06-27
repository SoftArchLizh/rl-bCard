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
@TableName("v_jdcfphz")
@ApiModel(value = "发票表")
public class VJdcfphz {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "发票编码")
    private String invoiceCode;

    @ApiModelProperty(value = "发票金额")
    private BigDecimal invoiceAmount;

    @ApiModelProperty(value = "车架号")
    private String vin;

    @ApiModelProperty(value = "进项��率")
    private BigDecimal inputTaxRate;

    @ApiModelProperty(value = "含��单价")
    private BigDecimal inclusivePrice;

    @ApiModelProperty(value = "单价金额")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "数量")
    private Integer quantity;

    @ApiModelProperty(value = "合计单价")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "开票类型")
    private String invoiceType;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}