package com.java.JpaWithHibernate.model;

import java.util.ArrayList;
import java.util.List;

public class CourseRequestDTO {
    private int courseCode;
    private String courseName;
    private List<Integer> studentRollNos; // List of student IDs

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

    public List<Integer> getStudentRollNos() {
        return studentRollNos;
    }

    public void setStudentRollNos(List<Integer> studentRollNos) {
        this.studentRollNos = studentRollNos;
    }
}
