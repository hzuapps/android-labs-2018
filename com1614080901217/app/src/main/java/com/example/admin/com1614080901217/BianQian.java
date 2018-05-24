package com.example.admin.com1614080901217;

/**
 * Created by admin on 2018/5/24.
 */

public class BianQian {
    private Integer id;
    private String title;
    private String content;

    public Integer getId() {
        return id;
    }

    public BianQian(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
