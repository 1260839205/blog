package com.aguo.blog;

import com.aguo.blog.article.entity.Article;
import com.aguo.blog.article.mapper.ArticleMapper;
import com.aguo.blog.user.entity.User;
import com.aguo.blog.user.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
class BlogApplicationTests {
	@Resource
	private ArticleMapper mapper;

	@Resource
	private UserMapper userMapper;

	@Test
	void contextLoads() {
		Article article = new Article();
		article.setBLike(0);
		article.setBName("测试");
		article.setBTag("{java,spring}");
		article.setBCreateDate(LocalDateTime.now());
		article.setBUpdateDate(LocalDateTime.now());
		System.out.println(LocalDateTime.now());
		mapper.insert(article);
	}

	@Test
	void selectUser(){
		QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
		userQueryWrapper.eq("id",1);
		System.out.println(userMapper.selectOne(userQueryWrapper));
	}


	@Test
	void testText(){
		QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("b_id","c5772e56c6d0908799de550e6aab75e0");
		Article article = mapper.selectOne(queryWrapper);
	}

}
