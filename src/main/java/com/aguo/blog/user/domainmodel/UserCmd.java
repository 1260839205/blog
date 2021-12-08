package com.aguo.blog.user.domainmodel;

import com.aguo.blog.user.co.UserCo;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author Aguo
 * @Date: 2021/12/07/ 10:40
 */
@Getter
@Setter
public class UserCmd implements Serializable {
    private static final long serialVersionUID = -7661417835806349626L;

    @NotNull(message = "请求参数不能为空")
    private UserCo userCo;
}
