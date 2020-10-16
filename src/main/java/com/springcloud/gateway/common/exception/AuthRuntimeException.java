package com.springcloud.gateway.common.exception;

import com.springcloud.gateway.common.enumm.ErrorMessageEnum;

/**
 * @author xutianhong
 * @Date 2020/10/13 14:44
 */
public class AuthRuntimeException extends RuntimeException {


    private static final long serialVersionUID = 1L;
    private Integer errorCode;
    private String errorName;
    private String errorMessage;
    private String extMessage;

    public AuthRuntimeException() {
    }

    public AuthRuntimeException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public AuthRuntimeException(String message, Integer errorCode) {
        super(message);
        this.errorMessage = message;
        this.errorCode = errorCode;
    }

    public AuthRuntimeException(String message, Integer errorCode, String extMessage) {
        super(message + (extMessage == null ? "" : (":" + extMessage)));
        this.errorMessage = message;
        this.errorCode = errorCode;
        this.extMessage = extMessage;
    }

    public AuthRuntimeException(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public AuthRuntimeException(Throwable cause) {
        super(cause);
    }

    public AuthRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthRuntimeException(ErrorMessageEnum error) {
        super(error.getMsg());
        this.errorCode = error.getCode();
        this.errorName = error.name();
        this.errorMessage = error.getMsg();
    }

    /**
     * 枚举异常+异常信息
     *
     * @param error
     * @param extMessage
     */
    public AuthRuntimeException(ErrorMessageEnum error, String extMessage) {
        super(error.getMsg() + (extMessage == null ? "" : (":" + extMessage)));
        this.errorCode = error.getCode();
        this.errorName = error.name();
        this.errorMessage = error.getMsg();
        this.extMessage = extMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getExtMessage() {
        return extMessage;
    }

    public void setExtMessage(String extMessage) {
        this.extMessage = extMessage;
    }

}
