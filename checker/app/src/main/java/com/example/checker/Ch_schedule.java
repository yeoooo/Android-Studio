package com.example.checker;

import java.io.Serializable;

public class Ch_schedule implements Serializable{

    String schedule_content, schedule_name;
    String schedule_startTime;
    String schedule_endTime;
    String alarmTime;
    boolean is_improve;


    Ch_schedule(String schedule_name, String schedule_content,String alarmTime, String schedule_startTime,
                              String schedule_endTime, boolean is_improve) {
        this.is_improve = is_improve;
        this.alarmTime = alarmTime;
        this.schedule_name = schedule_name;
        this.schedule_content = schedule_content;
        this.schedule_endTime = schedule_endTime;
        this.schedule_startTime = schedule_startTime;
    }
    public String getAlarmTime(){
        return alarmTime;
    }
    public void setAlarmTime(String alarmTime){
        this.alarmTime = alarmTime;
    }
    public String getSchedule_name() {
        return schedule_name;
    }
    public void setSchedule_name(String schedule_name){
        this.schedule_name = schedule_name;
    }

    public String getSchedule_content() {
        return schedule_content;
    }

    public void setSchedule_content(String schedule_content) {
        this.schedule_content = schedule_content;
    }

    public String getSchedule_startTime() {
        return schedule_startTime;
    }

    public void setSchedule_startTime(String schedule_startTime) {
        this.schedule_startTime = schedule_startTime;
    }

    public String getSchedule_endTime() {
        return schedule_endTime;
    }

    public void setSchedule_endTime(String schedule_endTime) {
        this.schedule_endTime = schedule_endTime;
    }

    public boolean isIs_improve() {
        return is_improve;
    }

    public void setIs_improve(boolean is_improve) {
        this.is_improve = is_improve;
    }

}


