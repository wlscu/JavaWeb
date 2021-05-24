package com.zg.day508;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 隔壁老王
 */
public class JdbcTest2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // 1、注册驱动并创建数据库连接对象,关闭自动提交开启事务
        try {
            conn = JdbcTool.getConnection();
            conn.setAutoCommit(false);
            // 2、创建连接对象
            String sql = "select empno,ename from emp2";
            ps = conn.prepareStatement(sql);

            // 3、执行sql语句
            rs = ps.executeQuery();
            // 4、处理查询结果集
            while (rs.next()) {
                String ename = rs.getString("ename");
                String empno = rs.getString("empno");
                System.out.println("员工编号是：" + empno + ",员工名是：" + ename);
            }
            conn.commit();
        } catch (SQLException e) {
            if (conn != null){
                try {
                    conn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JdbcTool.closeSource(rs,ps,conn);
        }
    }
}