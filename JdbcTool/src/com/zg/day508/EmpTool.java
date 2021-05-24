package com.zg.day508;

import com.zg.day508.entity.Emp;
import com.zg.day508.util.QueryRunnerUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 隔壁老王
 */
public class EmpTool {
    QueryRunner qr = QueryRunnerUtil.getQueryRunner();

    /**
     * 通过C3P0ConnPools连接池类将emp表的所有内容存储到Emp的实体类集合中
     *
     * @return 所有Emp的实体类集合
     */
    public List<Emp> getAllEmp() {
        List<Emp> empList = new ArrayList<>();
        Connection conn = C3P0ConnPools.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from emp");
            rs = ps.executeQuery();
            while (rs.next()) {
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                int mgr = rs.getInt("mgr");
                Date hiredate = rs.getDate("hiredate");
                double sal = rs.getDouble("sal");
                double comm = rs.getDouble("comm");
                int deptno = rs.getInt("deptno");
                Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
                empList.add(emp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            C3P0ConnPools.closeConnection(ps, rs);
        }
        return empList;
    }

    /**
     * 通过DBUtil工具类来调用C3P0ConnPools连接池类将emp表的所有内容存储到Emp的实体类集合中
     *
     * @return 所有Emp的实体类集合
     */
    public List<Emp> dbUtilGetAllEmp() {
        List<Emp> list = new ArrayList<>();
        String sql = "select * from emp";
        try {
            list = qr.query(sql, new BeanListHandler<>(Emp.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    /**
     * 通过主键员工编码empno查询出一个员工对象
     *
     * @param empno 主键员工编码
     * @return 返回一个Emp的JavaBean对象
     */
    public Emp getEmpByEmpno(int empno) {
        Emp emp = null;
        String sql = "select * from emp where empno=?";
        try {
            emp = qr.query(sql, new BeanHandler<>(Emp.class), empno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    /**
     * 获取员工表中数据条数
     *
     * @return 返回一个int类型的记录条数数据
     */
    public int getCountRows() {
        int countRows = 0;
        String sql = "select count(*) from emp";
        try {
            countRows = (int) (long) qr.query(sql, new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }

    /**
     * 新增Emp
     *
     * @param e 为传递进来要新增的EMP对象
     * @return 返回新增后受影响的行数，0为失败，1为成功
     */
    public int addEmp(Emp e) {
        int rows = 0;
        String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
        try {
            rows = qr.update(sql, e.getEmpno(), e.getEname(), e.getJob(), e.getMgr(), e.getHiredate(), e.getSal(), e.getComm(), e.getDeptno());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rows;
    }

    /**
     * 删除Emp
     *
     * @param empno 通过传递进来的员工编码empno来删除
     * @return 返回删除后受影响的行数，0为失败，1为成功
     */
    public int delEmpByEmpno(int empno) {
        int rows = 0;
        String sql = "delete from emp where empno=?";
        try {
            rows = qr.update(sql, empno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * 修改Emp
     *
     * @param e 为传递进来要修改的EMP对象
     * @return 返回修改后受影响的行数，0为失败，1为成功
     */
    public int updateEmp(Emp e) {
        int rows = 0;
        String sql = "update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?";
        try {
            rows = qr.update(sql, e.getEname(), e.getJob(), e.getMgr(), e.getHiredate(), e.getSal(), e.getComm(), e.getDeptno(), e.getEmpno());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rows;
    }
}

