package com.java.JpaWithHibernate.service;

import com.java.JpaWithHibernate.model.Student;
import com.java.JpaWithHibernate.model.StudentRequestDTO;
import com.java.JpaWithHibernate.model.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    public String saveStudent(StudentRequestDTO student) throws Exception;
    public List<StudentResponseDTO> findUserByName(String name);
    public List<StudentResponseDTO> getAllStudents();
    public void deleteStudent(int id);
    public void saveAllStudents(List<StudentRequestDTO> students);
}
