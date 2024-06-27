package com.volvo.invoice.dto;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Data
public class NuoShuiInvoiceBaseDTO //extends NuoShuiInvoiceBaseDO
{

    /**
     * 	否	维护在诺税通组织管理中的“公司编码”。companyId,sellerTaxnum,
     * 	companyCode至少填一个。用来关联出诺税通系统内的“companyId”字段。
     */
    private String  companyCode;

    /**
     * 	是	开具红票时是否校验蓝票 0.校验蓝票是否存在 1.不校验蓝票是否存在但校验可冲红金额
     * 	2.不校验蓝票是否存在且不校验可冲红金额
     *
     * 	在开票/红冲(调用诺税的3.64.开票请求接口-新版接)时，该参数必填
     * 	在回调时，该参数非必填
     */
    private Integer  checkBlue;
    /**
     * 	是	请求来源，0 :api接口，可自定义，但必须是诺税通已维护好的枚举值
     */
    @NotNull
    private Integer  requestSrc;

    /**
     * 	否	备注，（注意：不同开票服务器类型支持的备注长度不同，请在提交前做好确认）
     */
    @ApiModelProperty("备注，（注意：不同开票服务器类型支持的备注长度不同，请在提交前做好确认）；数电电票：200(中文计算一位)其他发票：230(中文计算两位)；冲红时，必须在备注中注明“对应正数发票代码:XXXXXXXXX号码:YYYYYYYY”文案，其中“X”为发票代码，“Y”为发票号码，否则接口会自动添加该文案；发票种类为j：机动车发票时，备注需注明：“一车一票”否则接口会自动添加该文案")
    private String remark;

    /**
     * 	否	开票人
     */
    private String  clerker;
    /**
     * 	否	收款人
     */
    private String  payee;
    /**
     * 	否	复核人
     */
    private String  checker;

    /**
     * 	是	推送方式，-1:不推送;0:邮箱;1:手机(默认);2:邮箱、手机
     *
     * 	在开票/红冲(调用诺税的3.64.开票请求接口-新版接)时，该参数必填
     * 	在回调时，该参数非必填
     */
    private Integer  notifyType;
    /**
     * 	否	推送手机(开票成功会短信提醒购方，推送方式为1或2时，此项必填)
     */
    private String  notifyPhone;
    /**
     * 	否	推送邮箱（推送方式为0或2时，此项必填）
     */
    private String  notifyEmail;
    /**
     * 	是	清单标志，0:非清单；1:清单，纸票超过8行自动转成清单，电票无清单概念，默认都传0
     * 	在开票/红冲(调用诺税的3.64.开票请求接口-新版接)时，该参数必填
     * 	在回调时，该参数非必填
     */
    private Integer  listFlag;
    /**
     * 	否	注意：税局要求清单项目名称为（详见销货清单）
     */
    private String  listGoodsName;
    /**
     * 	否	开票设备分机号,范围为0-65535，如需指定设备开票或指定发票号段开票则需传入
     */
    private Integer  extensionNum;
    /**
     * 	否	开票设备终端号，如需指定设备开票则需传入
     */
    private Integer  terminalNum;
    /**
     * 	否	机器号，如需指定设备开票则需传入，
     * 	如需指定设备开票或指定发票号段开票则需传入
     * 	开票、红冲请求用这个
     */
    private String  machineNum;

