package com.yiwei.common.gridControl.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class PageQuery {

    @ApiModelProperty(value="当前页码" ,required=true)
    private Integer pageNo;
    @ApiModelProperty(value="每页数量" ,required=true)
    private Integer pageSize;
    @ApiModelProperty(value="数据总数（后端计算)" ,hidden=true)
    private Integer totalCount;
    @ApiModelProperty(value="总页数（后端计算）" ,hidden=true)
    private Integer totalPage;
    @ApiModelProperty(value="排序字符串 例：name desc" ,hidden=true)
    private String sortStr;
    @ApiModelProperty(value="需要导出到excel显示的列,导出时必填",hidden = true)
    private List<ExportCloumsModel> cloums;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public String getSortStr() {
        return sortStr;
    }

    public void setSortStr(String sortStr) {
        this.sortStr = sortStr;
    }

    public List<ExportCloumsModel> getCloums() {
        return cloums;
    }

    public void setCloums(List<ExportCloumsModel> cloums) {
        this.cloums = cloums;
    }
}
