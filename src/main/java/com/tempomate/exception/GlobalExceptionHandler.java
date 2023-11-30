package com.tempomate.exception;

import com.tempomate.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) //捕获所有异常 Catch all exceptions
    public Result ex(Exception e){
        e.printStackTrace();
        return Result.error("error in backend, caught by GlobalExceptionHandler");
    }

}
