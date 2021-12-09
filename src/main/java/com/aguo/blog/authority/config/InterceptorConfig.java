package com.aguo.blog.authority.config;

import com.aguo.blog.authority.filter.TokenHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Aguo
 * @Date: 2021/12/08/ 9:33
 */
@Slf4j
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Resource
    private TokenHandler tokenHandler;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        String login = "/user/login";
        String[] swagger = {"/doc.html","/swagger-resources/**","/v2/**","/image/**","/webjars/**"};
        excludePath.add(login);
        registry.addInterceptor(tokenHandler).excludePathPatterns(excludePath).excludePathPatterns(swagger);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("doc.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
}
