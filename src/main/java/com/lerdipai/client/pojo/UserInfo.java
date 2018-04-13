package com.lerdipai.client.pojo;

import com.icafebutler.framework.model.BasePojo;

public class UserInfo extends BasePojo {
    private static final long serialVersionUID = 9213207389265854540L;
    private Integer userId;
    private String mobile;
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
