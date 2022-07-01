package com.cn.java;

import com.cn.java.dao.MenuMapper;

public class Test {
    static MenuMapper m;

    public static void main(String[] args) {
        System.out.println(m.selectMenu());
    }
}
