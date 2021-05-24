package com.zg.dao;

import com.zg.entity.Students;
import com.zg.util.PageUtil;

import java.util.List;

/**
 * @author 隔壁老王
 */
public interface StudentDao {

    /**
     * 查询所有学生数据条数
     *
     * @return 返回总记录数
     */
    int getCountRows();

    /**
     * 添加学生对象
     *
     * @param s 前端传递的Students对象
     * @return 返回1表示添加成功，0表示添加失败
     */
    int addStu(Students s);

    /**
     * 查询要修改的学生
     *
     * @param sid 学生编号
     * @return 返回学生对象
     */
    Students getUpdateStu(Integer sid);

    /**
     * 修改学生
     *
     * @param s 需要修改的学生对象
     * @return 返回1表示修改成功，返回0表示修改失败
     */
    int updateStu(Students s);

    /**
     * 根据名字搜索删除单个学生
     *
     * @param sid 单个学生的学号
     * @return 返回1表示删除成功，返回0表示删除失败
     */
    int deleteStuByName(Integer sid);

    /**
     * 根据ID搜索删除单个学生
     * @param sid 单个学生的学号
     * @return 返回1表示删除成功，返回0表示删除失败
     */
    int deleteStuById(Integer sid);

    /**
     * 通过分页查看要删除/修改的学生
     *
     * @param pu 分页的工具类对象
     * @return 返回分页后的学生数据集合
     */
    List<Students> deleteUpdateStusByPage(PageUtil pu);

    /**
     * 批量删除学生
     * @param ids 获取的多个学生参数
     * @return 返回删除条数，0为删除失败
     */
    int deleteAll(String ids);

    /**
     * 通过名字获取学生记录数
     * @param queryName 查询的学生名
     * @return 返回查询数
     */
    public int getCountRowsBySname(String queryName);

    /**
     * 返回通过名字获取学生对象集合
     * @param queryName 查询的学生名
     * @param pu 分页工具
     * @return 学生对象集合
     */
    public List<Students> queryStudentByName(String queryName, PageUtil pu);
}
