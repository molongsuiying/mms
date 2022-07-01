package com.cn.java.pojo;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Account {
    private String username;
    private String pwd;

    public Account() {
    }

    public Account(String name, String pwd) {
        this.username = name;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(username, account.username) && Objects.equals(pwd, account.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, pwd);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
