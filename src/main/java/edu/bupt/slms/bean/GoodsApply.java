package edu.bupt.slms.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * goods_apply
 * @author 
 */
public class GoodsApply implements Serializable {
    /**
     * 表编号
     */
    private Integer id;

    private Integer applyId;

    private Integer errorId;

    private Date time;

    private String detail;

    private String applyStatus;

    private String applyName;

    private String applyType;

    private String applyTelephone;

    private static final long serialVersionUID = 1L;

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getApplyTelephone() {
        return applyTelephone;
    }

    public void setApplyTelephone(String applyTelephone) {
        this.applyTelephone = applyTelephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Integer getErrorId() {
        return errorId;
    }

    public void setErrorId(Integer errorId) {
        this.errorId = errorId;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }
}