package com.example.demo.restful;

import java.io.Serializable;

/**
 * @Description
 * @Author huqifeng
 * @Date 2018/09/13 16:04
 */
public class DemoException extends  RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer errorCode;

    private String errorMsg;

    public DemoException() {
    }

    public DemoException(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
