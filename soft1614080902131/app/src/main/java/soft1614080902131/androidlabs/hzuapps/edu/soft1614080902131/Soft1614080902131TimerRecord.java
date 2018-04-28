package soft1614080902131.androidlabs.hzuapps.edu.soft1614080902131;

/**
 * Created by 曾志超 on 2018/4/24.
 * 计时数据记录类
 */

public class Soft1614080902131TimerRecord {
    private int Id;

    //app第几次计时
    private int timerGroup;

    //

    //开始计时的时间
    private int startYear;
    private int startMonth;
    private int startDay;
    private int startHour;
    private int startMinute;
    private int startSecond;
    private int startSecondPoint;

    //计时时长
    private int usedDay;
    private int usedHour;
    private int usedMinute;
    private int usedSecond;
    private int usedSecondPoint;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getTimerGroup() {
        return timerGroup;
    }

    public void setTimerGroup(int timerGroup) {
        this.timerGroup = timerGroup;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getStartSecond() {
        return startSecond;
    }

    public void setStartSecond(int startSecond) {
        this.startSecond = startSecond;
    }

    public int getStartSecondPoint() {
        return startSecondPoint;
    }

    public void setStartSecondPoint(int startSecondPoint) {
        this.startSecondPoint = startSecondPoint;
    }

    public int getUsedDay() {
        return usedDay;
    }

    public void setUsedDay(int usedDay) {
        this.usedDay = usedDay;
    }

    public int getUsedHour() {
        return usedHour;
    }

    public void setUsedHour(int usedHour) {
        this.usedHour = usedHour;
    }

    public int getUsedMinute() {
        return usedMinute;
    }

    public void setUsedMinute(int usedMinute) {
        this.usedMinute = usedMinute;
    }

    public int getUsedSecond() {
        return usedSecond;
    }

    public void setUsedSecond(int usedSecond) {
        this.usedSecond = usedSecond;
    }

    public int getUsedSecondPoint() {
        return usedSecondPoint;
    }

    public void setUsedSecondPoint(int usedSecondPoint) {
        this.usedSecondPoint = usedSecondPoint;
    }
}
