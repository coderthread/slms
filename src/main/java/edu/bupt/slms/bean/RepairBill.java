package edu.bupt.slms.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * repair_bill
 * @author 
 */
public class RepairBill implements Serializable {
    private Integer id;

    /**
     * 维修人员编号
     */
    private Integer aId;

    /**
     * 故障Id
     */
    private Integer eId;

    /**
     * 单位为小时或天数
     */
    private Integer timeLimit;

    private Date startTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}