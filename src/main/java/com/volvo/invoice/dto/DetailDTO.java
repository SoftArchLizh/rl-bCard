package com.volvo.invoice.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Objects;

@Data
@Accessors(chain = true)
@ApiModel(value="开票请求detail入参", description="开票请求detail入参")
public class DetailDTO extends InvoiceDetailVehicleDO {

    //-----------start--以下明细是 机动车(j)/二手车发票(u)明细（发票种类为j或u时需传入） 的时候传入，如果为增值税专用票s，不要穿下面的这些参数-----------------

    /**
     * 车票号码
     */
    @ApiModelProperty("车票号码")
    private String  licenseNumber;

    /**
     * 登记证号
     */
    @ApiModelProperty("登记证号")
    private String  registerCertNo;


    /**
     * 转入地车辆管理所名称
     */
    @ApiModelProperty("转入地车辆管理所名称")
    private String  vehicleManagementName;


    /**
     * 卖方单位/个人名称
     */
    @ApiModelProperty("卖方单位/个人名称")
    private String  salerName;


    /**
     * 卖方单位代码/身份证号
     */
    @ApiModelProperty("卖方单位代码/身份证号")
    private String  salerNum;

    /**
     * 卖方单位地址/个人地址
     */
    @ApiModelProperty("卖卖方单位地址/个人地址")
    private String  salerAddress;

    /**
     * 卖方电话
     */
    @ApiModelProperty("卖方电话")
    private String  salerPhone;


    /**
     * 主营税务机关及代码
     */
    @ApiModelProperty("主营税务机关及代码")
    private String  taxOfficeCode;

    //-----------end--以上明细是 机动车(j)/二手车发票(u)明细（发票种类为j或u时需传入） 的时候传入，如果为增值税专用票s，不要穿下面的这些参数-----------------


    //------------------start--咱们系统自定义增加的参数--------------------------
    /**
     * orderId
     */
    @ApiModelProperty("订单主表id")
    private Long  orderId;

    //------------------end--咱们系统自定义增加的参数--------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetailDTO)) return false;
        DetailDTO detailDTO = (DetailDTO) o;
        return Objects.equals(getVehicleType(), detailDTO.getVehicleType()) && Objects.equals(getBrandModel(), detailDTO.getBrandModel()) && Objects.equals(getProductOrigin(), detailDTO.getProductOrigin()) && Objects.equals(getImportCertifyNum(), detailDTO.getImportCertifyNum()) && Objects.equals(getInspectionOddNum(), detailDTO.getInspectionOddNum()) && Objects.equals(getCertificate(), detailDTO.getCertificate()) && Objects.equals(getEngineNum(), detailDTO.getEngineNum()) && Objects.equals(getOrganizeType(), detailDTO.getOrganizeType()) && Objects.equals(getLicenseNumber(), detailDTO.getLicenseNumber()) && Objects.equals(getRegisterCertNo(), detailDTO.getRegisterCertNo()) && Objects.equals(getVehicleManagementName(), detailDTO.getVehicleManagementName()) && Objects.equals(getSalerName(), detailDTO.getSalerName()) && Objects.equals(getSalerNum(), detailDTO.getSalerNum()) && Objects.equals(getSalerAddress(), detailDTO.getSalerAddress()) && Objects.equals(getSalerPhone(), detailDTO.getSalerPhone()) && Objects.equals(getTaxOfficeCode(), detailDTO.getTaxOfficeCode()) && Objects.equals(getOrderId(), detailDTO.getOrderId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getVehicleType(), getBrandModel(), getProductOrigin(), getImportCertifyNum(), getInspectionOddNum(), getCertificate(), getEngineNum(), getOrganizeType(), getLicenseNumber(), getRegisterCertNo(), getVehicleManagementName(), getSalerName(), getSalerNum(), getSalerAddress(), getSalerPhone(), getTaxOfficeCode(), getOrderId());
    }
}