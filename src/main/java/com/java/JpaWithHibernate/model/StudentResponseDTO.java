package com.java.JpaWithHibernate.model;

import java.util.List;

public class StudentResponseDTO {
    private int rollNo;
    private String name;
    private String marks;
    private List<CourseResponseDTO> courses;
    private AddressResponseDTO address;

    // Getters and Setters
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public List<CourseResponseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseResponseDTO> courses) {
        this.courses = courses;
    }

    public AddressResponseDTO getAddress() {
        return address;
    }

    public void setAddress(AddressResponseDTO address) {
        this.address = address;
    }
}
