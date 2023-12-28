package com.yiwei.common.component.data;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @Description: 自定义响应数据结构
 * 				这个类是提供给门户，ios，安卓，微信商城用的
 * 				门户接受此类数据后需要使用本类的方法转换成对于的数据类型格式（类，或者list）
 * 				其他自行处理
 * 				200：表示成功
 * 				401：拦截器拦截到用户token出错
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回,参数校验错误等
 * 				555：异常抛出信息
 * {
 * "msgqueue":"直接展示给终端用户的错误信息",
 * "error_code":"业务错误码",
 * "error":"供开发者查看的错误信息",
 * "debug":["错误堆栈，必须开启 debug 才存在"  ]
 * }
 *
 * @author longxiaonan@163.com
 * @version V1.0
 */
public class VdpJSONResult implements Serializable {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    // 堆栈信息
    private StackTraceElement[] debug;

    public static VdpJSONResult build(Integer status, String msg, Object data) {
        return new VdpJSONResult(status, msg, data);
    }
    public static VdpJSONResult ok(String msg, Object data) {
        return new VdpJSONResult(msg,data);
    }

    public static VdpJSONResult ok(Object data) {
        return new VdpJSONResult(data);
    }

    public static VdpJSONResult ok() {
        return new VdpJSONResult(null);
    }

    /**
     * @Description 异常信息返回
     * @param msg 错误的信息提示
     * @Author longxn
     * @Date 22:04 2018/7/3
     **/
    public static VdpJSONResult error(Integer status, String msg) {
        return new VdpJSONResult(status, msg);
    }

    /**
     * @Description 异常信息返回,且返回堆栈信息
     * @param stackTrace 堆栈信息
     * @param msg 错误的信息提示
     * @Author longxn
     * @Date 22:04 2018/7/3
     **/
    public static VdpJSONResult error(Integer status, String msg, StackTraceElement[] stackTrace) {
        return new VdpJSONResult(status, msg, stackTrace);
    }

    /**
     * @Description 异常信息返回，且携带错误的具体数据
     * @Author longxn
     * @Date 22:05 2018/7/3
     **/
    public static VdpJSONResult error(Integer status, String msg, Object data) {
        return new VdpJSONResult(status, msg, data);
    }

    /**
     * @Description 用户信息错误,token信息校验异常,
     * @Author longxn
     * @Date 22:04 2018/7/3
     **/
    public static VdpJSONResult errorTokenMsg(String msg) {
        return new VdpJSONResult(401, msg);
    }

    private VdpJSONResult() {

    }

    public VdpJSONResult(Integer code, String msg, StackTraceElement[] debug) {
        this.code = code;
        this.msg = msg;
        this.debug = debug;
    }

    public VdpJSONResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public VdpJSONResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.debug = debug;
    }

    public VdpJSONResult(String msg, Object data) {
        this.code = 200;
        this.msg = msg;
        this.data = data;
    }
    public VdpJSONResult(Object data) {
        this.code = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.code == 200;
    }

    public Integer getStatus() {
        return code;
    }

    public void setStatus(Integer status) {
        this.code = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 
     * @Description: 将json结果集转化为VdpJSONResult对象
     * 				需要转换的对象是一个类
     * @param jsonData
     * @param clazz
     * @return
     * 
     * @author longxiaonan@163.com
     * @date 2016年4月22日 下午8:34:58
     */
    public static VdpJSONResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, VdpJSONResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("code").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 
     * @Description: 没有object对象的转化
     * @param json
     * @return
     * 
     * @author longxiaonan@163.com
     * @date 2016年4月22日 下午8:35:21
     */
    public static VdpJSONResult format(String json) {
        try {
            return MAPPER.readValue(json, VdpJSONResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 
     * @Description: Object是集合转化
     * 				需要转换的对象是一个list
     * @param jsonData
     * @param clazz
     * @return
     * 
     * @author longxiaonan@163.com
     * @date 2016年4月22日 下午8:35:31
     */
    public static VdpJSONResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("code").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    public StackTraceElement[] getDebug() {
        return debug;
    }

    public void setDebug(StackTraceElement[] debug) {
        this.debug = debug;
    }
}
