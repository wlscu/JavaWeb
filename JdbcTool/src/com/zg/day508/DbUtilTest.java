package com.zg.day508;

import com.zg.day508.entity.Emp;

import java.util.List;

/**
 * @author 隔壁老王
 */
public class DbUtilTest {
    public static void main(String[] args) {
        EmpTool empTool = new EmpTool();
        List<Emp> list1 = empTool.dbUtilGetAllEmp();
        List<Emp> list2 = empTool.getAllEmp();
        Emp emp1 = empTool.getEmpByEmpno(7369);
        int count = empTool.getCountRows();

        for (Emp emp:list1) {
            String ename = emp.getEname();
            int empno = emp.getEmpno();
            System.out.println("员工："+ename+"，员工编号："+empno);
        }
        for (Emp emp:list2) {
            String job = emp.getJob();
            double sal = emp.getSal();
            System.out.println("职位："+job+"，员工工资："+sal);
        }
        System.out.println(emp1.toString());
        System.out.println("表数据条数："+count);

    }
}
