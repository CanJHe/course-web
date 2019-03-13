package com.canJ.pojo;

public class Teacher {
    private Integer teacherid;

    private String name;

    private String teaPhone;

    private String password;

    private String subject;

    private String selfdescn;

    private Short teState;

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTeaPhone() {
        return teaPhone;
    }

    public void setTeaPhone(String teaPhone) {
        this.teaPhone = teaPhone == null ? null : teaPhone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getSelfdescn() {
        return selfdescn;
    }

    public void setSelfdescn(String selfdescn) {
        this.selfdescn = selfdescn == null ? null : selfdescn.trim();
    }

    public Short getTeState() {
        return teState;
    }

    public void setTeState(Short teState) {
        this.teState = teState;
    }
}