package com.iothomehero;

import com.iothomehero.mapper.UserMapper;
import com.iothomehero.pojo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class SebackendApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testUserList(){
        List<User> userList = userMapper.getUserList();
        userList.stream().forEach(user -> {
            log.info(user.toString());
        });
    }

}
