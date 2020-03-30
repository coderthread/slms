package edu.bupt.slms.bean;

import java.io.Serializable;

/**
 * menu_role
 * @author 
 */
public class MenuRole implements Serializable {
    private Integer id;

    private Integer mId;

    private Integer rId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }
}