package com.zg.service.impl;

import com.zg.dao.impl.UserDaoImpl;
import com.zg.entity.Users;
import com.zg.service.UserService;

/**
 * @author 隔壁老王
 */
public class UserServiceImpl implements UserService {
    UserDaoImpl ud = new UserDaoImpl();

    @Override
    public boolean addUser(Users user) {
        int rows = ud.addUser(user);
        // rows==0时返回false,rows==1时返回true;
        return rows != 0;
    }

    @Override
    public boolean loginUser(String username, String password) {
        Users user = ud.loginUser(username, password);
        // user == null时返回false,rows != null时返回true;
        return user != null;
    }
}
