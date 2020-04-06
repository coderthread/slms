package edu.bupt.slms.bean;

import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/04/06 10:34:08
 */
public class RespPageBean {
    private long total;
    private List<?> data;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
