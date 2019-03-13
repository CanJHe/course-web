package com.canJ.pojo;

import java.security.PrivateKey;
import java.util.Date;

public class StuPost {
    private Integer PostId;
    private String stuName;
    private String content;
    private Integer stuId;
    private Date time;
    private short stuState;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getPostId() {
        return PostId;
    }

    public void setPostId(Integer postId) {
        PostId = postId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public short getStuState() {
        return stuState;
    }

    public void setStuState(short stuState) {
        this.stuState = stuState;
    }
}
