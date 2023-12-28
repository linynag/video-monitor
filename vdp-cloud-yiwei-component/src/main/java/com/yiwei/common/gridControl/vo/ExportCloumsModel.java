package com.yiwei.common.gridControl.vo;

import io.swagger.annotations.ApiModelProperty;

public class ExportCloumsModel {

    @ApiModelProperty(value="显示列头名称" ,hidden=true)
    private String title;

    @ApiModelProperty(value="列头对应数据的标识" ,hidden=true)
    private String field;

    public ExportCloumsModel() { }
    public ExportCloumsModel(String title, String field) {
        this.title = title;
        this.field = field;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
