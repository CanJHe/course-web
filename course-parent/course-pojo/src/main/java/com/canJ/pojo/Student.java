package com.canJ.pojo;

public class Student {
    private Integer studentid;

    private String name;

    private String password;

    private String stuPhone;

    private Integer stuClass;

    private String selfdescn;

    private Short stuState;

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone == null ? null : stuPhone.trim();
    }

    public Integer getStuClass() {
        return stuClass;
    }

    public void setStuClass(Integer stuClass) {
        this.stuClass = stuClass;
    }

    public String getSelfdescn() {
        return selfdescn;
    }

    public void setSelfdescn(String selfdescn) {
        this.selfdescn = selfdescn == null ? null : selfdescn.trim();
    }

    public Short getStuState() {
        return stuState;
    }

    public void setStuState(Short stuState) {
        this.stuState = stuState;
    }
}