package com.zg.entity;

/**
 * @author 隔壁老王
 */
public class Users {
    private Integer userid;
    private String username;
    private String password;
    private String sex;
    private String email;
    private String photo;

    public Users() {
    }

    public Users(Integer userid, String username, String password, String sex, String email, String photo) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.email = email;
        this.photo = photo;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
