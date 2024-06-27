package com.volvo.invoice.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Author: 李中华
 * Date: 2024/4/21 14:10
 **/




public class ResponseUtils {
    private static final Logger logger = LoggerFactory.getLogger(ResponseUtils.class);

    public ResponseUtils() {
    }

    public static <T> ResponseDTO<T> success() {
        return success(ResponseCodeEnum.OK.getCode(), ResponseCodeEnum.OK.getDesc());
    }

    public static <T> ResponseDTO<T> success(T t) {
        return success(ResponseCodeEnum.OK.getCode(), ResponseCodeEnum.OK.getMessage(), t);
    }

    public static <T> ResponseDTO<T> success(String successCode, String successMessage) {
        return success(successCode, successMessage, null);
    }

//    public static <T> ResponseNotifyDTO<T> notify(String code, String message) {
//        return notify(code, message, (Object)null);
//    }

//    public static <T> ResponseNotifyDTO<T> notify(String code, String message, T t) {
//        ResponseNotifyDTO<T> responseNotifyDTO = new ResponseNotifyDTO();
//        responseNotifyDTO.setCode(code);
//        responseNotifyDTO.setMessage(message);
//        return responseNotifyDTO;
//    }

    public static <T> ResponseDTO<T> success(String successCode, String successMessage, T t) {
        ResponseDTO<T> responseDTO = new ResponseDTO();
        responseDTO.setReturnCode(successCode);
        responseDTO.setReturnMessage(successMessage);
        responseDTO.setData(t);
        return responseDTO;
    }

    public static <T> ResponseDTO<T> failure() {
        return failure(ResponseCodeEnum.FAILURE.getCode(), ResponseCodeEnum.FAILURE.getMessage());
    }

    public static <T> ResponseDTO<T> failure(T t) {
        return failure(ResponseCodeEnum.FAILURE.getCode(), ResponseCodeEnum.FAILURE.getMessage(), t);
    }

    public static <T> ResponseDTO<T> failure(String failureCode, String failureMessage) {
        return failure(failureCode, failureMessage,  null);
    }

    public static <T> ResponseDTO<T> failure(String failureMessage) {
        return failure(ResponseCodeEnum.FAILURE.getCode(), failureMessage,  null);
    }

    public static <T> ResponseDTO<T> failure(String failureCode, String failureMessage, T t) {
        ResponseDTO<T> responseDTO = new ResponseDTO();
        responseDTO.setReturnCode(failureCode);
        responseDTO.setReturnMessage(failureMessage);
        responseDTO.setData(t);
        return responseDTO;
    }

    /** @deprecated */
    @Deprecated
    public static <T> ResponseDTO<T> error() {
        return error(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getMessage());
    }

    public static <T> ResponseDTO<T> error(Exception e) {
        return error(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getMessage(), e);
    }

    /** @deprecated */
    @Deprecated
    public static <T> ResponseDTO<T> error(T t) {
        return error(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getMessage(), t);
    }

    public static <T> ResponseDTO<T> error(T t, Exception e) {
        return error(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getMessage(), t, e);
    }

    /** @deprecated */
    @Deprecated
    public static <T> ResponseDTO<T> error(String errorCode, String errorMessage) {
        return error(errorCode, errorMessage, (Exception)null);
    }

    public static <T> ResponseDTO<T> error(String errorCode, String errorMessage, Exception e) {
        return error(errorCode, errorMessage,  null, e);
    }

    public static <T> ResponseDTO<T> error(String errorMessage, Exception e) {
        return error(ResponseCodeEnum.ERROR.getCode(), errorMessage, e);
    }

    /** @deprecated */
    @Deprecated
    public static <T> ResponseDTO<T> error(String errorCode, String errorMessage, T t) {
        return error(errorCode, errorMessage, t, (Exception)null);
    }

    public static <T> ResponseDTO<T> error(String errorCode, String errorMessage, T t, Exception e) {
        logger.error("【出现异常】", (Throwable)(e != null && e.getCause() != null ? e.getCause() : e));
        errorMessage =  e.getMessage() ;
        ResponseDTO<T> responseDTO = new ResponseDTO();
        responseDTO.setReturnCode(errorCode);
        responseDTO.setReturnMessage(errorMessage);
        if (e != null) {
            responseDTO.setCause(e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage());
        }

        responseDTO.setData(t);
        return responseDTO;
    }
}
