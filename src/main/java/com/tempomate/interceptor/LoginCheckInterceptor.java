package com.tempomate.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.tempomate.pojo.Result;
import com.tempomate.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        log.info("Enter interceptor");
        //获得请求头里的token Get the token in the request header
        String jwt = req.getHeader("token");

        //判断token是否为空 Determine whether the token is empty
        if(!StringUtils.hasLength(jwt)){
            log.info("request header token is empty");
            String notLogin = JSONObject.toJSONString(Result.error("not login"));
            resp.getWriter().write(notLogin);
            return false;
        }
        //尝试解析jwt Try to parse jwt
        try{
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("Failed to parse token, not login");
            String notLogin = JSONObject.toJSONString(Result.error("not login"));
            resp.getWriter().write(notLogin);
            return false;

        }
        //放行 release
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
