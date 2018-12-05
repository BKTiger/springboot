package com.zhangtai.demo.common.result;

/**
 * @author zhangtai
 * @date 2018/12/5 22:10
 * @Description:
 */

public class ResponseResult extends Result {

    private DataResult dataResult;

    public ResponseResult(ResultCode returnCode,DataResult dataResult) {
        super(returnCode);
        this.dataResult = dataResult;
    }

    public DataResult getDataResult() {
        return dataResult;
    }

    public void setDataResult(DataResult dataResult) {
        this.dataResult = dataResult;
    }
}
