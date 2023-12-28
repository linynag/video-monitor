package com.yiwei.common.component.data;

import java.util.HashMap;

/**
 * @Description 封装Request参数或者Mybatis的返回值,存入到该Map中, key都进行大写处理
 * @Author longxn
 * @Date 19:42 2018/7/4
 **/
public class ResultMap<K,V> extends HashMap<K, V> {
	private static final long serialVersionUID = 9155660212774034975L;

	public V put(K key, V value) {
		if(key instanceof String){
			key = (K)((String)key).toUpperCase();
		}
       return super.put(key, value);
    }
}
