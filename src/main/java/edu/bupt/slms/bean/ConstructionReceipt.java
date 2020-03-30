package edu.bupt.slms.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * construction_receipt
 * @author 
 */
public class ConstructionReceipt implements Serializable {
    private Integer id;

    private Date startTime;

    private Date enfTime;

    private String consumption;

    private Integer billId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEnfTime() {
        return enfTime;
    }

    public void setEnfTime(Date enfTime) {
        this.enfTime = enfTime;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }
}