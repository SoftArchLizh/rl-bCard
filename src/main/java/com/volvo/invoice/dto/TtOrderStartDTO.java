package com.volvo.invoice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value="发起开票接口", description="发起开票接口")
public class TtOrderStartDTO implements Serializable {

    /**
     * 主键
     */
    @NotNull(message="主键/序号不能为空！")
    @ApiModelProperty("主键/序号")
    private Long id;

    /**
     * 购方名称
     */
    @NotBlank(message="购方名称不能为空！")
    @ApiModelProperty("购方名称")
    private String buyeName;

    /**
     * 购方税号
     */
    @NotBlank(message="购方税号不能为空！")
    @ApiModelProperty("购方税号")
    private String buyeTaxNo;

    /**
     * 购方地址
     */
    @ApiModelProperty("购方地址")
    private String buyeAddress;

    /**
     * 购方电话
     */
    @ApiModelProperty("购方电话")
    private String buyePhone;


    /**
     * 购方开户行
     */
    @ApiModelProperty("购方开户行")
    private String buyeBank;

    /**
     * 购方账号
     */
    @ApiModelProperty("购方账号")
    private String buyeAccount;

    /**
     * 订单编号
     */
    @NotBlank(message = "订单编号不能为空！")
    @ApiModelProperty("订单编号")
    private String orderNumber;


    /**
     * 销方名称
     */
    @NotBlank(message = "销方名称不能为空！")
    @ApiModelProperty("销方名称")
    private String salesName;

    /**
     * 销方税号
     */
    @NotBlank(message = "销方税号不能为空！")
    @ApiModelProperty("销方税号")
    private String salesTaxNo;


    /**
     * 公司编码
     */
    @ApiModelProperty("公司编码")
    private String companyCode;


    /**
     * 销方地址
     */
    @NotBlank(message = "销方地址不能为空！")
    @ApiModelProperty("销方地址")
    private String salesAddress;


    /**
     * 销方电话
     */
    @NotBlank(message = "销方电话不能为空！")
    @ApiModelProperty("销方电话")
    private String salesPhone;

    /**
     * 销方开户银行
     */
    @NotBlank(message = "销方开户银行不能为空！")
    @ApiModelProperty("销方开户银行")
    private String salesBank;

    /**
     * 销方账号
     */
    @NotBlank(message = "销方账号不能为空！")
    @ApiModelProperty("销方账号")
    private String salesAccount;


    /**
     * 开票状态
     */
    @ApiModelProperty("开票状态")
    private Integer invoiceStatus;

    /**
     * 校验蓝票
     */
    @ApiModelProperty("校验蓝票")
    private Integer isBlue;

    /**
     * 发票种类
     */
    @ApiModelProperty(value = "发票种类")
    private Integer fpzl;


    /**
     * 请求来源
     */
    @ApiModelProperty(value = "请求来源")
    private Integer requestSource;


    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;


    /**
     * 开票人
     */
    @ApiModelProperty("开票人")
    private String invoicePerson;


    /**
     * 收款人
     */
    @ApiModelProperty("收款人")
    private String payee;


    /**
     * 复核人
     */
    @ApiModelProperty("复核人")
    private String sfzdz;

    /**
     * 对应蓝票发票代码
     */
    @ApiModelProperty("对应蓝票发票代码")
    private String blueCode;

    /**
     * 对应蓝票发票号码
     */
    @ApiModelProperty("对应蓝票发票号码")
    private String blueNumber;

    /**
     * 推送方式
     */
    @ApiModelProperty(value = "推送方式")
    private Integer pushType;

    /**
     * 推送手机
     */
    @ApiModelProperty("推送手机")
    private String pushPhone;

    /**
     * 推送邮箱
     */
    @ApiModelProperty("推送邮箱")
    private String pushEmail;


    /**
     * 清单标志 0:非清单；1:清单，纸票超过8行自动转成清单，电票无清单概念，默认都传0
     */
    @ApiModelProperty(value = "清单标志")
    private Integer listMark;


