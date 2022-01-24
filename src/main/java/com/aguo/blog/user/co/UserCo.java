package com.aguo.blog.user.co;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
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
    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;
}

