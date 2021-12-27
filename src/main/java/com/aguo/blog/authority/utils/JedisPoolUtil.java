package com.aguo.blog.authority.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author Aguo
 * @Date: 2021/12/20/ 11:39
 */
@Configuration
public class JedisPoolUtil {

    @Value("${spring.redis.port}")
    private  Integer port;

    @Value("${spring.redis.host}")
    private  String host;

    @Value("${spring.redis.password}")
    private  String password;

    @Value("${spring.redis.jedis.pool.max-total}")
    private  Integer maxTotal;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private  Integer maxIdle;

    private JedisPool jedisPool;


    @Bean("jedis")
    public Jedis getJedis(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPool = new JedisPool(jedisPoolConfig, host,port,5000,password);
        return jedisPool.getResource();
    }

}
