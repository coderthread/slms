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

    private Double loadBearing;

    private Date productionDate;

    private Date purchaseDate;

    private String lifeTime;

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

    public Double getLoadBearing() {
        return loadBearing;
    }

    public void setLoadBearing(Double loadBearing) {
        this.loadBearing = loadBearing;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(String lifeTime) {
        this.lifeTime = lifeTime;
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