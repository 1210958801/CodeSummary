package com.we.validation.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 全局异常处理机制
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2019/12/13 5:36 下午
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 直接捕获所有的异常
     */
    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> globalExceptionHandlerMethod(Exception e) {
        Map<String, Object> resultMap = new HashMap<>(4);

        if (e instanceof ConstraintViolationException) {
            ConstraintViolationException cvExceptionex = (ConstraintViolationException) e;
            resultMap.put("message", "作用域在类上,验证参数的时候出现了" + cvExceptionex.getMessage());
            resultMap.put("code", 3);
        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException manvExceptionex = (MethodArgumentNotValidException) e;
            resultMap.put("message", "作用域在方法上,验证参数的时候出现了" + manvExceptionex.getMessage());
            resultMap.put("code", 3);
        } else {
            resultMap.put("message", "系统异常");
            resultMap.put("code", 3);
        }
        return resultMap;
    }
}
