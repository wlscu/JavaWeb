package com.zg.entity;

/**
 * @author 隔壁老王
 */
public class Students {
    private Integer sid;
    private String sname;
    private String spassword;
    private Integer sage;
    private String ssex;
    private String semail;
    private String sphoto;

    public Students() {
    }

    public Students(Integer sid, String sname, String spassword, Integer sage, String ssex, String semail, String sphoto) {
        this.sid = sid;
        this.sname = sname;
        this.spassword = spassword;
        this.sage = sage;
        this.ssex = ssex;
        this.semail = semail;
        this.sphoto = sphoto;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getSphoto() {
        return sphoto;
    }

    public void setSphoto(String sphoto) {
        this.sphoto = sphoto;
    }
}
