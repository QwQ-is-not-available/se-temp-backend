package com.tempomate.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.tempomate.mapper.UserMapper;
import com.tempomate.pojo.Result;
import com.tempomate.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        log.info("Enter interceptor");
        //获得请求头里的token  Get the token in the request header
        String jwt = req.getHeader("token");

        //判断token是否为空  Determine whether the token is empty
        if(!StringUtils.hasLength(jwt)){
            log.info("request header token is empty");
            String notLogin = JSONObject.toJSONString(Result.error("not login"));
            resp.getWriter().write(notLogin);
            return false;
        }
        //尝试解析jwt  Try to parse jwt
        try{
            Map<String,Object> jwtMap = JwtUtils.parseJWT(jwt);
            String userId = (String)jwtMap.get("userId");
            log.info("userid in jwt:{}",userId);
//            log.info("jwt         :"+jwt);
//            log.info("jwt in redis:"+redisTemplate.opsForValue().get(userId));

            //redis版本缓存token开始
            //验证是否和redis里的一致  Verify whether it is consistent with the token in redis
//            if(!redisTemplate.opsForValue().get(userId).equals(jwt)){
//                throw new Exception("token is inconsistent");
//            }
            //redis版本缓存token结束

            //mysql版本的开始，需要手动在数据库中写入token
            String tokenInSQL = userMapper.getUserToken(userId);

            if(tokenInSQL==null || !tokenInSQL.equals(jwt)){
                throw new Exception("token is inconsistent");
            }
            //mysql版本的结束

        }catch (Exception e){
            log.info("Exception: "+e.getMessage());
            e.printStackTrace();

            log.info("Failed to parse token, not login");
            String notLogin = JSONObject.toJSONString(Result.error("not login"));
            resp.getWriter().write(notLogin);
            return false;

        }
        //放行  release
        log.info("Token qualified");
        return true;
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
}
