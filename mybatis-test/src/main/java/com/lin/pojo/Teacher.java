package com.lin.pojo;

import com.sun.jdi.connect.Connector;

import java.util.List;

public class Teacher {
    private int id;
    private String name;
    private List<Student> studentList;

    public Teacher() {
    }

    public Teacher(int id, String name, List<Student> studentList) {
        this.id = id;
        this.name = name;
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
