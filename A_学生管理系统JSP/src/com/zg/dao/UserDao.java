package com.zg.dao;

import com.zg.entity.Users;

/**
 * @author 隔壁老王
 */
public interface UserDao {

    /**
     * 管理用户的新增接口
     *
     * @param u 传递一个Users对象进行数据库添加
     * @return 返回是否添加成功，返回值不等于0代表添加成功
     */
    int addUser(Users u);

    /**
     * 用户的登录接口
     *
     * @param username 登录的用户名
     * @param password 登录的密码
     * @return 返回数据库对比后的User对象，如果为null代表登录失败
     */
    Users loginUser(String username, String password);
}
