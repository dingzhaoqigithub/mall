package com.utils;

import com.po.Dto;

/**
 * 用于返回Dto的工具类
 * Created by XX on 17-5-8.
 */
public class DtoUtil {

    public static String success = "true";

    public static String fail = "false";

    public static String errorCode = "0";

    /***
     * 统一返回成功的DTO
     * 返回成功（true）不带数据
     */
    public static Dto returnSuccess() {
        Dto dto = new Dto();
        dto.setSuccess(success);
        return dto;
    }

    /***
     * 统一返回成功的DTO 带数据
     * 返回成功（true）带提示信息，带数据（返回数据最详细）
     */
    public static Dto returnSuccess(String message, Object data) {
        Dto dto = new Dto();
        dto.setSuccess(success);
        dto.setMessage(message);
        dto.setErrorCode(errorCode);
        dto.setData(data);
        return dto;
    }

    /***
     * 统一返回成功的DTO 不带数据
     * 返回成功（true）带提示信息
     * @return
     */
    public static Dto returnSuccess(String message) {
        Dto dto = new Dto();
        dto.setSuccess(success);
        dto.setMessage(message);
        dto.setErrorCode(errorCode);
        return dto;
    }

    /***
     * 统一返回成功的DTO 带数据 没有消息
     */
    public static Dto returnDataSuccess(Object data) {
        Dto dto = new Dto();
        dto.setSuccess(success);
        dto.setErrorCode(errorCode);
        dto.setData(data);
        return dto;
    }

    /***
     * 统一返回失败的DTO 有提示信息，错误码
     */
    public static Dto returnFail(String message, String errorCode) {
        Dto dto = new Dto();
        dto.setSuccess(fail);
        dto.setMessage(message);
        dto.setErrorCode(errorCode);
        return dto;
    }
}
