package com.neko.service.user.impl;

import com.neko.dao.mapper.InvestMapper;
import com.neko.dao.mapper.UserMapper;
import com.neko.dao.po.Invest;
import com.neko.dao.po.User;
import com.neko.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by ssjk on 2016/10/31.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    InvestMapper investMapper;

    @Override
    @Cacheable(key = "#id", value = "userCache")
    public User findUserById(int id) {
        System.out.println(123);
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @CachePut("#user.getName()")
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void invest(Invest invest) {

    }

}