    /**
     * 清单项目名称
     */
    @ApiModelProperty("清单项目名称")
    private String listName;

    /**
     * 开票设备分机号
     */
    @ApiModelProperty("开票设备分机号")
    private Integer extNumber;


    /**
     * 机器号
     */
    @ApiModelProperty("机器号")
    private String machineEncoding;


    /**
     * 代开标志
     */
    @ApiModelProperty("代开标志")
    private Integer dkSign;

    /**
     * 开票员所属部门
     */
    @ApiModelProperty("开票员所属部门")
    private Long department;


    /**
     * 部门编码
     */
    @ApiModelProperty("部门编码")
    private String departmentEncoding;


    /**
     * 开票员用户ID
     */
    @ApiModelProperty("开票员用户ID")
    private Long invoicePersonId;


    /**
     * 用户编码
     */
    @ApiModelProperty("用户编码")
    private String userEncoding;


    /**
     * 成品油标志
     */
    @ApiModelProperty("成品油标志")
    private Integer productOilSign;

    /**
     * 机动车标志
     */
    @ApiModelProperty("机动车标志")
    private Integer motorCarSign;

    /**
     * 红字信息表编号
     */
    @ApiModelProperty("红字信息表编号")
    private String redMarkInfoEncoding;



    /**
     * 个性化字段1
     */
    @ApiModelProperty("个性化字段1")
    private String individuationOne;

    /**
     * 个性化字段2
     */
    @ApiModelProperty("个性化字段2")
    private String individuationTwo;

    /**
     * 个性化字段3
     */
    @ApiModelProperty("个性化字段3")
    private String individuationThree;


    /**
     * 回调地址
     */
    @ApiModelProperty("回调地址")
    private String callbackAddress;


    /**
     * 汇率
     */
    @ApiModelProperty("汇率")
    private String  exchangeRate;

    /**
     * 合同号
     */
    @ApiModelProperty("合同号")
    private String contractNumber;

    /**
     * 提运单号
     */
    @ApiModelProperty("提运单号")
    private String deliveryNumber;


    /**
     * 业务标识
     */
    @ApiModelProperty("业务标识")
    private Integer businessSign;


    /**
     * 海运费
     */
    @ApiModelProperty("海运费")
    private BigDecimal oceanFreight;

    /**
     * 保险费
     */
    @ApiModelProperty("保险费")
    private BigDecimal insurancePremium;

    /**
     * 运保费
     */
    @ApiModelProperty("运保费")
    private BigDecimal transportationInsurance;


    /**
     * 装船口岸
     */
    @ApiModelProperty("装船口岸")
    private String loadingPort;

    /**
     * 目的港
     */
    @ApiModelProperty("目的港")
    private String destinationPort;


    /**
     * 外币港口
     */
    @ApiModelProperty("外币港口")
    private BigDecimal foreignCurrencyPort;


    /**
     * 出口日期
     */
    @ApiModelProperty("出口日期")
    private String  exportDate;

    /**
     * 币种
     */
    @ApiModelProperty("币种")
    private String  currency;


    /**
     * FOB金额
     */
    @ApiModelProperty("FOB金额")
    private BigDecimal fobAmount;

    /**
     * 报关单号
     */
    @ApiModelProperty("报关单号")
    private String  declarationNo;


    /**
     * 发货日期
     */
    @ApiModelProperty("发货日期")
    private String  fhDate;

    /**
     * 明细序号
     */
    @ApiModelProperty("明细序号")
    private Integer detailId;

    /**
     * 明细行性质
     */
    @ApiModelProperty("明细行性质")
    private Integer detailProperties;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String productName;

    /**
     * 单位含税标志
     */
    @ApiModelProperty("单位含税标志")
    private Integer unitTaxFlag;


    /**
     * 含税单价
     */

    @NotNull(message = "含税单价不能为空！")
    @ApiModelProperty("含税单价")
    private BigDecimal unitPrice;

