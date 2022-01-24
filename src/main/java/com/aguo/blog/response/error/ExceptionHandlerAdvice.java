package com.aguo.blog.response.error;

import com.aguo.blog.response.R;
import com.aguo.blog.response.annotation.BaseResponse;
import com.aguo.blog.response.code.RCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * @Author Aguo
 * @Date: 2021/12/08/ 10:37
 */
@ControllerAdvice(annotations = BaseResponse.class)
@ResponseBody
@Slf4j
public class ExceptionHandlerAdvice {
    /**
     * 处理未捕获的Exception
     * @param e 异常
     * @return 统一响应体
     */
    @ExceptionHandler(Exception.class)
    public R handleException(Exception e){
        log.error(e.getMessage(),e);
        return new R(RCode.SERVICE_ERROR.getCode(),RCode.SERVICE_ERROR.getMsg(),null);
    }

    /**
     * 处理未捕获的RuntimeException
     * @param e 运行时异常
     * @return 统一响应体
     */
    @ExceptionHandler(RuntimeException.class)
    public R handleRuntimeException(RuntimeException e){
        log.error(e.getMessage(),e);
        return new R(RCode.SERVICE_ERROR.getCode(),RCode.SERVICE_ERROR.getMsg(),null);
    }

    /**
     * 处理业务异常BaseException
     * @param e 业务异常
     * @return 统一响应体
     */
    @ExceptionHandler(BaseException.class)
    public R handleBaseException(BaseException e){
        log.error(e.getMessage(),e);
        RCode code=e.getCode();
        return new R(code.getCode(),code.getMsg(),null);
    }

    /**
     * 处理用户未输入信息异常
     * @param e 捕获到的异常
     * @return 统一异常封装返回提示
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        return new R(5000,new ArrayList<>(e.getAllErrors()).get(0).getDefaultMessage(),null);
    }
}
