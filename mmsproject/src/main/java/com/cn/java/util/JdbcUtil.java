package com.cn.java.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.cn.java.pojo.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class JdbcUtil {
    static DruidDataSource dds = new DruidDataSource();
    static {
        dds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dds.setUrl("jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true");
        dds.setUsername("root");
        dds.setPassword("root");
        dds.setInitialSize(25);
        dds.setMaxActive(50);
    }
//    static Connection connection() throws SQLException {
//        Connection c = dds.getConnection();
//        return c;
//    }
//    @Test
    public Account serchUser(String name,String pwd) throws SQLException {
        Connection c = dds.getConnection();
        Statement ps = c.createStatement();
        ResultSet rs = ps.executeQuery("select * from account");
        while (rs.next()){
            if(rs.getString("name").equals(name)){
                if(rs.getString("pwd").equals(pwd)){
                    Account acc = new Account(name,pwd);
                    return acc;
                }else{
                    return null;
                }
            }else {
                return null;
            }
        }
        return null;
    }
//    public List<AreaName> getArea(int parentId) throws SQLException {
//
//        Connection c = dds.getConnection();
//        Statement ps = c.createStatement();
//        ResultSet rs = ps.executeQuery("select * from base_area where parentid="+parentId);
//        List<AreaName> list = new LinkedList<AreaName>();
//        while (rs.next()){
////            System.out.println(rs.getString("cityName"));
//            AreaName an = new AreaName();
//            an.setCodeId(rs.getInt("codeid"));
//            an.setParentId(rs.getInt("parentid"));
//            an.setCityName(rs.getString("cityName"));
//            list.add(an);
//        }
//        c.close();
//        return list;
//    }
}
