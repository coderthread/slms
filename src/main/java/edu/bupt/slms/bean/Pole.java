package edu.bupt.slms.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * pole
 * @author 
 */
public class Pole implements Serializable {
    private Integer id;

    private Integer wpId;

    private Integer wId;

    private String position;

    private Double longitude;

    private Double latitude;

    private Date install_date;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWpId() {
        return wpId;
    }

    public void setWpId(Integer wpId) {
        this.wpId = wpId;
    }

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Date getInstall_date() {
        return install_date;
    }

    public void setInstall_date(Date install_date) {
        this.install_date = install_date;
    }

    public Date makeDateFormat(Date d) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(d); // 把带时分秒的 date 转为 yyyy-MM-dd 格式的字符串
        Date date = sdf.parse(s); // 把上面的字符串解析为日期类型
        java.sql.Date resultDate = new java.sql.Date(date.getTime());
        return resultDate;
    }
}