    /**
     * 	是	代开标志，0:非代开;1:代开。代开蓝票备注文案要求包含：“代开企业税号:***代开企业名称:***.”；
     * 	代开红票备注文案要求：“对应正数发票代码:***号码:***代开企业税号:***代开企业名称:***.”。
     * 	（代开企业税号与代开企业名称之间仅支持一个空格或无符号）
     * 	在开票/红冲(调用诺税的3.64.开票请求接口-新版接)时，该参数必填
     * 	在回调时，该参数非必填
     */
    private Integer  substituteFlag;
    /**
     * 	否	开票员所属部门id（诺税通本地系统中的id），如需在诺税通中根据部门筛选查看发票，则可传入
     */
    private Long  departmentId;
    /**
     * 否	维护在诺税通部门管理中的“部门编码”。用来关联出诺税通系统内的“departmentId”字段。
     */
    private String  departmentCode;
    /**
     * 否	开票员用户id（诺税通系统中的id），如需在诺税通中根据开票员筛选查看发票，则可传入
     */
    private Long  userId;
    /**
     * 否	维护在诺税通用户管理中的“用户编码”。用来关联出诺税通系统内的“userId”字段。
     */
    private String  userCode;
    /**
     * 否	成品油标志，0:非成品油，1:成品油
     */
    private Integer  productOilFlag;
    /**
     * 否	红字信息表编号
     * 增值税专票冲红时，此项必填。且必须在备注中注明“开具红字增值税专用发票信息表编号ZZZZZZZZZZZZZZZZ”字样，其中“Z”为开具红字增值税专用发票所需要的长度为16位信息表编号
     * 样例：1403011904008472
     */
    private String  billInfoNo;
    /**
     * 否	业务方个性化字段,本应用只作保存。
     */
    private String  columnFirst;
    /**
     * 否	业务方个性化字段,本应用只作保存。
     */
    private String  columnSecond;
    /**
     * 否	业务方个性化字段,本应用只作保存
     */
    private String  columnThree;
    /**
     * 否	业务方发票开票开票成功/失败、作废结果回调地址
     */
    private String  bizCallbackUrl;
    /**
     * 否	汇率
     */
    private String  exchangeRate;
    /**
     * 否	汇率日期yyyy-MM-dd格式
     */
    private Date exchangeRateTime;
    /**
     * 否	合同号
     */
    private String  contractNo;
    /**
     * 否	提运单号
     */
    private String  waybillNo;
    /**
     * 否	业务标识(基础模块设置的业务类型枚举值)
     */
    private String  businessType;
    /**
     * 否	海运费
     */
    private BigDecimal shippingFee;
    /**
     * 否	保险费
     */
    private BigDecimal  insuranceFee;
    /**
     * 否	运保费
     */
    private BigDecimal  shippingInsuranceFee;
    /**
     * 否	装船口岸
     */
    private String  loadingHarbor;
    /**
     * 否	目的港
     */
    private String  destinationHarbor;
    /**
     * 否	外币港口
     */
    private BigDecimal  foreignCurrencyAmount;
    /**
     * 否	出口日期
     */
    private String  exportDate;
    /**
     * 	否	币种
     */
    private String  currencyType;
    /**
     * 否	FOB金额
     */
    private BigDecimal  fobAmount;
    /**
     * 否	报关单号
     */
    private String  customsNo;
    /**
     * 否	订单日期
     */
    private String  orderDate;
    /**
     * 否	发货日期
     */
    private String  deliverDate;
    /**
     * 否	项目编码
     */
    private String  projectCode;
    /**
     * 否	项目名称
     */
    private String  projectName;
    /**
     * 否	紧急订单标识
     */
    private Integer  emergencyFlag;
    /**
     * 否	指定发票卷开票时必传
     */
    private String  nextInvoiceCode;
    /**
     * 否	指定发票卷开票时必传
     */
    private String  nextInvoiceNum;
    /**
     * 否	购买方经办人姓名，全电特有字段
     */
    private String  buyerManagerName;
    /**
     * 否	经办人证件类型全电特有字段
     */
    private String  managerCardType;
    /**
     * 否	经办人证件号码全电特有字段，证件类型有值时必填
     */
    private String  managerCardNo;
    /**
     * 否	抄送手机号，当推送手机notifyPhone有值时，才允许填写，
     * 多个中间用英文逗号隔开，最多可填写5个
     */
    private String  ccPhone;
    /**
     * 否	抄送邮箱，当推送邮箱notifyEmail有值时，才允许填写，
     * 多个中间用英文逗号隔开，最多可填写5个
     */
    private String  ccEmail;

    /**
     * 否 数电纸票类型：                                                                 04     2016版增值税普通发票（二联折叠票）
     * 05     2016版增值税普通发票（五联折叠票
     * 1130     增值税专用发票（中文三联无金额限制版）
     * 1140     增值税专用发票（中文四联无金额限制版）
     * 1160     增值税专用发票（中文六联无金额限制版）
     * 1170     增值税专用发票（中文七联无金额限制版）
     *
     * 数电纸票时才需要传入，枚举值后续会持续更新;（票种为ec时，默认04；票种为es时，默认为1130）票种为ec时，只能为04或05；票种为es时只能为1130或1140或1160或1170
     */
    private String paperInvoiceType;

    /**
     * 数电发票 billNo
     */
    private String billNo;

