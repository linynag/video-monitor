package com.yiwei.common.component.excelNew;


import com.yiwei.common.gridControl.vo.ExportCloumsModel;

import java.util.ArrayList;
import java.util.List;

public class ExcelObjModel {

    private int code;
    private String msg;
    private List<Object> list; // 导出的数据
    private List<ExportCloumsModel> cloums; // 需要导出到excel显示的列
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public List<ExportCloumsModel> getCloums() {
		return cloums;
	}

	public void setCloums(List<ExportCloumsModel> cloums) {
		this.cloums = cloums;
	}


	interface constant {
        int IMPORT_EXCEL_ERROT = 1500;
        int IMPORT_EXCEL_NOT_FILE = 1410;
        int IMPORT_EXCEL_FILE_SIZE_ZERO = 1430;
        int IMPORT_EXCEL_FILE_SHEET_NOT_CONTENT = 1440;
    }
    public List<String> getTitleList(){
        List<String> titleList = new ArrayList<>();
        if(this.cloums == null || this.cloums.size() == 0){
            return titleList;
        }
        for (ExportCloumsModel cloum : this.cloums) {
            titleList.add(cloum.getTitle());
        }
        return titleList;
    }
}
