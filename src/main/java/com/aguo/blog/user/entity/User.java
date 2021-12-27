package com.aguo.blog.user.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author aguo
 * @since 2021-12-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User对象")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "微信号")
    private String wechat;

    @ApiModelProperty(value = "qq")
    private String qq;

    @ApiModelProperty(value = "github")
    private String github;

    @ApiModelProperty(value = "email")
    private String email;
}
