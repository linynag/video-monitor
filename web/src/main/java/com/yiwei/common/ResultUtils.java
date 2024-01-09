package com.yiwei.common;

/**
 * 返回工具类
 */
public class ResultUtils {

    /**
     * 成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(0, "ok", data);
    }


    /**
     * 失败
     *
     * @param errorCode
     * @return
     */
    public static ResponseResult error(ErrorCode errorCode) {
        return new ResponseResult<>(errorCode);
    }

    /**
     * 失败
     *
     * @param code
     * @param message
     * @return
     */
    public static ResponseResult error(int code, String message) {
        return new ResponseResult(code, null, message);
    }

    /**
     * 失败
     *
     * @param errorCode
     * @return
     */
    public static ResponseResult error(ErrorCode errorCode, String message) {
        return new ResponseResult(errorCode.getCode(), null, message);
    }

}
