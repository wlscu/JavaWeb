package com.zg.day508;

import java.sql.*;

/**
 * @author 隔壁老王
 */
public class JdbcTool {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return 返回一个数据库连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/alwaysonline?serverTimezone=UTC","root","333");
    }

    /**
     *
     * @param rs 查询结果集
     * @param ps  数据库操作对象
     * @param conn 数据库连接对象
     */
    public static void closeSource(ResultSet rs, Statement ps,Connection conn){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
