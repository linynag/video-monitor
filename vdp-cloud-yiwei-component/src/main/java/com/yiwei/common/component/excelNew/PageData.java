package com.yiwei.common.component.excelNew;

import com.yiwei.common.component.config.MyException;
import com.yiwei.common.component.utils.DateUtils;
import com.yiwei.common.component.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

/**
 * @author: chenxin
 * @create: 2018年4月24日 下午4:14:42
 */
public class PageData extends LinkedHashMap{

	//记录一条数据执行的结果，多个结果可以叠加，
	public void setDescribe(String msg){
		String origin = this.get("describe") == null ? "" : this.get("describe").toString();
		String content = StringUtils.isBlank(origin)?msg:(origin+"|"+msg);
		this.put("describe",content);
	}
	//将当前对象，以modeRowTitle的内容为key按顺序对值进行映射！！！并返回重新映射后的对象
	public PageData setModelTitle(String[] modeRowTitle){
		if(modeRowTitle == null){
			modeRowTitle = new String[]{};
		}
		PageData other = new PageData(); //field -> value
		String[] selfKey = new String[this.keySet().size()];//vari -> value
		this.keySet().toArray(selfKey);
		int length = selfKey.length > modeRowTitle.length ? selfKey.length : modeRowTitle.length;
		for(int i=0;i<length;i++){
			if(i>=selfKey.length){
				other.put(modeRowTitle[i],"");
			}else if(i>= modeRowTitle.length){
				other.put("var"+i,this.get(selfKey[i]));
			}else {
				Object value = other.get(modeRowTitle[i]);
				//如果存在重复的key，不去覆盖，但是要用默认的key去占位，特别注意
				if(value != null && StringUtils.isNotEmpty(value.toString())){
					other.put("var"+i,this.get(selfKey[i]));//vari -> value
				}else{
					other.put(modeRowTitle[i],this.get(selfKey[i]));//field -> value
				}

			}
		}
		return other;
	}


	public void reflexObject(Object model) throws MyException, IllegalAccessException, ParseException {
		Field[] fields = model.getClass().getDeclaredFields();
		Field[] superFields = model.getClass().getSuperclass().getDeclaredFields();
		setField(fields,model);
		setField(superFields,model);
	}

	public void setField(Field[] fields,Object model) throws IllegalAccessException, MyException, ParseException {
		for (Field field : fields) {
			//认为此时属性名称作为每行数据的key了
			Object value = this.get(field.getName());
			if(value != null && StringUtils.isNotBlank(value.toString())){
				String valueStr = value.toString();
				field.setAccessible(true); //私有关系也可以反射！
				//todo 给model赋值，有问题再把对应类型加上
				if (field.getType().equals(Date.class)) {
					if(valueStr.length() == 10){
						field.set(model, DateUtils.parseYYYYMMDD(valueStr));
					}else if(valueStr.length() == 16){
						field.set(model,DateUtils.parseYYYYMMDDHHmm(valueStr));
					}else if(valueStr.length() == 19){
						field.set(model,DateUtils.parseYYYYMMDDHHMMSS(valueStr));
					}else{
						throw new MyException("时间转换错误，请联系管理员");
					}
				} else if (field.getType().equals(Integer.class)) {
					field.set(model, Integer.parseInt(valueStr));
				} else if (field.getType().equals(Long.class)) {
					field.set(model, Long.parseLong(valueStr));
				} else if(field.getType().equals(BigDecimal.class)){
					double doubluValue = Double.parseDouble(valueStr);
					field.set(model,new BigDecimal(doubluValue));
				}else {
					field.set(model, valueStr);
				}
			}
		}
	}


}
