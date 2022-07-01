package com.cn.java.service.login;

import com.cn.java.pojo.Account;

import java.sql.SQLException;

public interface LoginService {
    Account searchName(String name) throws SQLException;
}
