package com.example.demo.restful;

/**
 * @Description
 * @Author huqifeng
 * @Date 2018/09/13 15:31
 */
public class GlobalResponse<T> {

    protected boolean success;

    private T data;

    private Integer errorCode;

    private String errorMsg;

    public GlobalResponse() {
    }

    public GlobalResponse(T data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public static <T> GlobalResponse<T> success(T data) {
        return new GlobalResponse<>(data, true);
    }

    public static <T> GlobalResponse<T> fail(Integer errorCode, String errorMsg) {
        GlobalResponse<T> resp = new GlobalResponse<T>();
        resp.setErrorCode(errorCode);
        resp.setErrorMsg(errorMsg);
        resp.setSuccess(false);
        return resp;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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

    @Override
    public String toString() {
        return "GlobalResponse{" +
                "success=" + success +
                ", data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
