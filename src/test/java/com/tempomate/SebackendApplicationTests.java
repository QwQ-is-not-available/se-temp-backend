package com.tempomate;

import com.tempomate.mapper.TriggerMapper;
import com.tempomate.mapper.UserMapper;
import com.tempomate.pojo.entity.User;
import com.tempomate.pojo.entity.trigger.TriLocation;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class SebackendApplicationTests {

//    @Test
//    void contextLoads() {
//    }
//    @Autowired
//    private UserMapper userMapper;
//    @Autowired
//    private TriggerMapper triggerMapper;
//    @Test
//    public void testUserList(){
//        List<User> userList = userMapper.getUserList();
//        userList.stream().forEach(user -> {
//            log.info(user.toString());
//        });
//    }
//
//    @Test
//    public void testtriLocationAdd(){
//        TriLocation triLocation = new TriLocation(null,null,new BigDecimal("123.456999"),new BigDecimal("789.123"));
//        triggerMapper.triLocationAdd(triLocation);
//    }
//
//    @Test
//    public void testGenJWT(){
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("userId","aabbcc");
//        claims.put("name","a1b2c3");
//        String jwt = Jwts.builder()
//                .signWith(SignatureAlgorithm.HS256,"miyao")
//                .setClaims(claims)
//                .setExpiration(new Date(System.currentTimeMillis()+3600*1000)) //1h
//                .compact();
//        System.out.println(jwt);
//    }
//
//    @Test
//    public void testParseJWT(){
//        Claims claims = Jwts.parser()
//                .setSigningKey("miyao")
//                .parseClaimsJws("")
//                .getBody();
//        System.out.println(claims);
//    }

}
