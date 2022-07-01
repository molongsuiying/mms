package com.cn.java.service.login;

import com.cn.java.dao.SelectMapper;
import com.cn.java.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private SelectMapper sm;
    @Override
    public Account searchName(String name) throws SQLException {
        return sm.selectName(name);
    }
}
