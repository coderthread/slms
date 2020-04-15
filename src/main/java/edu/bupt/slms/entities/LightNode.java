package edu.bupt.slms.entities;

import java.util.Date;

public class LightNode {
    private int l_id;
    private int p_id;
    private String type;
    private double rated_power;
    private double rated_voltage;
    private double rated_current;
    private double power;
    private double voltage;
    private double current;
    private Date production_date;
    private Date purchase_date;
    private Date install_date;
    private String life_time;
    private String manufacturer;
    private double price;
    private String state;
    private int brightness;

    public int getL_id() {
        return l_id;
    }

    public void setL_id(int l_id) {
        this.l_id = l_id;
    }

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

    public double getRated_power() {
        return rated_power;
    }

    public void setRated_power(double rated_power) {
        this.rated_power = rated_power;
    }

    public double getRated_voltage() {
        return rated_voltage;
    }

    public void setRated_voltage(double rated_voltage) {
        this.rated_voltage = rated_voltage;
    }

    public double getRated_current() {
        return rated_current;
    }

    public void setRated_current(double rated_current) {
        this.rated_current = rated_current;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
}
