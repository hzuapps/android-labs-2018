package com.example.soft1614080902131stopwatch;

import org.litepal.crud.DataSupport;

public class Timer1Record extends DataSupport{

    private int id;
    private int number;
    private String grade;
    private int rankN;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getRankN() {
        return rankN;
    }

    public void setRankN(int rankN) {
        this.rankN = rankN;
    }
}
