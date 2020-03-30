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

    private Integer apply_id;

    private Integer error_id;

    private Date time;

    private String detail;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }

    public Integer getError_id() {
        return error_id;
    }

    public void setError_id(Integer error_id) {
        this.error_id = error_id;
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
}