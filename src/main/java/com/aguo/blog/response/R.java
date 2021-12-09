package com.aguo.blog.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Aguo
 * @Date: 2021/12/08/ 10:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> implements Serializable {
    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

}
