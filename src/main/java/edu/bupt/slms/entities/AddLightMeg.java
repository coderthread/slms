package edu.bupt.slms.entities;

public class AddLightMeg {
    private float start_lng;
    private float start_lat;
    private float end_lng;
    private float end_lat;
    private int num;
    private float interval;
    private String light_type;
    private String pole_type;

    public float getStart_lng() {
        return start_lng;
    }

    public float getStart_lat() {
        return start_lat;
    }

    public float getEnd_lng() {
        return end_lng;
    }

    public float getEnd_lat() {
        return end_lat;
    }

    public int getNum() {
        return num;
    }

    public float getInterval() {
        return interval;
    }

    public String getLight_type() {
        return light_type;
    }

    public String getPole_type() {
        return pole_type;
    }

    public void setStart_lng(float start_lng) {
        this.start_lng = start_lng;
    }

    public void setStart_lat(float start_lat) {
        this.start_lat = start_lat;
    }

    public void setEnd_lng(float end_lng) {
        this.end_lng = end_lng;
    }

    public void setEnd_lat(float end_lat) {
        this.end_lat = end_lat;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setInterval(float interval) {
        this.interval = interval;
    }

    public void setLight_type(String light_type) {
        this.light_type = light_type;
    }

    public void setPole_type(String pole_type) {
        this.pole_type = pole_type;
    }
}
