package com.cn.java.pojo;

public class MenuData {
    private int id;
    private String title;
    private String href;
    private String icon;
    private String target;

    public MenuData() {
    }

    public MenuData(int id, String title, String href, String icon, String target) {
        this.id = id;
        this.title = title;
        this.href = href;
        this.icon = icon;
        this.target = target;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
