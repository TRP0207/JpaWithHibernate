package com.java.JpaWithHibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address_table")
public class Address {

    @Id
    private int id;

    private String addLine1;

    private String addLine2;

    private int pinCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddLine1() {
        return addLine1;
    }

    public void setAddLine1(String addLine1) {
        this.addLine1 = addLine1;
    }

    public String getAddLine2() {
        return addLine2;
    }

    public void setAddLine2(String addLine2) {
        this.addLine2 = addLine2;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addLine1='" + addLine1 + '\'' +
                ", addLine2='" + addLine2 + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }
}
