package com.volvo.invoice.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * <p>
 * 保修工单表
 * </p>
 *
 * @author 李中华
 * @since 2024-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("warranty_orders")
@ApiModel(value="WarrantyOrders对象", description="保修工单表")
public class WarrantyOrders implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "经销商编码")
    @TableField("dealer_code")
    private String dealerCode;

    @ApiModelProperty(value = "经销商名称")
    @TableField("dealer_name")
    private String dealerName;

    @ApiModelProperty(value = "保修单号")
    @TableField("warranty_order_no")
    private String warrantyOrderNo;

    @ApiModelProperty(value = "保修状态")
    @TableField("warranty_status")
    private String warrantyStatus;

    @ApiModelProperty(value = "VIN码")
    @TableField("vin_code")
    private String vinCode;

    @ApiModelProperty(value = "工单号")
    @TableField("work_order_no")
    private String workOrderNo;

    @ApiModelProperty(value = "维修日期")
    @TableField("repair_date")
    private LocalDate repairDate;

    @ApiModelProperty(value = "是否结案")
    @TableField("is_closed")
    private Boolean isClosed;

    @ApiModelProperty(value = "行驶里程")
    @TableField("mileage")
    private Integer mileage;

    @ApiModelProperty(value = "车型代码")
    @TableField("vehicle_model_code")
    private String vehicleModelCode;

    @ApiModelProperty(value = "车牌号")
    @TableField("license_plate")
    private String licensePlate;

    @ApiModelProperty(value = "销售日期")
    @TableField("sale_date")
    private LocalDate saleDate;

    @ApiModelProperty(value = "零件总额")
    @TableField("parts_total")
    private BigDecimal partsTotal;

    @ApiModelProperty(value = "工时数")
    @TableField("labor_hours")
    private BigDecimal laborHours;

    @ApiModelProperty(value = "零件保修成本总额")
    @TableField("warranty_cost")
    private BigDecimal warrantyCost;

    @ApiModelProperty(value = "工时费用")
    @TableField("labor_fee")
    private BigDecimal laborFee;

    @ApiModelProperty(value = "委外工资总额")
    @TableField("outsourcing_salary")
    private BigDecimal outsourcingSalary;

    @ApiModelProperty(value = "是否拒赔")
    @TableField("is_rejected")
    private Boolean isRejected;

    @ApiModelProperty(value = "保修上报日期")
    @TableField("report_date")
    private LocalDate reportDate;

    @ApiModelProperty(value = "保修上报人")
    @TableField("reporter")
    private String reporter;

    @ApiModelProperty(value = "BPM审核意见")
    @TableField("bpm_audit_comment")
    private String bpmAuditComment;

    @ApiModelProperty(value = "备注")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty(value = "回款日期")
    @TableField("refund_date")
    private LocalDate refundDate;

    @ApiModelProperty(value = "是否上传")
    @TableField("is_uploaded")
    private Boolean isUploaded;

    @ApiModelProperty(value = "上传次数")
    @TableField("upload_attempts")
    private Integer uploadAttempts;

    @ApiModelProperty(value = "零件申请金额")
    @TableField("parts_application_amount")
    private BigDecimal partsApplicationAmount;

    @ApiModelProperty(value = "工时申请金额")
    @TableField("labor_application_amount")
    private BigDecimal laborApplicationAmount;

    @ApiModelProperty(value = "交修明细集合列表")
    @TableField("repair_details")
    private String repairDetails;

    @ApiModelProperty(value = "附件集合列表")
    @TableField("attachments")
    private String attachments;


}
