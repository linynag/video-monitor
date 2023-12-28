package com.yiwei.common.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author: chenxin
 * @date: 2019/8/2 18:33
 */
public class UploadVO {

    private boolean flag;
    private String url;

    public UploadVO(boolean flag) {
        this.flag = flag;
    }

    public UploadVO(boolean flag, String url) {
        this.flag = flag;
        this.url = url;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
