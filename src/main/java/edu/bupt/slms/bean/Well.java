package edu.bupt.slms.bean;

import java.io.Serializable;

/**
 * well
 * @author 
 */
public class Well implements Serializable {
    private Integer id;

    private Double lng;

    private Double lat;

    private Integer pp_id;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Integer getPp_id() {
        return pp_id;
    }

    public void setPp_id(Integer pp_id) {
        this.pp_id = pp_id;
    }
}