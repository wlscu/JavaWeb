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

public class StudentDaoImpl implements StudentDao {
    private QueryRunner qr = QueryRunnerUtil.getQueryRunner();

    @Override
    public List<Students> queryStudentByName(String queryName) {
        List<Students> list = null;
        String sql = "select * from students where sname like '%"+queryName+"%'";
        try {
            list = qr.query(sql, new BeanListHandler<>(Students.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
