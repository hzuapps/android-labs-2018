package com.example.administrator.hzulife.model.bean;

import android.graphics.Bitmap;

/**
 * <pre>
 *     author : 蔡文豪
 *     e-mail : 1261654234@qq.com
 *     time   : 2018/5/1
 *     desc   : 用户
 *     version: 1.0
 * </pre>
 */

public class User{
    private String sex;//性别
    private String name;//姓名
    private String bj;//班级
    private String yx;//院系
    private String zy;//专业
    private String birthday;//生日
    private String place;//老家
    private Bitmap headpic;
    private String room;//寝室号
    private String nickname;//昵称
    private String pwd;//可见的pwd
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBj() {
        return bj;
    }

    public void setBj(String bj) {
        this.bj = bj;
    }

    public String getYx() {
        return yx;
    }

    public void setYx(String yx) {
        this.yx = yx;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Bitmap getHeadpic() {
        return headpic;
    }

    public void setHeadpic(Bitmap headpic) {
        this.headpic = headpic;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


}
