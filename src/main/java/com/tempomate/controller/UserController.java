package com.tempomate.controller;

import com.tempomate.pojo.Result;
import com.tempomate.pojo.entity.User;
import com.tempomate.service.UserService;
import com.tempomate.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping ("/test")
    public Result test1(){
        log.info("hello world");
        return Result.success("hello world");
    }

    @GetMapping ("/test_token")
    public Result test1token(){
        log.info("hello world with token");
        return Result.success("hello world with token");
    }

    @PostMapping("/signup")
    public Result signup(@RequestBody User user){
        log.info("new user signup:{}",user.getUserId());
        userService.userSignup(user);
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("user try login:{}, password:{}",user.getUserId(),user.getPassword());
        Integer res = userService.login(user);
        if(res==1){
            Map<String, Object> claims = new HashMap<>();
            claims.put("userId",user.getUserId());
            //生成jwt
            String jwt = JwtUtils.generateJwt(claims);
            //存进redis
            redisTemplate.opsForValue().set(user.getUserId(),jwt,2, TimeUnit.HOURS);

            return Result.success(jwt);
        }else{
            return Result.error();
        }
    }

    @PutMapping("/rename-nickname")
    public Result change_nickname(@RequestBody User user){
        log.info("To change the ID of a nickname:{}",user.getUserId());
        Integer res = userService.change_nickname(user);
        //log.info("update amount:"+res);  //返回值可能可以用来判断异常情况
            // return value may be used to determine exceptional cases
        return Result.success(user.getNickname());
    }

    @PutMapping("/push_setting")
    public Result push_setting(@RequestBody User user){
        log.info("Toggling push notification setting for user with id:{}", user.getId());
        user.setPushSetting((short) (user.getPushSetting() == 1 ? 0 : 1));
        Integer res = userService.push_setting(user);
        if (res == 1) {
            return Result.success(user.getPushSetting());
        } else {
            return Result.error("Fail to toggle push setting");
        }
    }
}
