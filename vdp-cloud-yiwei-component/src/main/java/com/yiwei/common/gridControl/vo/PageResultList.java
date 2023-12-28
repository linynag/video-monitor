package com.yiwei.common.gridControl.vo;

import java.util.ArrayList;
import java.util.List;

public class PageResultList<T> {

	public PageResultList() {
		super();
	}

	public PageResultList(Integer pageNo, Integer pageSize,
                          Integer totalCount, List<T> result) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.result = result;
	}

	public PageResultList(PageQuery page, List<T> result) {
		super();
		this.totalCount = page.getTotalCount() ==null ? 0 : page.getTotalCount();
		this.pageNo = page.getPageNo();
		this.pageSize = page.getPageSize();
		this.totalPage = (this.totalCount + page.getPageNo() - 1)/ page.getPageSize();
		this.result = result == null ? new ArrayList<>() : result;
	}


	/**
	 * 当前页数
	 */
	private Integer pageNo;
	/**
	 * 总页数
	 */
	private Integer pageSize;
	/**
	 * 总记录数
	 */
	private Integer totalCount;

	private Integer totalPage;
	/**
	 * 数据源list集合
	 */
	private List<T> result;

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

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
