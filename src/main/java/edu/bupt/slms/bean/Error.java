package edu.bupt.slms.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * error
 * @author 
 */
public class Error implements Serializable {
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;

    private String type;

    private String des;

    private String address;

    private Integer importance;

    private String status;

    private Integer aId;

    private Integer pId;

    private Pole pole;

    private RespAccount account ;

    private static final long serialVersionUID = 1L;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Pole getPole() {
        return pole;
    }

    public void setPole(Pole pole) {
        this.pole = pole;
    }

    public RespAccount getAccount() {
        return account;
    }

    public void setAccount(RespAccount account) {
        this.account = account;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    @Override
    public String toString() {
        return "Error{" +
                "id=" + id +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", des='" + des + '\'' +
                ", address='" + address + '\'' +
                ", importance=" + importance +
                ", status='" + status + '\'' +
                ", aId=" + aId +
                ", account=" + account +
                '}';
    }
}