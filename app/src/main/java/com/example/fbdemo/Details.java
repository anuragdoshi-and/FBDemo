package com.example.fbdemo;

public class Details {
    public String name;
    public String issue;
    public String device;
    public String custid;

    public Details() {

    }

    public Details(String name, String issue, String device, String custid) {
        this.name = name;
        this.issue = issue;
        this.device = device;
        this.custid = custid;
    }

    public String getName() {
        return name;
    }

    public String getIssue() {
        return issue;
    }

    public String getDevice() {
        return device;
    }

    public String getCustid() {
        return custid;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }


}
