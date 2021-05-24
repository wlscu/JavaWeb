package com.zg.day508;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 隔壁老王
 */
public class C3P0ConnPools {
    private static ComboPooledDataSource ds = new ComboPooledDataSource();
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();
    /**
     * conn调用ThreadLocal的get方法获取getConnection中锁定的同一个连接对象，保证线程安全
     * @return 通过c3p0创建数据库连接并返回连接对象
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = tl.get();
            if (conn == null){
                conn = ds.getConnection();
                tl.set(conn);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    /**
     * conn调用ThreadLocal的get方法获取getConnection中锁定的同一个连接对象，保证线程安全
     * @param ps 数据库操作对象
     * @param rs 查询结果集
     */
    public static void closeConnection(Statement ps, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
       Connection conn = tl.get();
        tl.remove();
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
