package com.java.JpaWithHibernate.service;

import com.java.JpaWithHibernate.model.Student;

import java.util.List;

public interface StudentService {
    public String saveStudent(Student student);
    public List<Student> findUserByName(String name);
}
