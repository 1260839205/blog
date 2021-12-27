package com.aguo.blog;

import com.aguo.blog.article.entity.Article;
import com.aguo.blog.article.mapper.ArticleMapper;
import com.aguo.blog.authority.utils.JedisPoolUtil;
import com.aguo.blog.user.entity.User;
import com.aguo.blog.user.mapper.UserMapper;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jdk.nashorn.internal.scripts.JD;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
		User user = userMapper.selectOne(userQueryWrapper);
		System.out.println(user);
		//Jedis jedis = JedisPoolUtil.getJedis();
		//jedis.hset("user","username",);
	}


	@Test
	void testText(){
		QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("b_id","c5772e56c6d0908799de550e6aab75e0");
		Article article = mapper.selectOne(queryWrapper);
	}

	@Test
	void test1(){
		Predicate<Integer> condition = (num) -> num > 0;
		Predicate<Integer> condition2 = (num) -> num < -1;
		System.out.println(condition.or(condition2).test(-2));

		Consumer<String> con=(str)->System.out.println(str);
		con.accept("我是消费型接口!");
	}

	@Autowired()
	@Qualifier("jedis")
	private Jedis jedis;

	@Test
	void test3(){
		jedis.set("test", "成功");
		String test = jedis.get("test");
		System.out.println(test);
	}

	@Test
	void test4(){
		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		year = year.substring(year.length() - 2);
		System.out.println(year);
	}

}