    /**
     * 不含税单价
     */
    @ApiModelProperty("不含税单价")
    private BigDecimal notUnitPrice;

    /**
     * 数量
     */
    @ApiModelProperty("数量")
    private BigDecimal quantity;


    /**
     * 税率
     */
    @ApiModelProperty("税率")
    private String taxRate;

    /**
     * 规格型号
     */
    @ApiModelProperty("规格型号")
    private String specification;

    /**
     * 单位
     */
    @ApiModelProperty("单位")
    private String unit;

    /**
     * 税收分类编码
     */
    @ApiModelProperty("税收分类编码")
    private String taxTypeCode;

    /**
     * 税收分类编码简称
     */
    @ApiModelProperty("税收分类编码简称")
    private String taxTypeCodeJc;

    /**
     * 自行编码
     */
    @ApiModelProperty("自行编码")
    private String selfCoding;

    /**
     * 优惠政策标识
     */
    @ApiModelProperty("优惠政策标识")
    private Integer yhzcFlag;


    /**
     * 零税率标识
     */
    @ApiModelProperty("零税率标识")
    private Integer zeroTaxRateFlag;


    /**
     * 扣除额
     */
    @ApiModelProperty("扣除额")
    private BigDecimal deduction;

    /**
     * 不含税金额
     */
    @ApiModelProperty("不含税金额")
    private BigDecimal notIncludingTaxAmount;

    /**
     * 税额
     */
    @ApiModelProperty("税额")
    private BigDecimal taxAmount;

    /**
     * 含税金额
     */
    @ApiModelProperty("含税金额")
    private BigDecimal includingTaxAmount;

    /**
     * 盈亏吨数
     */
    @ApiModelProperty("盈亏吨数")
    private BigDecimal ykTonnage;


    /**
     * 自定义字段1
     */
    @ApiModelProperty("自定义字段1")
    private String selfFieldOne;

    /**
     * 自定义字段2
     */
    @ApiModelProperty("自定义字段2")
    private String selfFieldTwo;

    /**
     * 自定义字段3
     */
    @ApiModelProperty("自定义字段3")
    private String selfFieldThree;

    /**
     * 自定义字段4
     */
    @ApiModelProperty("自定义字段4")
    private String selfFieldFour;


    /**
     * 自定义字段4
     */
    @ApiModelProperty("自定义字段5")
    private String selfFieldFive;

    /**
     * 车辆类型
     */
    @ApiModelProperty("车辆类型")
    private String vehicleType;

    /**
     * 厂牌型号
     */
    @ApiModelProperty("厂牌型号")
    private String labelType;

    /**
     * 产地
     */
    @ApiModelProperty("产地")
    private String place;

    /**
     * 进口证明书号
     */
    @ApiModelProperty("进口证明书号")
    private String importCertificateNo;

    /**
     * 商检单号
     */
    @ApiModelProperty("商检单号")
    private String businessCheckNo;

    /**
     * 合格证号
     */
    @ApiModelProperty("合格证号")
    private String qualifiedNo;

    /**
     * 发动机号
     */
    @ApiModelProperty("发动机号")
    private String engineNo;

    /**
     * vin
     */
    @ApiModelProperty("vin")
    private String vin;

    /**
     * 吨位
     */
    @ApiModelProperty("吨位")
    private String tonnage;

    /**
     * 限乘人数
     */
    @ApiModelProperty("限乘人数")
    private String restrictPersonNum;

    /**
     * 其他证件号
     */
    @ApiModelProperty("其他证件号")
    private String  otherCredentialNo;

    /**
     * 排量
     */
    @ApiModelProperty(value = "排量", name = "displacement")
    private String displacement;

    /**
     * 生产企业名称
     */
    @ApiModelProperty("生产企业名称")
    private String  businessName;

    /**
     * 完整凭证号码
     */
    @ApiModelProperty("完整凭证号码")
    private String taxVoucher;

