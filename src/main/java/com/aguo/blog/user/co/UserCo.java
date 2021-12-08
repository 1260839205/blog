package com.aguo.blog.user.co;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Aguo
 * @Date: 2021/12/07/ 10:35
 */
@Data
public class UserCo implements Serializable {
    private static final long serialVersionUID = -4777147418180438094L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}

