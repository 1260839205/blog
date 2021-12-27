package com.aguo.blog.authority.filter;

import com.aguo.blog.authority.utils.JWTTokenUtil;
import com.aguo.blog.response.code.RCode;
import com.aguo.blog.response.error.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Aguo
 * @Date: 2021/12/08/ 9:34
 */
@Component
@Slf4j
public class TokenHandler implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String token = request.getHeader("Authentication");
        if (token != null){
            boolean result = JWTTokenUtil.verify(token);
            if(result){
                log.info("通过拦截器");
                return true;
            }
        }

        throw new BaseException(RCode.LOGIN_TOKEN_ERROR);
    }

}
