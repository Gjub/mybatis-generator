package com.jxkj.manage.pojo;

public class User {
    private Long userId;

    private String name;

    private String password;

    private String tel;

    public User(Long userId, String name, String password, String tel) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.tel = tel;
    }

    public User() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }
}