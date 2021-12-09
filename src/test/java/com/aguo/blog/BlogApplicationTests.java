package com.aguo.blog;

import com.aguo.blog.article.entity.Article;
import com.aguo.blog.article.mapper.ArticleMapper;
import com.aguo.blog.user.entity.User;
import com.aguo.blog.user.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

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

}
