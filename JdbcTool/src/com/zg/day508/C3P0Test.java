package com.zg.day508;

import java.sql.*;

/**
 * @author 隔壁老王
 */
public class C3P0Test {
    public static void main(String[] args) {
        Connection conn = C3P0ConnPools.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select ename,empno from emp2");
            rs = ps.executeQuery();
            while (rs.next()){
                String ename = rs.getString("ename");
                int empno = rs.getInt("empno");
                System.out.println("编号："+empno+"，姓名："+ename);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            C3P0ConnPools.closeConnection(ps,rs);
        }
    }
}
