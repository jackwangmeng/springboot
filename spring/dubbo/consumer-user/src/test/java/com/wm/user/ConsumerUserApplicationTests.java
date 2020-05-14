package com.wm.user;

import com.wm.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ConsumerUserApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {

        userService.hello();
    }

}
