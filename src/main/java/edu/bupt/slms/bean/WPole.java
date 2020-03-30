package edu.bupt.slms.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * w_pole
 * @author 
 */
public class WPole implements Serializable {
    private Integer id;

    private String type;

    private String name;

    private Integer number;

    private Integer capacity;

    private Double height;

    private Double load_bearing;

    private Date production_date;

    private Date purchase_date;

    private String life_time;

    private String manufacturer;

    private Double price;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getLoad_bearing() {
        return load_bearing;
    }

    public void setLoad_bearing(Double load_bearing) {
        this.load_bearing = load_bearing;
    }

    public Date getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getLife_time() {
        return life_time;
    }

    public void setLife_time(String life_time) {
        this.life_time = life_time;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}