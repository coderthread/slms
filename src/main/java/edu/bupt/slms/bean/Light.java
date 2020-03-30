package edu.bupt.slms.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * light
 * @author 
 */
public class Light implements Serializable {
    private Integer id;

    /**
     * 所挂载灯杆信息
     */
    private Integer pId;

    private Date install_date;

    private Object status;

    /**
     * 1,2,3,4,5个级别
     */
    private Integer brightness;

    /**
     * 仓库中实体灯的Id
     */
    private Integer wLightId;

    /**
     * 实时功率
     */
    private Double power;

    /**
     * 实时电压
     */
    private Double voltage;

    /**
     * 实时电流
     */
    private Double current;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Date getInstall_date() {
        return install_date;
    }

    public void setInstall_date(Date install_date) {
        this.install_date = install_date;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Integer getBrightness() {
        return brightness;
    }

    public void setBrightness(Integer brightness) {
        this.brightness = brightness;
    }

    public Integer getwLightId() {
        return wLightId;
    }

    public void setwLightId(Integer wLightId) {
        this.wLightId = wLightId;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Double getVoltage() {
        return voltage;
    }

    public void setVoltage(Double voltage) {
        this.voltage = voltage;
    }

    public Double getCurrent() {
        return current;
    }

    public void setCurrent(Double current) {
        this.current = current;
    }
}