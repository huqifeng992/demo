package com.example.demo.restful;

import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Description
 * @Author huqifeng
 * @Date 2018/09/13 16:22
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({DemoException.class})
    public static <T> GlobalResponse<T> handleException(DemoException e) {
        log.error(Throwables.getStackTraceAsString(e));
        return GlobalResponse.fail(null, Throwables.getStackTraceAsString(e));
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({Throwable.class})
    public static <T> GlobalResponse<T> throwableException(Throwable e) {
        log.error(Throwables.getStackTraceAsString(e));
        return GlobalResponse.fail(null, Throwables.getStackTraceAsString(e));
    }

}
