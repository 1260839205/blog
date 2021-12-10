package com.aguo.blog.user.co;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author Aguo
 * @Date: 2021/12/10/ 9:19
 */
@Data
public class UserUpdatePwdCo implements Serializable {
    private static final long serialVersionUID = -388807576394687337L;

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "旧密码不能为空")
    private String oldPassword;

    @NotEmpty(message = "新密码不能为空")
    private String newPassword;
}
