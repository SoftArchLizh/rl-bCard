package com.volvo.invoice.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Objects;

/**
 * <p>
 * 发票明细-机动车明细表,这个表存储数据：机动车普票j，增值税专票s(带机动车字样的)
 * </p>
 *
 * @author chenyan
 * @since 2024-01-05
 */
@Data
@TableName("tt_invoice_detail_vehicle")
@ApiModel(value = "InvoiceDetailVehicle对象", description = "发票明细-机动车明细表,这个表存储数据：机动车普票j，增值税专票s(带机动车字样的)")
public class InvoiceDetailVehicleDO   {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("车辆类型;发票种类为j或u时必填")
    private String vehicleType;

    @ApiModelProperty("厂牌型号；发票种类为j或u时必填")
    private String brandModel;

    @ApiModelProperty("产地；发票种类为j时必填")
    private String productOrigin;

    @ApiModelProperty("合格证号，国产车填写")
    private String certificate;

    @ApiModelProperty("进口证明书号，进口车填写")
    private String importCertifyNum;

    @ApiModelProperty("商检单号")
    private String inspectionOddNum;

    @ApiModelProperty("发动机号")
    private String engineNum;

    @ApiModelProperty("车架号码/车辆识别代号;发票种类为j或u时必填")
    private String vehicleCode;

    @ApiModelProperty("吨位")
    private String measureUnits;

    @ApiModelProperty("限乘人数")
    private String maxCapacity;

    @ApiModelProperty("其他证件号码，仅用于填写非中国居民证件号")
    private String organizationCode;

    @ApiModelProperty("生产企业名称，不同税控设备要求不一致，具体以开票设备为准，金税盘选填，ukey、百旺盘必填;发票种类为j必填")
    private String produceCompanyName;

    @ApiModelProperty("完税凭证号码")
    private String intactCertificateNum;

    @ApiModelProperty("开票方类型：1.经营单位2.拍卖单位3.二手车市场（二手车专用）;发票种类为u时必填")
    private String organizeType;

    private Long versions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceDetailVehicleDO)) return false;
        if (!super.equals(o)) return false;
        InvoiceDetailVehicleDO that = (InvoiceDetailVehicleDO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(vehicleType, that.vehicleType) && Objects.equals(brandModel, that.brandModel) && Objects.equals(productOrigin, that.productOrigin) && Objects.equals(certificate, that.certificate) && Objects.equals(importCertifyNum, that.importCertifyNum) && Objects.equals(inspectionOddNum, that.inspectionOddNum) && Objects.equals(engineNum, that.engineNum) && Objects.equals(vehicleCode, that.vehicleCode) && Objects.equals(measureUnits, that.measureUnits) && Objects.equals(maxCapacity, that.maxCapacity) && Objects.equals(organizationCode, that.organizationCode) && Objects.equals(produceCompanyName, that.produceCompanyName) && Objects.equals(intactCertificateNum, that.intactCertificateNum) && Objects.equals(organizeType, that.organizeType) && Objects.equals(versions, that.versions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), vehicleType, brandModel, productOrigin, certificate, importCertifyNum, inspectionOddNum, engineNum, vehicleCode, measureUnits, maxCapacity, organizationCode, produceCompanyName, intactCertificateNum, organizeType, versions);
    }
}
