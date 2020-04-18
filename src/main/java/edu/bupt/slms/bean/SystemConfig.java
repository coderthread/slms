package edu.bupt.slms.bean;

import java.io.Serializable;

/**
 * system_config
 * @author 
 */
public class SystemConfig implements Serializable {
    private Integer id;

    /**
     * 是否自动分配维修人员
     */
    private Boolean autoDistribution;

    /**
     * 是否自动控制路灯
     */
    private Boolean autoController;

    /**
     * 是否启用该项配置
     */
    private Boolean enable;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAutoDistribution() {
        return autoDistribution;
    }

    public void setAutoDistribution(Boolean autoDistribution) {
        this.autoDistribution = autoDistribution;
    }

    public Boolean getAutoController() {
        return autoController;
    }

    public void setAutoController(Boolean autoController) {
        this.autoController = autoController;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}