package com.aguo.blog.article.controller;


import com.aguo.blog.article.service.IArticleService;
import com.aguo.blog.article.vo.ArticleVo;
import com.aguo.blog.response.annotation.BaseResponse;
import com.aguo.blog.user.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author aguo
 * @since 2021-12-08
 */
@Slf4j
@BaseResponse
@Api(tags = "文章接口", value = "文章表")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private IArticleService service;

    @GetMapping
    @ApiOperation(value = "查询所有文章")
    public List<ArticleVo> getArticle(){
        return service.getArticle();
    }
}
