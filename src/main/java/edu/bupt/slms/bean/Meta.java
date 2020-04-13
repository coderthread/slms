package edu.bupt.slms.bean;

/**
 * @author: 韩 宁
 * @create: 2020/04/10 16:22:57
 * menu 中的元素，抽取出来是为了构造前端router的结构
 */
public class Meta {
    private Boolean keepAlive;

    private Boolean requireAuth;

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
