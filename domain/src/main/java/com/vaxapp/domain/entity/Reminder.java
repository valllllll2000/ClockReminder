package com.vaxapp.domain.entity;

public class Reminder {

    private final int hour;
    private final int minute;
    private final String url;
    private final Boolean enabled;

    public Reminder(int hour, int minute, String url, Boolean enabled) {
        this.hour = hour;
        this.minute = minute;
        this.url = url;
        this.enabled = enabled;
    }
}
