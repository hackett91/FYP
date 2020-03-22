package com.fyp;

import java.io.Serializable;

public class CardiacEvent implements Serializable {

    private int id;
    private String sensor;
    private int value;


    public CardiacEvent() {


    }

    public CardiacEvent(int id, String sensor, int value) {
        this.id = id;
        this.sensor = sensor;
        this.value = value;
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
