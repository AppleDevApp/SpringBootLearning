package com.idcut.mosmqtt.domain;

import java.util.Date;


public class DefaultPayload {

    private long id;
    private String sensorId;
    private boolean status;
    private int temp;
    private Date date;
    private String raw;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    @Override
    public String toString() {
        return "DefaultPayload{" +
                "id=" + id +
                ", sensorId='" + sensorId + '\'' +
                ", status=" + status +
                ", temp=" + temp +
                ", date=" + date +
                ", raw='" + raw + '\'' +
                '}';
    }
}
