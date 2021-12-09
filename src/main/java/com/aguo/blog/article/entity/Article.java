package com.aguo.blog.article.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2021-12-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Article对象", description="")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_UUID)
    @ApiModelProperty(value = "主键")
    private String bId;

    @ApiModelProperty(value = "文章名称")
    private String bName;

    @ApiModelProperty(value = "创建文章的时间")
    private LocalDateTime bCreateDate;

    @ApiModelProperty(value = "更新时间，默认为和创建时间相同	")
    private LocalDateTime bUpdateDate;

    @ApiModelProperty(value = "点赞的数量")
    private Integer bLike;

    @ApiModelProperty(value = "文章类别的标签")
    private String bTag;

    @ApiModelProperty(value = "文章内容")
    private String bContent;


}
