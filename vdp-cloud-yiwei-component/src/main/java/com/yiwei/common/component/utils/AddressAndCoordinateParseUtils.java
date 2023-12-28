package com.yiwei.common.component.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Optional;

/**
 * @ClassName: CoordinateAndAddressParseUtils
 * @Description: 地址和坐标解析工具类, 将wsg地址转换成百度坐标, 然后进行解析(地址转经纬度)和逆地址解析(经纬度转地址)
 * @author 龙小南
 * @email longxiaonan@163.com
 * @date 2017年11月21日 下午10:46:41
 * @version 1.0
 */
public class AddressAndCoordinateParseUtils {
	/** 百度"逆地址解析(经纬度转地址)的工具类 */
	private static final String BASE_URL = "http://api.map.baidu.com/reverse_geocoding/v3/";

	/** 百度申请的AK */
	private static final String AK = "frIh8G0ePIZAq0wURjFLWBpIZnt20ZFf";
	/**
	 * coordtype:
	 * 坐标的类型，目前支持的坐标类型包括：bd09ll（百度经纬度坐标）、bd09mc（百度米制坐标）、gcj02ll（国测局经纬度坐标）、
	 * wgs84ll（ GPS经纬度） output: 输出格式为json或者xml pois:
	 * 是否召回传入坐标周边的poi，0为不召回，1为召回。当值为1时，默认显示周边1000米内的poi。
	 */
	private static final String PARAMS = "&coordtype=bd09ll&output=json&pois=1";

	/**
	 * 地址转坐标 TODO 需要完善
	 */
	public static void Address2BaiduCoordinate(double longitude, double latitude) {
		String result = HttpClientUtils.sendHttpGet(
				"http://api.map.baidu.com/reverse_geocoding/v3/?ak=frIh8G0ePIZAq0wURjFLWBpIZnt20ZFf&location=30.548397,104.04701&output=json&pois=1");
		JSONObject parse = JSONObject.parseObject(result);
		System.out.println(parse);
	}

	/**
	 * 经纬度(坐标:coordinate)转换成地址
	 * 
	 * @param longitude
	 *            经度（原生GPS数据）
	 * @param latitude
	 *            纬度（原生GPS数据）
	 * @return 转换后的物理地址
	 */
	public static String BaiduCoordinate2Address(double longitude, double latitude) {
		/*使用百度API获取中文地址信息之前，GPS坐标系需要转成百度坐标系*/
		Gps gps = PositionUtil.gps84_toBd09(longitude, latitude);
		String location = gps.getWgLat() + "," + gps.getWgLon();
		/*翻译地址*/
		StringBuffer url = new StringBuffer();
		url.append(BASE_URL).append("?ak=").append(AK).append(PARAMS).append("&location=").append(location);
//		System.out.println(url);
		String result = HttpClientUtils.sendHttpGet(url.toString());
		JSONObject parse = JSONObject.parseObject(result);
		// 修改前， parse或者getJSONObject("result")的值为空会报空指针：
		// return parse.getJSONObject("result").getString("formatted_address");
		// 修改后如下，如果parse或者getJSONObject("result")的值为空时return null：
		return Optional.ofNullable(parse)
				.map(n -> n.getJSONObject("result"))
				.map(n -> n.getString("formatted_address"))
				.orElse(null);
	}

	// sc
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println(BaiduCoordinate2Address(118.94689, 31.70337));
		}
	}

}
