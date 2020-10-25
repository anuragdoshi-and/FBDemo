package com.example.fbdemo;

public class Details {
    String name;
    String issue;
    String device;
    String custid;

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
}
