package com.springcloud.gateway.common.enumm;

/**
 * @author xutianhong
 * @Date 2020/10/13 14:47
 */
public enum ErrorMessageEnum {
    USER_NOT_LOGIN(401, "User not login or timeout", "用户未登录或登录超时"),
    TOKEN_NOT_NULL(401, "Token Can not be blank", "Token不能为空"),
    TOKEN_ERROR(401, "Token illegal or has failed", "Token不合法或已失效"),
    ERROR(500, "", "程序异常"),
    NOT_EXIST(500, "", "不存在"),
    // 用户相关 200xxx

    START_DATE_AFTER_END(100033, "Date error, start date is after end date.", "开始时间大于结束时间"),
    Role_NOT_NULL(200007, "Role Can not be blank", "角色不能为空"),
    USER_ROLE_ERROR(200008, "Abnormal user roles, please contact the administrator", "用户角色异常，请联系管理员"),
    USER_NOT_AUTH(200009, "User is not authorized, please contact the administrator", "用户未授权，请联系管理员"),
    PATH_NOT_REGISTER(203018, "Url is not registered，please contact the administrator to register", "URL未注册，请联系管理员注册URL!"),
    USER_PERMISSION_DENIED(200025, "Permission denied.", "权限不足"),
    ;

    private final int code;
    private final String msg;
    private final String enMsg;

    ErrorMessageEnum(int code, String enMsg, String msg) {
        this.code = code;
        this.msg = msg;
        this.enMsg = enMsg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getEnMsg(){
        return enMsg;
    }
}
