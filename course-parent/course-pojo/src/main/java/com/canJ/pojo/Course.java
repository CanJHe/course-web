package com.canJ.pojo;

public class Course {
    private Integer courid;

    private Integer studentid;

    private Integer teacherid;

    private String cournumber;

    private String courname;

    private Integer courcredit;

    private Integer courgrade;

    public Integer getCourid() {
        return courid;
    }

    public void setCourid(Integer courid) {
        this.courid = courid;
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

    public String getCournumber() {
        return cournumber;
    }

    public void setCournumber(String cournumber) {
        this.cournumber = cournumber == null ? null : cournumber.trim();
    }

    public String getCourname() {
        return courname;
    }

    public void setCourname(String courname) {
        this.courname = courname == null ? null : courname.trim();
    }

    public Integer getCourcredit() {
        return courcredit;
    }

    public void setCourcredit(Integer courcredit) {
        this.courcredit = courcredit;
    }

    public Integer getCourgrade() {
        return courgrade;
    }

    public void setCourgrade(Integer courgrade) {
        this.courgrade = courgrade;
    }
}