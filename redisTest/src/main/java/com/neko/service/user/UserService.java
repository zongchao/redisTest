package com.neko.service.user;

import com.neko.dao.po.Invest;
import com.neko.dao.po.User;

/**
 * Created by ssjk on 2016/10/31.
 */
public interface UserService {

    User findUserById(int id);

    void invest(Invest invest);
}
