package com.aguo.blog.response.code;

/**
 * @Author Aguo
 * @Date: 2021/12/08/ 10:32
 */
public enum RCode {
    /**
     * 成功返回的状态码
     */
    SUCCESS(200, "success"),
    /**
     * 资源不存在的状态码
     */
    RESOURCES_NOT_EXIST(404, "资源不存在"),
    /**
     * 所有无法识别的异常默认的返回状态码
     */
    SERVICE_ERROR(500, "服务器异常"),
    /**
     * 登录token失效
     */
    LOGIN_TOKEN_ERROR(10001,"认证失败"),
    /**
     * 账号或密码错误
     */
    LOGIN_ERROR(10002,"登录失败，账号或密码错误");

    /**
     * 状态码
     */
    private int code;
    /**
     * 返回信息
     */
    private String msg;

    RCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}