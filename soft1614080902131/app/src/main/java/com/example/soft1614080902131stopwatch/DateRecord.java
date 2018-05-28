package com.example.soft1614080902131stopwatch;

import org.litepal.crud.DataSupport;

public class DateRecord extends DataSupport{

    private int id;

    private int ImageId;
    private String date;
    private String time;
    private int recordN;
    private String remark;
    private int pictureId;
    private boolean isHavePicture=false;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public int getRecordN() {
        return recordN;
    }

    public void setRecordN(int recordN) {
        this.recordN = recordN;
    }

    public boolean isHavePicture() {
        return isHavePicture;
    }

    public void setHavePicture(boolean havePicture) {
        isHavePicture = havePicture;
    }
}
