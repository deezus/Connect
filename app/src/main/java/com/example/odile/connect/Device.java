package com.example.odile.connect;

/**
 * Created by Odile on 30/09/2017.
 */
public class Device {
    private long id;
    private String time;
    private String name;
    private Double latitude;
    private Double longitude;
    private Double altitude;

    public long getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Device()
    {

    }

}
