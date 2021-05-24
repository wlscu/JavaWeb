package com.zg.dao.impl;

import com.zg.dao.StudentDao;
import com.zg.entity.Students;
import com.zg.util.PageUtil;
import com.zg.util.QueryRunnerUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 隔壁老王
 */
public class StudentDaoImpl implements StudentDao {
    private QueryRunner qr = QueryRunnerUtil.getQueryRunner();

    /**
     * 获取学生表数据条数
     *
     * @return 返回总条数
     */
    @Override
    public int getCountRows() {
        int countRows = 0;
        String sql = "select count(*) from students";
        try {
            countRows = (int) (long) qr.query(sql, new ScalarHandler<>());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return countRows;
    }

    /**
     * 添加学生
     *
     * @param s 需要添加的学生对象
     * @return 返回1表示添加成功，返回0表示添加失败
     */
    @Override
    public int addStu(Students s) {
        int rows = 0;
        String sql = "insert into students(sname,spassword,sage,ssex,semail,sphoto) values(?,?,?,?,?,?)";
        try {
            rows = qr.update(sql, s.getSname(), s.getSpassword(), s.getSage(), s.getSsex(), s.getSemail(), s.getSphoto());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rows;
    }

    /**
     * 查询要修改的学生
     *
     * @param sid 查询的学生的sid
     * @return 返回查询的单个学生对象
     */
    @Override
    public Students getUpdateStu(Integer sid) {
        Students stu = null;
        String sql = "select * from students where sid=?";
        try {
            stu = qr.query(sql, new BeanHandler<>(Students.class), sid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return stu;
    }

    /**
     * 修改学生
     *
     * @param s 需要修改的学生对象
     * @return 返回1表示修改成功，返回0表示修改失败
     */
    @Override
    public int updateStu(Students s) {
        int rows = 0;
        String sql = "update students set sname=?,spassword=?,sage=?,ssex=?,semail=?,sphoto=? where sid=?";
        try {
            rows = qr.update(sql, s.getSname(), s.getSpassword(), s.getSage(), s.getSsex(), s.getSemail(), s.getSphoto(), s.getSid());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rows;
    }

    /**
     * 根据名字搜索删除单个学生
     * @param sid 单个学生对象的学号
     * @return 返回1表示删除成功，返回0表示删除失败
     */
    @Override
    public int deleteStuByName(Integer sid) {
        int rows = 0;
        String sql = "delete from students where sid=?";
        try {
            rows = qr.update(sql, sid);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rows;
    }

    /**
     * 通过ID删除单个学生
     * @param sid 单个学生对象的学号
     * @return 返回1表示删除成功，返回0表示删除失败
     */
    @Override
    public int deleteStuById(Integer sid) {
        int rows = 0;
        String sql = "delete from students where sid=?";
        try {
            rows = qr.update(sql, sid);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rows;
    }


    /**
     * 通过分页查看要删除/修改的学生
     *
     * @param pu 分页的工具类对象
     * @return 返回分页后的学生数据集合
     */
    @Override
    public List<Students> deleteUpdateStusByPage(PageUtil pu) {
        List<Students> list = null;
        String sql = "select * from students limit ?,?";
        try {
            list = qr.query(sql, new BeanListHandler<>(Students.class), pu.getIndex(), pu.getRows());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    /**
     * 批量删除学生
     * @param sids 获取的多个学生参数
     * @return 返回删除条数，0为删除失败
     */
    @Override
    public int deleteAll(String sids) {
        int rows = 0;
        String sql = "delete from students where sid in(" + sids + ")";
        try {
            rows = qr.update(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    /**
     * 通过名字获取学生记录数
     * @param queryName 查询的学生名
     * @return 返回查询数
     */
    @Override
    public int getCountRowsBySname(String queryName) {
        int countRows = 0;
        String sql = "select count(*) from students where sname like '%" + queryName + "%'";
        try {
            countRows = (int) (long) qr.query(sql, new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }

    /**
     * 返回通过名字获取学生对象集合
     * @param queryName 查询的学生名
     * @param pu 分页工具
     * @return 学生对象集合
     */
    @Override
    public List<Students> queryStudentByName(String queryName, PageUtil pu) {
        List<Students> list = null;
        String sql = "select * from students where sname like '%" + queryName + "%' limit ?,?";
        try {
            list = qr.query(sql, new BeanListHandler<>(Students.class), pu.getIndex(), pu.getRows());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
