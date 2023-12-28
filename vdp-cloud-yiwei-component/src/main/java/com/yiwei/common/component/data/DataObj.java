package com.yiwei.common.component.data;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yiwei.common.component.utils.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class DataObj implements Serializable {

    private static final long serialVersionUID = -2921528257261333750L;

    protected JSONObject data;

    public JSONObject getData() {
        return data;
    }

    public static DataObj formJSONString(String jsonStr) {
        JSONObject obj = JSONObject.parseObject(jsonStr);
        DataObj data = new DataObj(obj);
        return data;
    }

    public DataObj offer(String key, Object obj) {
        this.data.put(key, obj);
        return this;
    }

    public void put(String key, Object obj) {
        this.data.put(key, obj);
    }

    public void setObjType(int type) {
        data.put("OBJTYPE", type);
    }

    public int getObjtype() {
        return data.getIntValue("OBJTYPE");
    }

    public JSONArray getJSONArray(String key) {
        return data.getJSONArray(key);
    }

    public JSONObject getJSONObj(String key) {
        return data.getJSONObject(key);
    }

    public String getDataTag() {
        return data.getString("DATATAG");
    }

    public void setDataTag(String tag) {
        data.put("DATATAG", tag);
    }

    public String getDevid() {
        return data.getString("DEVCODE");
    }

    public long getConnectSN() {
        return data.getLongValue("CONNECT_SN");
    }

    public void setConnectSN(long sn) {
        data.put("CONNECT_SN", sn);
    }

    public void setDevid(String devcode) {
        data.put("DEVCODE", devcode);
    }

    public void setConnectSN(int sn) {
        data.put("CONNECT_SN", sn);
    }

    public void setCount(int count) {
        data.put("TOTALCOUNT", count);
    }

    public void setOnline(Boolean online) {
        data.put("ONLINE", online);
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getRecvTime() {
        return data.getDate("RECVTIME");
    }

    public String getSimpleTime() {
        return data.getString("SIMPLETIME");
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getReportDate() {
        return data.getDate("DEVTIME");
    }

    public void setReportDate(Date time) {
        data.put("DEVTIME", time);
    }

    public Long getReportTime() {
        return data.getDate("DEVTIME") == null ? null : data.getDate("DEVTIME").getTime();
    }

    public void setRecvTime(Date date) {
        this.data.put("RECVTIME", date);
    }

    public void setSimpleTime(String simpleTime) {
        this.data.put("SIMPLETIME", simpleTime);
    }

    public void setSimpleInfo(String simpleInfo) {
        this.data.put("SIMPLEINFO", simpleInfo);
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getDate(String dateStr) {
        return this.data.getDate(dateStr);
    }

    public void putObj(String key, Object obj) {
        this.putObj(key, obj, data);
    }


    public void setResponseType(String responseType) {
        this.data.put("RESPONSE_TYPE", responseType);
        switch (responseType) {
            case "01":
            case "1":
                this.data.put("RESPONSE_TEXT", "成功");
                break;
            case "02":
            case "2":
                this.data.put("RESPONSE_TEXT", "设置未成功");
                break;
            case "03":
            case "3":
                this.data.put("RESPONSE_TEXT", "VIN重复");
                break;
//            case "FE":
//            case "254":
//                this.data.put("RESPONSE_TEXT", "数据包为命令包");
//                break;

        }
    }

    public boolean getResponseType() {
        boolean result = false;
        String resType = this.data.getString("RESPONSE_TYPE");
        if (StringUtils.isNotBlank(resType) && StringUtils.isNotEmpty(resType)) {
            if ("01".equals(resType) || "1".equals(resType)) {
                result = true;
            }
        }
        return result;
    }

    public String getResponseText() {
        return this.data.getString("RESPONSE_TEXT");
    }

    public void putObj(String path, Object obj, Map<String, Object> map) {
        String[] keys = path.split("\\.");

        if (keys.length == 1) {
            data.put(path, obj);
        } else if (keys.length == 2) {
            JSONObject submap;
            if (!data.containsKey(keys[0])) {
                submap = new JSONObject();
                data.put(keys[0], submap);
            } else {
                submap = data.getJSONObject(keys[0]);
            }
            submap.put(keys[1], obj);
        } else {
            throw new RuntimeException("NO SUPPORT SO MANY LAYER " + path);
        }

    }

    public String getString(String key) {
        return data.getString(key);
    }

    public Object get(String key) {
        return data.get(key);
    }

    public String toJSONString() {
        return this.data.toJSONString();
    }

    public DataObj() {
        this.data = new JSONObject();
    }

    public DataObj(JSONObject obj) {
        this.data = obj;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

    public long getLong(String key) {
        return this.data.getLongValue(key);
    }

    public int getInt(String key) {
        return this.data.getIntValue(key);
    }

    public Object getValue(String path) {
        String[] names = path.split("\\.");
        if (names.length > 3) {
            throw new RuntimeException("Not Support :" + path);
        }

        Object valueInStr = null;
        try {
            switch (names.length) {
                case 1:
                    valueInStr = this.get(names[0]);
                    break;
                case 2:
                    valueInStr = data.getJSONObject(names[0]).get(names[1]);
                    break;
                case 3:
                    valueInStr = data.getJSONObject(names[0]).getJSONObject(names[1]).get(names[2]);
                    break;
            }
        } catch (Exception e) {
        }
        return valueInStr;
    }

    public String getStrValue(String path) {
        String[] names = path.split("\\.");
        if (names.length > 3) {
            throw new RuntimeException("Not Support :" + path);
        }
        String valueInStr = null;
        try {
            switch (names.length) {
                case 1:
                    valueInStr = this.getString(names[0]);
                    break;
                case 2:
                    valueInStr = data.getJSONObject(names[0]).getString(names[1]);
                    break;
                case 3:
                    valueInStr = data.getJSONObject(names[0]).getJSONObject(names[1]).getString(names[2]);
                    break;
            }
        } catch (Exception e) {
        }
        return valueInStr;
    }

    public static void main(String[] args) {
        DataObj obj = new DataObj();
        obj.putObj("A.B", "C");
        System.out.println(obj);
    }

}
