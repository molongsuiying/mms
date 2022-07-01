package com.cn.java.dao;

import com.cn.java.pojo.MenuData;

import java.util.List;

public interface MenuMapper {
    List<MenuData> selectMenu();
}
