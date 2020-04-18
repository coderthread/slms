package edu.bupt.slms.bean;

import java.io.Serializable;

/**
 * pipe
 * @author 
 */
public class Pipe implements Serializable {
    private Integer id;

    private Double start_lng;

    private Double start_lat;

    private Double end_lng;

    private Double end_lat;

    private Double length;

    private Integer total_holes_num;

    private Integer available_holes_num;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getStart_lng() {
        return start_lng;
    }

    public void setStart_lng(Double start_lng) {
        this.start_lng = start_lng;
    }

    public Double getStart_lat() {
        return start_lat;
    }

    public void setStart_lat(Double start_lat) {
        this.start_lat = start_lat;
    }

    public Double getEnd_lng() {
        return end_lng;
    }

    public void setEnd_lng(Double end_lng) {
        this.end_lng = end_lng;
    }

    public Double getEnd_lat() {
        return end_lat;
    }

    public void setEnd_lat(Double end_lat) {
        this.end_lat = end_lat;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getTotal_holes_num() {
        return total_holes_num;
    }

    public void setTotal_holes_num(Integer total_holes_num) {
        this.total_holes_num = total_holes_num;
    }

    public Integer getAvailable_holes_num() {
        return available_holes_num;
    }

    public void setAvailable_holes_num(Integer available_holes_num) {
        this.available_holes_num = available_holes_num;
    }
}