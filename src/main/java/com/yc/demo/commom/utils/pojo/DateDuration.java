package com.yc.demo.commom.utils.pojo;

/**
 * Created by Jayce on 2016/12/21.
 */
public class DateDuration
{
    private long day;
    private long hour;
    private long minute;
    private long second;
    private long milliSecond;

    public DateDuration() {
    }

    public DateDuration(long day, long hour, long minute, long second, long milliSecond) {
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.milliSecond = milliSecond;
    }

    public long getDay() {
        return day;
    }

    public void setDay(long day) {
        this.day = day;
    }

    public long getHour() {
        return hour;
    }

    public void setHour(long hour) {
        this.hour = hour;
    }

    public long getMinute() {
        return minute;
    }

    public void setMinute(long minute) {
        this.minute = minute;
    }

    public long getSecond() {
        return second;
    }

    public void setSecond(long second) {
        this.second = second;
    }

    public long getMilliSecond() {
        return milliSecond;
    }

    public void setMilliSecond(long milliSecond) {
        this.milliSecond = milliSecond;
    }
}
