package edu.hzuapps.androidlabs.soft1613071002123.myapplication;

/**
 * Created by hww on 2018/5/25.
 */

public class File {
    private String name;

    private int imageId;

    public File(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
