package com.java.JpaWithHibernate.model;

import java.util.List;

public class StudentRequestDTO {
    private String name;
    private String marks;
    private List<Integer> courseCodes; // only course codes for input
    private AddressRequestDTO address;

    // Getters and Setters
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

    public List<Integer> getCourseCodes() {
        return courseCodes;
    }

    public void setCourseCodes(List<Integer> courseCodes) {
        this.courseCodes = courseCodes;
    }

    public AddressRequestDTO getAddress() {
        return address;
    }

    public void setAddress(AddressRequestDTO address) {
        this.address = address;
    }
}
