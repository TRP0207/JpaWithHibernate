package com.java.JpaWithHibernate.model;

import java.util.List;
import java.util.Set;

public class StudentDTO {

    private String name;
    private String marks;
    private List<Integer> courseCodes;
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
