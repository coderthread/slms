package edu.bupt.slms.bean;

import java.io.Serializable;
import java.util.List;

/**
 * menu
 * @author 
 */
public class Menu implements Serializable {
    private Integer id;

    /**
     * 接口匹配路径
     */
    private String url;

    /**
     * vue router中的path属性
     */
    private String path;

    /**
     * vue router中的component属性
     */
    private String component;

    /**
     * vue router中的name属性
     */
    private String name;

    /**
     * vue 中的icon图标
     */
    private String iconCls;

    private Integer parentId;

    /**
     * 是否启用
     */
    private Boolean enabled;

    private List<Role> roles;

    private Meta meta;

    private List<Menu> children;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}