package com.zg.dao;

import com.zg.entity.Students;
import com.zg.util.PageUtil;

import java.util.List;

public interface StudentDao {
    List<Students> queryStudentByName(String queryName);
}
