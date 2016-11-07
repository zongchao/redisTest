package com.neko.service.user;

import com.neko.dao.po.Invest;
import com.neko.dao.po.User;

/**
 * Created by ssjk on 2016/10/31.
 */
public interface UserService {

    User findUserById(Integer id);

    void insertUser(User user);

    void invest(Invest invest);
}
