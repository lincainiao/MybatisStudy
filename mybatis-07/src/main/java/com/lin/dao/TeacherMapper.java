package com.lin.dao;

import com.lin.pojo.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    // 获取指定老师下的所有学生及老师信息
    List<Teacher> getTeaWithStu();

    List<Teacher> getTeaWithStu2(Map<String,Integer> map);
}
