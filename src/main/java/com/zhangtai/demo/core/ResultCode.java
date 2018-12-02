package com.zhangtai.demo.core;

/**
 * @author zhangtai
 * @date 2018/12/2 15:07
 * @Description:
 */
public interface ResultCode {
    //操作是否成功
    boolean success();
    //操作代码
    int code();
    //提示信息
    String massage();

}
