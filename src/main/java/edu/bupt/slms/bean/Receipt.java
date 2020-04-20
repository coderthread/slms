package edu.bupt.slms.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * receipt
 * @author 
 */
public class Receipt implements Serializable {
    private Integer id;

    /**
     * 工单生成时间
     */
    private Date startTime;

    /**
     * 工单完成时间
     */
    private Date endTime;

    private Integer accountId;

    private Integer errorId;

    /**
     * 故障原因
     */
    private String reason;

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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getErrorId() {
        return errorId;
    }

    public void setErrorId(Integer errorId) {
        this.errorId = errorId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}