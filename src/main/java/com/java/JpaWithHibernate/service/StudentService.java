package com.java.JpaWithHibernate.service;

import com.java.JpaWithHibernate.model.Student;
import com.java.JpaWithHibernate.model.StudentDTO;

import java.util.List;

public interface StudentService {
    public String saveStudent(StudentDTO student) throws Exception;
    public List<Student> findUserByName(String name);
    public List<Student> getAllStudents();
    public void deleteStudent(int id);
}
