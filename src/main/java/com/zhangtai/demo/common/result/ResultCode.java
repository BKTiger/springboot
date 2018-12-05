package com.zhangtai.demo.common.result;
/**
 * @author zhangtai
 * @date 2018/12/5 20:59
 * @Description:
 */
public interface ResultCode {

    boolean success();
    String code();
    String message();

}