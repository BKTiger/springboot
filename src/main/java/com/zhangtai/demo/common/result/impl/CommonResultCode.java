package com.zhangtai.demo.common.result.impl;

import com.zhangtai.demo.common.result.ResultCode;

/**
 * @author zhangtai
 * @date 2018/12/5 21:33
 * @Description:
 */
public enum CommonResultCode implements ResultCode {
    SUCCESS(true,"10000","请求成功"),
    FAIL(false,"99999","请求失败"),
    NUMBER_FAIL(false,"99998","除数不能为0");

    private boolean success;
    private String code;
    private String message;
    private CommonResultCode(boolean success,String code,String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
