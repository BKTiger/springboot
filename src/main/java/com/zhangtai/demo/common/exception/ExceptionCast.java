package com.zhangtai.demo.common.exception;

import com.zhangtai.demo.common.result.ResultCode;

/**
 * @author zhangtai
 * @date 2018/12/5 22:26
 * @Description:
 */
public class ExceptionCast {

    public static void cast(ResultCode resultCode){
        throw new CommonException(resultCode);
    }
}
