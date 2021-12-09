package com.aguo.blog.article.service.impl;

import com.aguo.blog.article.entity.Article;
import com.aguo.blog.article.mapper.ArticleMapper;
import com.aguo.blog.article.service.IArticleService;
import com.aguo.blog.article.vo.ArticleVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("b_id","b_name","b_create_date","b_update_date","b_like","b_tag");
        List<Article> list = this.list();
        List<ArticleVo> vos = new ArrayList<>();
        for (Article article : list) {
            ArticleVo vo = new ArticleVo();
            BeanUtils.copyProperties(article,vo);
            vos.add(vo);
        }
        return vos;
    }
}
