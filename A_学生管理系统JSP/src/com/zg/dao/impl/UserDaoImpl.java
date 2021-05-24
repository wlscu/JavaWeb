package com.zg.dao.impl;

import com.zg.dao.UserDao;
import com.zg.entity.Users;
import com.zg.util.QueryRunnerUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author 隔壁老王
 */
public class UserDaoImpl implements UserDao {
    private QueryRunner qr = QueryRunnerUtil.getQueryRunner();

    /**
     * 用户注册
     *
     * @param u 管理员（老师）对象
     * @return 返回1表示添加成功，返回0表示添加失败
     */
    @Override
    public int addUser(Users u) {
        int rows = 0;
        String sql = "insert into users(username,password,sex,email,photo) values(?,?,?,?,?)";
        try {
            rows = qr.update(sql, u.getUsername(), u.getPassword(), u.getSex(), u.getEmail(), u.getPhoto());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rows;
    }

    /**
     * 用户登录
     *
     * @param username web界面用户输入的用户名
     * @param password web界面用户输入的密码
     * @return 匹配则返回一个学生对象，不匹配返回null
     */
    @Override
    public Users loginUser(String username, String password) {
        Users user = null;
        String sql = "select * from users where username=? and password=?";
        try {
            user = qr.query(sql, new BeanHandler<>(Users.class), username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
