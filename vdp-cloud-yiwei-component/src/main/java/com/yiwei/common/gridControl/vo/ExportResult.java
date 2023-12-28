package com.yiwei.common.gridControl.vo;

import java.util.List;
import java.util.Map;

public class ExportResult<T> {

	public ExportResult() {
		super();
	}

	/**
	 * 数据源list集合
	 */
	private List<T> data;
	/**
	 *导出的excel需要显示的数据列，key为数字索引 如："0": Map<>,""
	 */
	private Map<String, Map<String, Object>> columns;

}
