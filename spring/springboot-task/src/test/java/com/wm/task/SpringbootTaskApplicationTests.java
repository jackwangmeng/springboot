package com.wm.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;
	@Test
	void contextLoads() {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("通知-今晚开会");
        mailMessage.setText("今晚7:30开会");
        mailMessage.setTo("wangmengwangyi2@163.com");
        mailMessage.setFrom("3290252143@qq.com");
        mailSender.send(mailMessage);
	}

}
