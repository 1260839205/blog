package com.aguo.blog.article.domainmodel;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Aguo
 * @Date: 2021/12/09/ 15:45
 */
@Data
public class ArticleDetailsCmd implements Serializable {
    private static final long serialVersionUID = -8201796480899077905L;

    private String id;
}
