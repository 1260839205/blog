package com.aguo.blog.article.domainmodel;

import com.aguo.blog.article.co.ArticleCo;

import java.io.Serializable;

/**
 * @Author Aguo
 * @Date: 2021/12/08/ 16:43
 */
public class ArticleCmd implements Serializable {
    private static final long serialVersionUID = 6859317770548311947L;

    private ArticleCo articleCo;
}
