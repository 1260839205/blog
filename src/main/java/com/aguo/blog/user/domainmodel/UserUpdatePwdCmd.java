package com.aguo.blog.user.domainmodel;

import com.aguo.blog.user.co.UserUpdatePwdCo;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author Aguo
 * @Date: 2021/12/10/ 9:27
 */
@Data
public class UserUpdatePwdCmd implements Serializable {
    private static final long serialVersionUID = 4437417265222140755L;

    @NotNull(message = "请求参数不能为空")
    private UserUpdatePwdCo userUpdatePwdCo;
}
