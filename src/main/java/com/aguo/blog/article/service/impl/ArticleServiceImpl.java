package com.aguo.blog.article.service.impl;

import com.aguo.blog.article.co.ArticleCo;
import com.aguo.blog.article.domainmodel.ArticleCmd;
import com.aguo.blog.article.domainmodel.ArticleDetailsCmd;
import com.aguo.blog.article.entity.Article;
import com.aguo.blog.article.mapper.ArticleMapper;
import com.aguo.blog.article.service.IArticleService;
import com.aguo.blog.article.vo.ArticleVo;
import com.aguo.blog.response.code.RCode;
import com.aguo.blog.response.error.BaseException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author aguo
 * @since 2021-12-08
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements IArticleService {

    @Override
    public List<ArticleVo> getArticle() {
        //添加条件构造器
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("b_id","b_name","b_create_date","b_update_date","b_like","b_tag");
        List<Article> list = this.list(queryWrapper);
        List<ArticleVo> vos = new ArrayList<>();

        //将查询到的数据转换为Vo
        for (Article article : list) {
            ArticleVo vo = new ArticleVo();
            BeanUtils.copyProperties(article,vo);
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public Boolean saveArticle(ArticleCmd cmd) {
        ArticleCo articleCo = cmd.getArticleCo();
        if (articleCo.getBName().isEmpty() || articleCo.getBContent().isEmpty() ){
            throw new BaseException(RCode.ARTICLE_NOT_ERROR);
        }
        //获取当前时间，作为博客文章保存的时间
        LocalDateTime now = LocalDateTime.now();
        articleCo.setBCreateDate(now);
        articleCo.setBUpdateDate(now);

        //默认点赞为0
        articleCo.setBLike(0);

        Article article = new Article();
        BeanUtils.copyProperties(articleCo,article);
        this.save(article);
        return Boolean.TRUE;
    }

    @Override
    public ArticleVo findArticle(ArticleDetailsCmd cmd) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("b_id",cmd.getId());
        Article article = this.getOne(queryWrapper);
        if (article == null){
            throw new BaseException(RCode.ARTICLE_DETAILS_ERROR);
        }
        ArticleVo vo = new ArticleVo();
        BeanUtils.copyProperties(article,vo);
        return vo;
    }

    @Override
    public Boolean updateArticle(ArticleCmd cmd) {
        ArticleCo articleCo = cmd.getArticleCo();
        //判断是否存在id
        if (articleCo == null || articleCo.getBId() == null){
            throw new BaseException(RCode.ARTICLE_NOT_NULL_ERROR);
        }
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("b_id",articleCo.getBId());
        Article one = this.getOne(queryWrapper);
        if (one == null){
            throw new BaseException(RCode.ARTICLE_DETAILS_ERROR);
        }
        Article article = new Article();
        BeanUtils.copyProperties(articleCo,article);
        this.saveOrUpdate(article);
        return Boolean.TRUE;
    }
}
