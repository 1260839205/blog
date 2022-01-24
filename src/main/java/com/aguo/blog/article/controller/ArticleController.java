package com.aguo.blog.article.controller;


import com.aguo.blog.article.domainmodel.ArticleCmd;
import com.aguo.blog.article.domainmodel.ArticleDetailsCmd;
import com.aguo.blog.article.service.IArticleService;
import com.aguo.blog.article.vo.ArticleVo;
import com.aguo.blog.response.annotation.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public List<ArticleVo> getArticles(){
        //ClassLoader
        return service.getArticle();
    }

    @PostMapping
    @ApiOperation(value = "保存一篇文章")
    public Boolean saveArticle(@RequestBody @Validated ArticleCmd cmd){
        return service.saveArticle(cmd);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "文章详情")
    public ArticleVo getArticle(@PathVariable(value = "id")String id, ArticleDetailsCmd cmd){
        cmd.setId(id);
        return service.findArticle(cmd);
    }

    @PutMapping
    @ApiOperation(value = "修改一篇文章")
    public Boolean updateArticle(@RequestBody @Validated ArticleCmd cmd){
        return service.updateArticle(cmd);
    }

}
