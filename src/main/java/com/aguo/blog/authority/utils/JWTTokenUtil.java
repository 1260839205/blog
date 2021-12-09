package com.aguo.blog.authority.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Aguo
 * @Date: 2021/12/08/ 9:20
 */
@Slf4j
@Component
public class JWTTokenUtil {
    //设置过期时间
    private static final long EXPIRE_DATE=600000 * 6 * 24;
    //token秘钥
    private static final String TOKEN_SECRET = "CGfasfhuaUUHufguGuwu2021AGUO";

    public static String token (String username,String password){
        SimpleDateFormat formatter;
        Date date ;
        String token;
        try {
            formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //过期时间
            date = new Date(System.currentTimeMillis()+EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username",username)
                    .withClaim("password",password).withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        log.info("令牌过期时间："+formatter.format(date));
        log.info("申请令牌的用户为："+username);
        return token;
    }

    /**
     * @desc   验证token，通过返回true
     * @params [token]需要校验的串
     **/
    public static boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
}
