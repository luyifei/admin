package com.admin.system.model;

import java.util.Date;

public class SystemUser {
    private Long id;

    private String userName;

    private String password;

    private String name;

    private Byte status;

    private String remark;

    private String skin;

    private String email;

    private String number;

    private String phone;

    private String googleAuth;

    private Boolean googleAuthStatus;

    private Date gmtCreate;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin == null ? null : skin.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getGoogleAuth() {
        return googleAuth;
    }

    public void setGoogleAuth(String googleAuth) {
        this.googleAuth = googleAuth == null ? null : googleAuth.trim();
    }

    public Boolean getGoogleAuthStatus() {
        return googleAuthStatus;
    }

    public void setGoogleAuthStatus(Boolean googleAuthStatus) {
        this.googleAuthStatus = googleAuthStatus;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "SystemUser [id=" + id + ", userName=" + userName + ", password=" + password + ", name=" + name
                + ", status=" + status + ", remark=" + remark + ", skin=" + skin + ", email=" + email + ", number="
                + number + ", phone=" + phone + ", googleAuth=" + googleAuth + ", googleAuthStatus=" + googleAuthStatus
                + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
    }

}