package com.canJ.pojo;

import java.util.Date;

public class Remark {
    private Integer remarkId;

    private Integer postidTea;

    private Integer postidStu;

    private String remarkContext;

    private Date remarkTime;

    private Integer studentid;

    private Integer teacherid;

    public Integer getRemarkId() {
        return remarkId;
    }

    public void setRemarkId(Integer remarkId) {
        this.remarkId = remarkId;
    }

    public Integer getPostidTea() {
        return postidTea;
    }

    public void setPostidTea(Integer postidTea) {
        this.postidTea = postidTea;
    }

    public Integer getPostidStu() {
        return postidStu;
    }

    public void setPostidStu(Integer postidStu) {
        this.postidStu = postidStu;
    }

    public String getRemarkContext() {
        return remarkContext;
    }

    public void setRemarkContext(String remarkContext) {
        this.remarkContext = remarkContext == null ? null : remarkContext.trim();
    }

    public Date getRemarkTime() {
        return remarkTime;
    }

    public void setRemarkTime(Date remarkTime) {
        this.remarkTime = remarkTime;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }
}