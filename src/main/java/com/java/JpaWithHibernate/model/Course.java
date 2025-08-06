package com.java.JpaWithHibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    private int courseCode;

    private String courseName;

    @ManyToMany(mappedBy = "course")
    @JsonIgnore
    private List<Student> students = new ArrayList<>();

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "courseCode=" + courseCode +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
