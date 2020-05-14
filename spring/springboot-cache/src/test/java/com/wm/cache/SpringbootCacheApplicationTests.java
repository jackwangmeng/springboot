package com.wm.cache;

import com.wm.cache.bean.Employee;
import com.wm.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootCacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    /*
    * 数据类型：String（字符串）、List(列表)、Set(集合)、Hash(散列)、ZSet(有序集合)*/
    @Test
    public void test1(){
//        stringRedisTemplate.opsForValue();
//        stringRedisTemplate.opsForList();
//        stringRedisTemplate.opsForSet();
//        stringRedisTemplate.opsForHash();
//        stringRedisTemplate.opsForZSet();
        stringRedisTemplate.opsForValue().append("msg","hello");
    }

    @Test
    void contextLoads() {
        Employee employee = new Employee();
        employee.setEmail("23");
        employee.setGender(1);
        employee.setLastName("1231");
        employee.setdId(2);
        employeeMapper.insertEmployee(employee);
    }

}
