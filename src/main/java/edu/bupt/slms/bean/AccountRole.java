package edu.bupt.slms.bean;

import java.io.Serializable;

/**
 * account_role
 * @author 
 */
public class AccountRole implements Serializable {
    private Integer id;

    private Integer aId;

    private Integer rId;

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

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }
}