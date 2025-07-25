package com.java.JpaWithHibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Courses {

    @Id
    private int courseCode;

    private String courseName;

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

    @Override
    public String toString() {
        return "Courses{" +
                "courseCode=" + courseCode +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
