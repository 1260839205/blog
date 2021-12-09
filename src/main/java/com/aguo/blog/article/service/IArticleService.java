package com.aguo.blog.article.service;

import com.aguo.blog.article.entity.Article;
import com.aguo.blog.article.vo.ArticleVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author aguo
 * @since 2021-12-08
 */
public interface IArticleService extends IService<Article> {

    /**
     * 查询所有文章索引
     * @return 返回文章索引
     */
    List<ArticleVo> getArticle();
}
