package com.yiwei.common.component.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description
 * @author: chenxin
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static final char UNDERLINE = '_';

    /**
     * 驼峰格式字符串转换为下划线格式字符串
     *
     * @param param
     * @return
     */
    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 下划线格式字符串转换为驼峰格式字符串
     *
     * @param param
     * @return
     */
    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 下划线格式字符串转换为驼峰格式字符串
     *
     * @param param
     * @return
     */
    public static String renameJsonStr(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    /**
     * 日期转换成字符串
     *
     * @param date   日期时间
     * @param format 日期字符串格式("yyyy-MM-dd HH:mm:ss"、"yyyy-MM-dd")
     * @return
     * @author: chenxin
     * @date: 2018年4月16日
     */
    public static String DateToStr(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String str = sdf.format(date);
        return str;
    }

    /**
     * 获取classpath
     *
     * @return
     * @author: chenxin
     * @date: 2018年4月24日
     */
    public static String getClasspath() {
        String path = (String.valueOf(Thread.currentThread().getContextClassLoader().getResource("")) + "../../").replaceAll("file:/", "").replaceAll("%20", " ").trim();
        if (path.indexOf(":") != 1) {
            path = File.separator + path;
        }
        return path;
    }

    /**
     * 获取机构路径
     *
     * @return
     * @author: sion
     * @date: 2019年11月25日
     */
    public static String getOrgPathQuery(String orgId) {
        String orgPath = "";
        if (orgId != null && !"".equals(orgId)) {
            orgPath = "|" + orgId + "|";
        }
        return orgPath;
    }

    /**
     * 判断字符串是否能转为数字
     *
     * @param str 校验的字符串
     */
    public static boolean canParseInt(String str) {
        if (str == null) { //验证是否为空
            return false;
        }
        return str.matches("\\d+"); //使用正则表达式判断该字符串是否为数字，第一个\是转义符，\d+表示匹配1个或 //多个连续数字，"+"和"*"类似，"*"表示0个或多个
    }

    /**
     * 重新拼接字符串
     *
     * @param str
     * @return
     */
    public static String rebuildArrStr(String str) {
        StringBuffer sb = new StringBuffer();
        if (isNotBlank(str)) {
            String[] split = str.split(",");
            for (int i = 0; i < split.length; i++) {
                sb.append("\"")
                        .append(split[i])
                        .append("\"")
                        .append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String aaa = "app_version_fld";
        System.out.println(underlineToCamel(aaa));
        aaa = "appVersionFld";
        System.out.println(camelToUnderline(aaa));
        System.out.println("日期" + DateToStr(new Date(), "yyyyMMddHHmmss"));
    }
}
