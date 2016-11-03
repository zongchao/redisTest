package com.neko.service.user.impl;

import com.neko.dao.mapper.InvestMapper;
import com.neko.dao.mapper.UserMapper;
import com.neko.dao.po.Invest;
import com.neko.dao.po.User;
import com.neko.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User findUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void invest(Invest invest) {

    }

}
