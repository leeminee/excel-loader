package com.wendy.excelloader.model;

public class
Alarm {

    private String alarmHost;
    private String alarmMessage;
    private int alarmCount;

    public Alarm(String alarmHost, String alarmMessage, int alarmCount) {
        this.alarmHost = alarmHost;
        this.alarmMessage = alarmMessage;
        this.alarmCount = alarmCount;
    }

    public String getAlarmHost() {
        return alarmHost;
    }

    public void setAlarmHost(String alarmHost) {
        this.alarmHost = alarmHost;
    }

    public String getAlarmMessage() {
        return alarmMessage;
    }

    public void setAlarmMessage(String alarmMessage) {
        this.alarmMessage = alarmMessage;
    }

    public int getAlarmCount() {
        return alarmCount;
    }

    public void setAlarmCount(int alarmCount) {
        this.alarmCount = alarmCount;
    }
}
