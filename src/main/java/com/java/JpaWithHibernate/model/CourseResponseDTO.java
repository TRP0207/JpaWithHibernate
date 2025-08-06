package com.java.JpaWithHibernate.model;

import java.util.List;

public class CourseResponseDTO {
    private int courseCode;
    private String courseName;
    private List<StudentRequestDTO> students;

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

    public List<StudentRequestDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentRequestDTO> students) {
        this.students = students;
    }
}