    /**
     * 开票类型
     * 1:蓝票；
     * 2:红票
     */
    @ApiModelProperty("开票类型")
    private Integer invoiceType;

    /**
     * 车票号码
     */
    @ApiModelProperty("车票号码")
    private String  ticketNo;

    /**
     * 登记证号
     */
    @ApiModelProperty("登记证号")
    private String  registrationNo;

    /**
     * 转入地车辆管理所名称
     */
    @ApiModelProperty("转入地车辆管理所名称")
    private String  carOfficeName;


    /**
     * 卖方单位/个人名称
     */
    @ApiModelProperty("卖方单位/个人名称")
    private String  sellerPersonalName;

    /**
     * 卖方单位代码/身份证号
     */
    @ApiModelProperty("卖方单位代码/身份证号")
    private String  sellerCertificateNo;

    /**
     * 卖方单位地址/个人地址
     */
    @ApiModelProperty("卖方单位地址/个人地址")
    private String  sellerAddress;

    /**
     * 卖方电话
     */
    @ApiModelProperty("卖方电话")
    private String  sellerPhone;

    /**
     * 组织机构代码  漏了   统一社会信用代码 纳税人识别号 销方税号
     */
    @ApiModelProperty(value = "组织机构代码")
    private String agencyNo;


    /**
     * 商品编码  漏了
     */
    @ApiModelProperty("商品编码")
    private String commodityCode;


    /**
     * 发票种类
     * p:电子增值税普通发票
     * c:增值税普通发票(纸票)
     * s:增值税专用发票
     * e:收购发票(电子)
     * f:收购发票(纸质)
     * b:增值税电子专用发票
     * j：机动车发票
     * u：二手车发票
     * bs：专用发票(全电),
     * pc普通发票(全电)
     */
    @ApiModelProperty("发票种类")
    private String invoiceLine;

    /**
     * 推送方式
     * -1:不推送;
     * 0:邮箱;
     * 1:手机(默认);
     * 2:邮箱、手机
     */
    @ApiModelProperty("推送方式")
    private Integer notifyType;

    /**
     * 推送手机(开票成功会短信提醒购方，推送方式为1或2时，此项必填)
     */
    @ApiModelProperty("推送手机")
    private String notifyPhone;

    /**
     * 推送邮箱（推送方式为0或2时，此项必填）
     */
    @ApiModelProperty("推送邮箱")
    private String notifyEmail;

    /**
     * 车型
     */
    @NotBlank(message = "车型不能为空")
    @ApiModelProperty("车型")
    private String modelId;

    /**
     * 发票代码
     */
    @ApiModelProperty("发票代码")
    private String invoiceCode;

    /**
     * 发票号码
     */
    @ApiModelProperty("发票号码")
    private String invoiceNumber;

    /**
     * 是否校验蓝票
     */
    @ApiModelProperty("是否校验蓝票")
    private Integer checkBlue;

    /**
     * 订单流水号
     */
    @ApiModelProperty("订单流水号")
    private String orderSerialNo;


    /**
     * oss进口机动车辆随车检查单url
     */
    @ApiModelProperty("oss进口机动车辆随车检查单url")
    private String checklistUrl;

    /**
     * oss进口货物证明书url
     */
    @ApiModelProperty("oss进口货物证明书url")
    private String certificateUrl;

    /**
     * oss合格证url
     */
    @ApiModelProperty("oss合格证url")
    private String qualifiedUrl;

    /**
     * oss车辆购置税纳税申报表url
     */
    @ApiModelProperty("oss车辆购置税纳税申报表url")
    private String declarationUrl;

    /**
     * 开票状态
     */
    @ApiModelProperty("开票状态")
    private String processStatus;
    @ApiModelProperty("抄送手机号，当推送手机notifyPhone有值时，才允许填写，多个中间用英文逗号隔开，最多可填写5个")
    private String ccPhone;
    @ApiModelProperty("推送邮箱notifyEmail有值时，才允许填写，多个中间用英文逗号隔开，最多可填写5个")
    private String ccEmail;
}