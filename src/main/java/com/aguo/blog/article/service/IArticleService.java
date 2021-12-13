package com.aguo.blog.article.service;

import com.aguo.blog.article.domainmodel.ArticleCmd;
import com.aguo.blog.article.domainmodel.ArticleDetailsCmd;
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

    /**
     * 保存一篇文章
     * @param cmd 文章信息
     * @return 是否保存成功
     */
    Boolean saveArticle(ArticleCmd cmd);

    /**
     * 查询一篇文章的详情
     * @param cmd 查询条件
     * @return 查询结果
     */
    ArticleVo findArticle(ArticleDetailsCmd cmd);

    /**
     * 修改一篇文章
     * @param cmd 入参，修改内容
     * @return 是否修改成功
     */
    Boolean updateArticle(ArticleCmd cmd);
}
