package com.aguo.blog.response.error;

import com.aguo.blog.response.code.RCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author Aguo
 * @Date: 2021/12/08/ 10:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException{

    private static final long serialVersionUID = -7373267719044070725L;

    private RCode code;

    public BaseException(RCode code) {
        this.code = code;
    }

    public BaseException(Throwable cause, RCode code) {
        super(cause);
        this.code = code;
    }
}
