package com.yiwei.common.component.utils;

import java.io.*;
import java.util.List;

/**
 * @author sion
 * @date 2020年5月14日
 */
public class ArrayUtils {

    private ArrayUtils() {
    }

    public static <T> void addNonNull(List<T> list, T data) {
        if (data != null) {
            list.add(data);
        }
    }

    /**
     * 使用序列化方式深复制列表
     */
    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }

}
