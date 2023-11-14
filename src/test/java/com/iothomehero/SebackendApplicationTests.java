package com.iothomehero;

import com.iothomehero.mapper.TriggerMapper;
import com.iothomehero.mapper.UserMapper;
import com.iothomehero.pojo.entity.User;
import com.iothomehero.pojo.entity.trigger.TriLocation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@SpringBootTest
class SebackendApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TriggerMapper triggerMapper;
    @Test
    public void testUserList(){
        List<User> userList = userMapper.getUserList();
        userList.stream().forEach(user -> {
            log.info(user.toString());
        });
    }

    @Test
    public void testtriLocationAdd(){
        TriLocation triLocation = new TriLocation(null,null,new BigDecimal("123.456999"),new BigDecimal("789.123"));
        triggerMapper.triLocationAdd(triLocation);
    }

}
