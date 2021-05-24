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
    public int getCountRows() {
        return sd.getCountRows();
    }

    @Override
    public boolean addStu(Students s) {
        int rows = sd.addStu(s);
        boolean res = true;
        if (rows == 0) {
            res = false;
        }
        return res;
    }

    @Override
    public Students getUpdateStu(Integer sid) {
        return sd.getUpdateStu(sid);
    }

    @Override
    public boolean updateStu(Students s) {
        int rows = sd.updateStu(s);
        boolean res = true;
        if (rows == 0) {
            res = false;
        }
        return res;
    }


    @Override
    public boolean deleteStuByName(Integer sid) {
        int rows = sd.deleteStuByName(sid);
        boolean res = true;
        if (rows == 0) {
            res = false;
        }
        return res;
    }

    @Override
    public boolean deleteStuById(Integer sid) {
        int rows = sd.deleteStuById(sid);
        boolean res = true;
        if (rows == 0) {
            res = false;
        }
        return res;
    }

    @Override
    public List<Students> deleteUpdateStusByPage(PageUtil pu) {
        return sd.deleteUpdateStusByPage(pu);
    }

    @Override
    public boolean deleteAll(String sids) {
        int rows = sd.deleteAll(sids);
        boolean res = true;
        if (rows == 0) {
            res = false;
        }
        return res;
    }

    @Override
    public int getCountRowsBySname(String queryName) {
        return sd.getCountRowsBySname(queryName);
    }

    @Override
    public List<Students> queryStudentByName(String queryName, PageUtil pu) {
        return sd.queryStudentByName(queryName, pu);
    }
}
