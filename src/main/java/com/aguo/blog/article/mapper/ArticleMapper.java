package com.aguo.blog.article.mapper;

import com.aguo.blog.article.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author aguo
 * @since 2021-12-08
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {

}
