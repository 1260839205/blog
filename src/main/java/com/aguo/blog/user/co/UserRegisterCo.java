package com.aguo.blog.user.co;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author Aguo
 * @Date: 2022/01/20/ 16:03
 */
@Getter
@Setter
public class UserRegisterCo implements Serializable {

    private static final long serialVersionUID = -5678759397481000242L;

    @ApiModelProperty(value = "用户名")
    @NotBlank (message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码")
    @NotBlank (message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "作者名称")
    @NotBlank (message = "作者名称不能为空")
    private String author;

    @ApiModelProperty(value = "微信号")
    private String wechat;

    @ApiModelProperty(value = "QQ号")
    private String qq;

    @ApiModelProperty(value = "github")
    private String github;

    @ApiModelProperty(value = "Email")
    private String email;
}
