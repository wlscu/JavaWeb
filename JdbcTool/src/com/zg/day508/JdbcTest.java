package com.zg.day508;

import java.sql.*;

/**
 * @author 隔壁老王
 */
public class JdbcTest {
    public static void main(String[] args) {
        Connection conn =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1、注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2、创建连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/alwaysonline?serverTimezone=UTC","root","333");
            // 3、创建连接对象
            String sql = "select ?,? from emp";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"empno");
            ps.setString(2,"ename");
            // 4、执行sql语句
            rs = ps.executeQuery();
            // 5、处理查询结果集
            while (rs.next()){
                String ename = rs.getString("ename");
                String empno = rs.getString("empno");
                System.out.println("员工编号是："+empno+",员工名是："+ename);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
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
}
