package com.cn.java.service.menu;

import com.cn.java.dao.MenuMapper;
import com.cn.java.pojo.MenuData;
import com.cn.java.util.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuMapper m;
    @Override
    public TableData selectAll() {
        TableData td = new TableData();
        List<MenuData> list =  m.selectMenu();
        td.setCode(0);
        td.setMsg("成功");
        td.setData(list);
        td.setCount(list.size());
        return td;
    }
}
