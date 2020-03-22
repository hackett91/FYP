package com.fyp;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class CardiacEvent implements Serializable {

    private int id;
    private String sensor;
    private int value;

    public Calendar getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
    }

    private Calendar timestamp;


    public CardiacEvent() {


    }

    public CardiacEvent(int id, String sensor, int value, Calendar timestamp) {
        this.id = id;
        this.sensor = sensor;
        this.value = value;
        this.timestamp = timestamp;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public int getValue() {
        return value;
    }


    public void setValue(int value) {
        this.value = value;
    }


}
