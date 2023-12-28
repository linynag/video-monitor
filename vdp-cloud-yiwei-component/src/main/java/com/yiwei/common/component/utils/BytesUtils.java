package com.yiwei.common.component.utils;

/**
 * @program: vdp-cloud
 * @description:
 * @author: xiazj
 * @create: 2019-06-11 11:28
 **/
public class BytesUtils {

    public static String bytesToString(byte[] data) {
        if (data == null || data.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length; i++) {
            sb.append(" " + String.format("%1$02x", data[i]));
        }
        return sb.toString().toUpperCase().trim();
    }

}
