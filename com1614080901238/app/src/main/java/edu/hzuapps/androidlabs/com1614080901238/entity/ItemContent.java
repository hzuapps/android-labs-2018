package edu.hzuapps.androidlabs.com1614080901238.mostbeautifulwallpaper.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 陈梓聪 on 2018/5/19.
 */

public class ItemContent implements Serializable {
    private int id;
    private String title;

    private List<String> comnent;

    public List<String> getComnent() {
        return comnent;
    }

    public void setComnent(List<String> comnent) {
        this.comnent = comnent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
