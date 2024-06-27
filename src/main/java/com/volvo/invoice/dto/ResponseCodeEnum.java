package com.volvo.invoice.dto;

import lombok.Data;

/**
* Description: http请求响应值
* @author hubin
* @since
*/

public enum ResponseCodeEnum {
    OK("0", ""),
    FAILURE("1", "handle failure"),
    ERROR("2", "handle error"),
    ARGUMENT_NULL_ERROR("1001", "Not exists argument"),
    ARGUMENT_INVALID_ERROR("1002", "Invalid argument"),
    DEFAULT_ERROR("ERROR", "unknown error"),

    ID_PARAMS_CODE_ERROR("100101", "id不能为空！"),
    PARAMS_CODE_ERROR("100102", "参数不能为空！"),
    PARAMS_VERIFY_ERROR("100103", "参数验证错误！"),
    INVOICE_VERIFY_ERROR("100104", "业务渠道编码不存在！"),
    QUERY_INVOICE_CODE_ERROR("200101", "开票记录查无数据或已开票完成!"),
    QUERY_STATUS_CODE_ERROR("200102", "查询企业车架号、合格证状态失败!"),
    INVOICE_CODE_ERROR("200103", "开票请求接口失败!"),
    INVOICE_SUBMIT_ERROR("200104", "请求接口重复提交"),
    STATUS_CHANGE_CODE_ERROR("200108", "查询企业车架号、合格证状态进行中!"),
    QUERY_INVOICE_DETAIL_CODE_ERROR("200104", "开票明细查询无数据!"),
    DEAL_INVOICE_DETAIL_CODE_ERROR("200105", "处理开票查询结果失败!"),
    QUERY_INVOICE_RESULT_CODE_ERROR("200106", "查询开票查询结果失败!"),
    AGAIN_INVOICE_CODE_ERROR("200107", "开票重开请求接口失败!"),
    PAGE_PARAMS_CODE_ERROR("100102", "分页参数不能为空!"),
    INVOICE_TIME_PARAMS_CODE_ERROR("100103", "开票起止时间不完整!"),
    RANGE_PARAMS_CODE_ERROR("100104", "价税合计区间不完整!"),
    QUERY_CODE_ERROR("100105", "查询列表信息失败!"),
    QUERY_DETAIL_CODE_ERROR("100106", "查询详情信息失败!"),
    VIN_NUMBER_PARAMS_CODE_ERROR("100107", "vin和orderNumber不能同时为空!"),
    FILE_PARAMS_CODE_ERROR("100108", "附件数据最大3条!"),
    NOT_EXIST_CODE_ERROR("100109", "对应数据不存在!"),
    MAXIMUM_LIMIT_CODE_ERROR("100110", "新增数据超过最大限制!"),
    REQ_PARAMS_FAULT_CODE_ERROR("100111", "请求参数缺失!"),
    UPDATE_CODE_ERROR("300100", "修改开票记录失败!"),
    RUSH_CODE_ERROR("300100", "冲红失败，订单非开票完成状态!"),
    DATE_CODE_ERROR("400100", "查看开票结果，返回数据异常!"),
    INVOICE_FAIL_CODE_ERROR("500100", "开票失败！"),
    CALLBACK_SUCCESS_CODE_ERROR("0000", "同步成功"),
    CALLBACK_FAIL_CODE_ERROR("9999", "同步失败"),
    INVOICING_CODE_ERROR("200109", "该数据开票中，请勿重复开票！"),
    INVOICING_MESSAGE_ERROR("200110", "发送开票数据失败！"),
    RED_INVOICING_ERROR("200111", "红冲开票失败！"),
    BLUE_INVOICING_INVOICE_TYPE_ERROR("200112", "开蓝票时，invoiceType参数值必须为1！"),
    RED_INVOICING_INVOICE_TYPE_ERROR("200113", "红冲开票时，invoiceType参数值必须为2！"),
    RED_INVOICING_BILL_INFO_NO_ERROR("200114", "红冲开票时，billInfoNo参数为必填，且必须为16位的数字！"),
    INVOICING_CODE_ERROR_STATUS("200115", "该数据${X}，请勿重复开票！"),
    INVOICING_AMOUNT_ERROR_STATUS("200116", "超出最大开票金额99万限制！"),
    INVOICE_FAIL_CODE_ERROR_QUALIFIED_FAILED("200117", "开票失败，从车辆中心获取合格证信息失败！"),
    INVOICE_FAIL_CODE_ERROR_QUALIFIED_NOT_EXIST("200118", "开票失败，该vin号的车辆合格证在车辆中心不存在！"),
    INVOICE_FAIL_CODE_ERROR_QUALIFIED_PARAM_NULL("200119", "该vin号的车辆合格证的参数为空："),
    INVOICE_FAIL_CODE_ERROR_NOTIFY_TYPE_PARAM_NULL("200120", "推送方式notifyType必填"),
    INVOICE_FAIL_CODE_ERROR_NOTIFY_EMAIL_PARAM_NULL("200121", "推送方式notifyType=0为电子邮件时，notifyEmail必填"),
    INVOICE_FAIL_CODE_ERROR_NOTIFY_PHONE_PARAM_NULL("200122", "推送方式notifyType=1为电话时，notifyPhone必填"),
    INVOICE_FAIL_CODE_ERROR_NOTIFY_EMAIL_PHONE_PARAM_NULL("200123", "推送方式notifyType=2为邮箱、手机时，notifyEmail和notifyPhone都必填"),
    DELIVERY_INVOICE_ERROR_NOTIFY_EMAIL_PHONE_PARAM_ALL_NULL("200124", "发票交付时，notifyEmail交付邮箱和notifyPhone交付电话不能都为空"),
    DELIVERY_INVOICE_ERROR_INVOICE_NUMBER_NULL("200125", "invoiceNumber发票号码必填"),
    DELIVERY_INVOICE_ERROR_INVOICE_CODE_NULL("200126", "非数电发票时，invoiceCode发票代码必填"),
    DELIVERY_INVOICE_ERROR_INVOICE_RECORD_NOT_EXIST("200127", "交付发票失败，因为发票流水不存在！"),
    DELIVERY_INVOICE_ERROR_SELLER_TAXNUM_NULL("200128", "发票交付时，sellerTaxnum销方税号和sellerCompanyCode销方组织编码不能都为空！"),
    OPEN_RUSH_MAIN_MERCHANT_NOT_EXIST("400101", "该开票主体不存在，请检查主体信息是否正确"),
    OPEN_RUSH_ORDER_OPERATED("400102", "该订单已开票/红冲完成，请勿重复开票"),
    OPEN_RUSH_ORDER_IN_OPERATION("400103", "该订单正在开票中，请勿重复开票"),
    OPEN_RUSH_INVOICE_DB_SAVE_ERROR("400104", "开票/红冲操作保存库失败"),
    OPEN_RUSH_INVOICE_LOGIC_ERROR("400105", "开票/红冲逻辑错误"),
    RUSH_INVOICE_ERROR("50010", "billNo为查询到红字确认信息单"),
    RUSH_INVOICE_ORDERNO_ERROR("50011", "当前红冲业务单号不存在"),
    RUSH_INVOICE_ORDERNO_STATUS_ERROR("50012", "当前业务单号状态不支持红冲"),

    CALLBACK_INVOICE_ERROR("401101", "回调执行失败");


    private String code;
    private String desc;
    private String message;

    private ResponseCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String value() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }  public String getMessage() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
