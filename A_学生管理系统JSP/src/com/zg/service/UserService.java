package com.zg.service;

import com.zg.entity.Users;

/**
 * @author 隔壁老王
 */
public interface UserService {
    /**
     * 用户添加
     * @param user servlet生成的user对象
     * @return 返回user对象在CrudDao是否添加成功，true为成功，false为失败
     */
    boolean addUser(Users user);

    /**
     * 用户登录
     * @param username 登录填写的用户名
     * @param password 登录填写的密码
     * @return 返回通过帐号密码是否能在CrudDao查询到对应的用户对象，true为有则登陆成功，false为失无则登录失败
     */
    boolean loginUser(String username, String password);

}
