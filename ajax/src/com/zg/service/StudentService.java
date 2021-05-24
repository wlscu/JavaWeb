package com.zg.service;

import com.zg.entity.Students;
import com.zg.util.PageUtil;

import java.util.List;

/**
 * @author 隔壁老王
 */
public interface StudentService {
    List<Students> queryStudentByName(String queryName);
}
