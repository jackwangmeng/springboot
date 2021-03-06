package com.example.springbootconfig;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootConfigApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    void contextLoads() {
        logger.trace("这是trace日志..");
        logger.debug("这是debug日志...");
        logger.info("这是info日志..");
        logger.warn("warn");
        logger.error("error");
    }

}
