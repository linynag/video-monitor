package com.yiwei.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by victorlau on 2020/2/12.
 */
@ApiModel("DQS查询数据通用请求对象")
public class DQSCommomRo {
    @ApiModelProperty("车机编码")
    private String devcode;
    @ApiModelProperty("查询的数据类型 RAW、CAN_RAW、RTINFO、CANINFO等等")
    private String dataType;
    @ApiModelProperty("查询开始时间 yyyy-MM-dd HH:mm:ss")
    private String startTimeStr;
    @ApiModelProperty("查询结束时间 yyyy-MM-dd HH:mm:ss")
    private String stopTimeStr;
    @ApiModelProperty("是否分页")
    private Boolean page;
    @ApiModelProperty("是否下一页")
    private Boolean next;
    @ApiModelProperty("查询时间维度 如: RECVTIME、DEVTIME")
    private String timeProperty;
    @ApiModelProperty("查询条数")
    private Integer itemCount;
    @ApiModelProperty("当前页最后时间 yyyy-MM-dd HH:mm:ss.SSS 如isNext为FALSE 则当前页第一条的时间")
    private String lastTimeStr;
    @ApiModelProperty("其他查询条件的JSONSTRING")
    private String paramMapStr;
    @ApiModelProperty("简单时间字符串 yyyyMMddHHmm")
    private String simpleTimeStr;

    public String getDevcode() {
        return devcode;
    }

    public void setDevcode(String devcode) {
        this.devcode = devcode;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getStopTimeStr() {
        return stopTimeStr;
    }

    public void setStopTimeStr(String stopTimeStr) {
        this.stopTimeStr = stopTimeStr;
    }

    public Boolean getPage() {
        return page;
    }

    public void setPage(Boolean page) {
        this.page = page;
    }

    public Boolean getNext() {
        return next;
    }

    public void setNext(Boolean next) {
        this.next = next;
    }

    public String getTimeProperty() {
        return timeProperty;
    }

    public void setTimeProperty(String timeProperty) {
        this.timeProperty = timeProperty;
    }

    public String getLastTimeStr() {
        return lastTimeStr;
    }

    public void setLastTimeStr(String lastTimeStr) {
        this.lastTimeStr = lastTimeStr;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public String getSimpleTimeStr() {
        return simpleTimeStr;
    }

    public void setSimpleTimeStr(String simpleTimeStr) {
        this.simpleTimeStr = simpleTimeStr;
    }

    public String getParamMapStr() {
        return paramMapStr;
    }

    public void setParamMapStr(String paramMapStr) {
        this.paramMapStr = paramMapStr;
    }
}
