package com.aguo.blog.article.co;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author Aguo
 * @Date: 2021/12/08/ 16:38
 */
@Data
public class ArticleCo implements Serializable {
    private static final long serialVersionUID = -7894486655469590761L;

    @ApiModelProperty(value = "主键")
    private String bId;

    @ApiModelProperty(value = "文章名称")
    private String bName;

    @ApiModelProperty(value = "创建文章的时间")
    private LocalDateTime bCreateDate;

    @ApiModelProperty(value = "更新时间，默认为和创建时间相同	")
    private LocalDateTime bUpdateDate;

    @ApiModelProperty(value = "文章存放的路径")
    private String bUrl;

    @ApiModelProperty(value = "点赞的数量")
    private Integer bLike;

    @ApiModelProperty(value = "文章类别的标签")
    private String bTag;
}
