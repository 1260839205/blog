package com.aguo.blog.article.domainmodel;

import com.aguo.blog.article.co.ArticleCo;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author Aguo
 * @Date: 2021/12/08/ 16:43
 */
@Data
public class ArticleCmd implements Serializable {
    private static final long serialVersionUID = 6859317770548311947L;

    @Valid
    @NotNull(message = "请求参数不能为空")
    private ArticleCo articleCo;
}
