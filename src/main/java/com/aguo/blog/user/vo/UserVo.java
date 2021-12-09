package com.aguo.blog.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author Aguo
 * @Date: 2021/12/08/ 17:51
 */
@Data
public class UserVo implements Serializable {
    private static final long serialVersionUID = -8523310546699306870L;


    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "微信号")
    private String wechat;

    @ApiModelProperty(value = "qq")
    private String qq;

    @ApiModelProperty(value = "github")
    private String github;
}
