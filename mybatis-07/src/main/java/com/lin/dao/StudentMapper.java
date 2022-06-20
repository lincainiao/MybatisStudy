package com.lin.dao;

import com.lin.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    List<Student> getStuList(Map<String,Integer> map);
}
