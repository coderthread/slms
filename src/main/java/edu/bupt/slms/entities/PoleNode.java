package edu.bupt.slms.entities;

import java.util.Date;

public class PoleNode {
    private int p_id;
    private String type;
    private double longitude;
    private double latitude;
    private String position; // 文字描述地址
    private double height;
    private double load_bearing;
    private Date production_date;
    private Date purchase_date;
    private Date install_date;
    private String life_time;
    private int warehouse_flag;
    private String manufacturer;
    private double price;

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLoad_bearing() {
        return load_bearing;
    }

    public void setLoad_bearing(double load_bearing) {
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

    public Date getInstall_date() {
        return install_date;
    }

    public void setInstall_date(Date install_date) {
        this.install_date = install_date;
    }

    public String getLife_time() {
        return life_time;
    }

    public void setLife_time(String life_time) {
        this.life_time = life_time;
    }

    public int getWarehouse_flag() {
        return warehouse_flag;
    }

    public void setWarehouse_flag(int warehouse_flag) {
        this.warehouse_flag = warehouse_flag;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