    /**
     * 数电电票是否展示购销方银行账户信息：0全不显示1仅显示销方2仅显示购方3全部显示
     * 请求诺税写死，不对外提供参数
     */
    private Integer showBankAccountType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NuoShuiInvoiceBaseDTO that = (NuoShuiInvoiceBaseDTO) o;
        return Objects.equals(companyCode, that.companyCode) && Objects.equals(checkBlue, that.checkBlue) && Objects.equals(requestSrc, that.requestSrc) && Objects.equals(remark, that.remark) && Objects.equals(clerker, that.clerker) && Objects.equals(payee, that.payee) && Objects.equals(checker, that.checker) && Objects.equals(notifyType, that.notifyType) && Objects.equals(notifyPhone, that.notifyPhone) && Objects.equals(notifyEmail, that.notifyEmail) && Objects.equals(listFlag, that.listFlag) && Objects.equals(listGoodsName, that.listGoodsName) && Objects.equals(extensionNum, that.extensionNum) && Objects.equals(terminalNum, that.terminalNum) && Objects.equals(machineNum, that.machineNum) && Objects.equals(substituteFlag, that.substituteFlag) && Objects.equals(departmentId, that.departmentId) && Objects.equals(departmentCode, that.departmentCode) && Objects.equals(userId, that.userId) && Objects.equals(userCode, that.userCode) && Objects.equals(productOilFlag, that.productOilFlag) && Objects.equals(billInfoNo, that.billInfoNo) && Objects.equals(columnFirst, that.columnFirst) && Objects.equals(columnSecond, that.columnSecond) && Objects.equals(columnThree, that.columnThree) && Objects.equals(bizCallbackUrl, that.bizCallbackUrl) && Objects.equals(exchangeRate, that.exchangeRate) && Objects.equals(exchangeRateTime, that.exchangeRateTime) && Objects.equals(contractNo, that.contractNo) && Objects.equals(waybillNo, that.waybillNo) && Objects.equals(businessType, that.businessType) && Objects.equals(shippingFee, that.shippingFee) && Objects.equals(insuranceFee, that.insuranceFee) && Objects.equals(shippingInsuranceFee, that.shippingInsuranceFee) && Objects.equals(loadingHarbor, that.loadingHarbor) && Objects.equals(destinationHarbor, that.destinationHarbor) && Objects.equals(foreignCurrencyAmount, that.foreignCurrencyAmount) && Objects.equals(exportDate, that.exportDate) && Objects.equals(currencyType, that.currencyType) && Objects.equals(fobAmount, that.fobAmount) && Objects.equals(customsNo, that.customsNo) && Objects.equals(orderDate, that.orderDate) && Objects.equals(deliverDate, that.deliverDate) && Objects.equals(projectCode, that.projectCode) && Objects.equals(projectName, that.projectName) && Objects.equals(emergencyFlag, that.emergencyFlag) && Objects.equals(nextInvoiceCode, that.nextInvoiceCode) && Objects.equals(nextInvoiceNum, that.nextInvoiceNum) && Objects.equals(buyerManagerName, that.buyerManagerName) && Objects.equals(managerCardType, that.managerCardType) && Objects.equals(managerCardNo, that.managerCardNo) && Objects.equals(ccPhone, that.ccPhone) && Objects.equals(ccEmail, that.ccEmail) && Objects.equals(paperInvoiceType, that.paperInvoiceType) && Objects.equals(billNo, that.billNo) && Objects.equals(showBankAccountType, that.showBankAccountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), companyCode, checkBlue, requestSrc, remark, clerker, payee, checker, notifyType, notifyPhone, notifyEmail, listFlag, listGoodsName, extensionNum, terminalNum, machineNum, substituteFlag, departmentId, departmentCode, userId, userCode, productOilFlag, billInfoNo, columnFirst, columnSecond, columnThree, bizCallbackUrl, exchangeRate, exchangeRateTime, contractNo, waybillNo, businessType, shippingFee, insuranceFee, shippingInsuranceFee, loadingHarbor, destinationHarbor, foreignCurrencyAmount, exportDate, currencyType, fobAmount, customsNo, orderDate, deliverDate, projectCode, projectName, emergencyFlag, nextInvoiceCode, nextInvoiceNum, buyerManagerName, managerCardType, managerCardNo, ccPhone, ccEmail, paperInvoiceType, billNo, showBankAccountType);
    }
}
