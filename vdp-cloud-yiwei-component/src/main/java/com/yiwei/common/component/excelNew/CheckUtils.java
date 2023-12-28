package com.yiwei.common.component.excelNew;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtils {
    //patternStr 正则表达式
    public static List getJudge(String str, String pattern){
        List result = new ArrayList();
        Pattern ruler = Pattern.compile(pattern);
        Matcher matcher = ruler.matcher(str);
        while (matcher.find()){
            String group = matcher.group();
            result.add(group);
        }

        return result;
    }
    public static Boolean selfJudge(String str, String pattern){
        List judge = getJudge(str, pattern);
        return judge.size()>0;
    }
}
