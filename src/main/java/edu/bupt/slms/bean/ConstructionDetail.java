package edu.bupt.slms.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * construction_detail
 * @author 
 */
public class ConstructionDetail implements Serializable {
    private Integer id;

    private Date date;

    /**
     * 工程ID
     */
    private Integer projectId;

    private String detail;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}