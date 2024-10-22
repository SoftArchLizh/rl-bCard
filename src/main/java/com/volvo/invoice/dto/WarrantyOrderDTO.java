package com.volvo.invoice.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data // Lombok annotation to generate getters, setters, equals, hashCode, and toString methods
public class WarrantyOrderDTO {

    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @NotBlank(message = "经销商编码不能为空")
    @ApiModelProperty(value = "经销商编码", required = true)
    private String dealerCode;

    @ApiModelProperty("经销商名称")
    private String dealerName;

    @NotBlank(message = "保修单号不能为空")
    @ApiModelProperty(value = "保修单号", required = true)
    private String warrantyOrderNo;

    @ApiModelProperty("保修状态")
    private String warrantyStatus;

    @NotBlank(message = "VIN码不能为空")
    @ApiModelProperty(value = "VIN码", required = true)
    private String vinCode;

    @ApiModelProperty("工单号")
    private String workOrderNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("维修日期")
    private LocalDateTime repairDate;

    @ApiModelProperty("是否结案")
    private Boolean isClosed;

    @ApiModelProperty("行驶里程")
    private Integer mileage;

    @ApiModelProperty("车型代码")
    private String vehicleModelCode;

    @ApiModelProperty("车牌号")
    private String licensePlate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("销售日期")
    private LocalDate saleDate;

    @ApiModelProperty("零件总额")
    private BigDecimal partsTotal;

    @ApiModelProperty("工时数")
    private BigDecimal laborHours;

    @ApiModelProperty("零件保修成本总额")
    private BigDecimal warrantyCost;

    @ApiModelProperty("工时费用")
    private BigDecimal laborFee;

    @ApiModelProperty("委外工资总额")
    private BigDecimal outsourcingSalary;

    @ApiModelProperty("是否拒赔")
    private Boolean isRejected;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("保修上报日期")
    private LocalDate reportDate;

    @ApiModelProperty("保修上报人")
    private String reporter;

    @ApiModelProperty("BPM审核意见")
    private String bpmAuditComment;

    @ApiModelProperty("备注")
    private String remarks;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("回款日期")
    private LocalDate refundDate;

    @ApiModelProperty("是否上传")
    private Boolean isUploaded;

    @ApiModelProperty("上传次数")
    private Integer uploadAttempts;

    @ApiModelProperty("零件申请金额")
    private BigDecimal partsApplicationAmount;

    @ApiModelProperty("工时申请金额")
    private BigDecimal laborApplicationAmount;

    @ApiModelProperty(value = "qw90Msg", example = "xxx")
    private String qw90Msg;


    @ApiModelProperty(value = "交修明细集合列表", notes = "包含多个RepairDetail对象的列表")
    private List<Map<String,Object>> repairDetails;

    @ApiModelProperty(value = "附件集合列表", notes = "包含多个Attachment对象的列表")
    private  List<Map<String,Object>> attachments;

    @ApiModelProperty(value = "返回码", example = "20008 vin Code 不存在")
    private String retCode;
}

