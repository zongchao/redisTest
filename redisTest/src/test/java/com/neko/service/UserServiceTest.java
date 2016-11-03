package com.neko.service;

import com.neko.dao.po.User;
import com.neko.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ssjk on 2016/11/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void test(){
//        User user = new User();
//        user.setUsername("test2");
//        user.setPassword("1111");
//        userService.insertUser(user);
        User user = userService.findUserById(2);
//        System.out.println(user.getUsername());
    }


}
