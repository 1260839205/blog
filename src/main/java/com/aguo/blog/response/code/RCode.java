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
    LOGIN_ERROR(10002,"登录失败，账号或密码错误"),
    /**
     * 修改账号密码失败，旧密码错误
     */
    USER_UPDATE_ERROR(10003,"修改账号密码失败，旧密码错误"),
    /**
     * 文章不完整，请补充完整
     */
    ARTICLE_NOT_ERROR(20001,"文章不完整,请补充完整"),
    /**
     * 文章查询错误，未查到此文章
     */
    ARTICLE_DETAILS_ERROR(20002,"文章查询错误，未查到此文章"),

    ARTICLE_NOT_NULL_ERROR(20003, "修改内容不能为空");

    /**
     * 状态码
     */
    private final int code;
    /**
     * 返回信息
     */
    private final String msg;

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