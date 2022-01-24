package com.aguo.blog.user.domainmodel;

import com.aguo.blog.user.co.UserRegisterCo;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author Aguo
 * @Date: 2022/01/20/ 15:39
 */
@Getter
@Setter
public class UserRegisterCmd implements Serializable {

    private static final long serialVersionUID = 4084862640952945895L;

    @Valid
    @NotNull(message = "请求参数不能为空")
    private UserRegisterCo co;
}
