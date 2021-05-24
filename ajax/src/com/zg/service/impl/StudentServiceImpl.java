package com.zg.service.impl;

import com.zg.dao.impl.StudentDaoImpl;
import com.zg.entity.Students;
import com.zg.service.StudentService;
import com.zg.util.PageUtil;

import java.util.List;

/**
 * @author 隔壁老王
 */
public class StudentServiceImpl implements StudentService {
    StudentDaoImpl sd = new StudentDaoImpl();

    @Override
    public List<Students> queryStudentByName(String queryName) {
        return sd.queryStudentByName(queryName);
    }
}
