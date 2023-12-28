package com.yiwei.common.component.utils;

import java.util.Calendar;

/**
 * @author: chenxin
 * @date: 2019/8/2 18:06
 */
public class UploadUtil {
    public static String getYearAndMonth(){
        String result = "";
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        result = result+year+"/";
        int month = cal.get(Calendar.MONTH)+1;
        if(month <10){
            result = result+"0"+month;
        }else{
            result = result+month;
        }
        return result;
    }
}
