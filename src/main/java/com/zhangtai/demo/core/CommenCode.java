package com.zhangtai.demo.core;

import lombok.ToString;

/**
 * @author zhangtai
 * @date 2018/12/2 15:09
 * @Description:
 */
@ToString
public enum CommenCode implements ResultCode {

    SUCCESS(true,10000,"请求成功"),
    FAIL(false,99999,"请求失败");

    boolean success;
    int code;
    String massage;

    private CommenCode(boolean success, int code, String massage){
        this.success = success;
        this.code = code;
        this.massage = massage;

    }
    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String massage() {
        return massage;
    }
}
