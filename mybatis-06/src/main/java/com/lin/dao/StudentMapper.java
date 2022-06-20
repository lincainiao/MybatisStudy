package com.lin.dao;

import com.lin.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getStuList();

    //查询所有学生及他们对应的老师信息
    List<Student> getStuListWithTea();
    List<Student> getStuListWithTea2();
}
