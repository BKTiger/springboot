package com.zhangtai.demo.common.result;

/**
 * @author zhangtai
 * @date 2018/12/5 21:52
 * @Description:
 */
public class Result {

    private boolean success;
    private String code;
    private String message;

    public Result(ResultCode returnCode){
        this.success = returnCode.success();
        this.code = returnCode.code();
        this.message = returnCode.message();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
