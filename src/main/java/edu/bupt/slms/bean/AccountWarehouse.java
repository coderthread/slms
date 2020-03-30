package edu.bupt.slms.bean;

import java.io.Serializable;

/**
 * account_warehouse
 * @author 
 */
public class AccountWarehouse implements Serializable {
    private Integer id;

    private Integer aId;

    private Integer wId;

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

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }
}