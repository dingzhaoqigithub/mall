package com.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据传输对象（出对象）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dto<T> {
    private String success;//成功码
    private String errorCode;//错误码
    private String message;//返回信息
    private T data;//返回具体内容
}
