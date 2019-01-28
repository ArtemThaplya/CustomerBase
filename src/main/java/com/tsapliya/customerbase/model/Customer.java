package com.tsapliya.customerbase.model;

import java.util.Date;

public class Customer {
    private int id;
    private String fullName;
    private Date date;
    private long inn;

    private String familyStatus;
    private String education;
    private StatusCustomer status;

    public StatusCustomer getStatus() {
        return status;
    }

    public void setStatus(StatusCustomer status) {
        this.status = status;
    }

    public long getInn() {
        return inn;
    }

    public void setInn(long inn) {
        this.inn = inn;
    }

    public String getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}  