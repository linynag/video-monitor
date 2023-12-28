package com.yiwei.common.component.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * @Description 添加set方法后, 可以在controller中通过该对象接参, 参考CmdController
 * @Author longxiaonan@163.com
 * @Date 10:03 2018/8/16
 **/
public class Command extends DataObj {

	public String getCommand() {
		return data.getString("COMMAND");
	}

	public void setCommand(String cmd) {
		data.put("COMMAND", cmd);
	}

	public void setDevcode(String devcode){
		data.put("DEVCODE", devcode);
	}
	public String getDevcode() {
		return data.getString("DEVCODE");
	}
	public void setParam(JSON param){
		data.put("PARAM", param);
	}
	public JSON getParam(){
		return (JSON)data.get("PARAM");
	}

	public static Command formJSONString(String jsonStr) {
		JSONObject obj = JSONObject.parseObject(jsonStr);
		Command commnd = new Command(obj);
		//commnd.setDataTag(VDPConst.DATA_COMMAND);
		commnd.setRecvTime(new Date());
		return commnd;
	}

	public Command(JSONObject obj) {
		this.data = obj;
	}

	public Command() {
	}
}
