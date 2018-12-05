package com.zhangtai.demo.common.exception;

import com.zhangtai.demo.common.result.ResultCode;

/**
 * @author zhangtai
 * @date 2018/12/5 22:16
 * @Description:
 */
public class CommonException extends  RuntimeException {

    private ResultCode resultCode;

    public CommonException(ResultCode resultCode){
        super("错误代码:"+resultCode.code()+"错误信息:"+resultCode.message());
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
