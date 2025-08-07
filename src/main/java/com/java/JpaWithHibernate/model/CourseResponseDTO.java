package com.java.JpaWithHibernate.model;

import com.java.JpaWithHibernate.repo.StudentRepository;

import java.util.List;

public class CourseResponseDTO {
    private int courseCode;
    private String courseName;
//    private List<StudentResponseDTO> students;

    // Getters and Setters
    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /*public List<StudentResponseDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentResponseDTO> students) {
        this.students = students;
    }*/
}

