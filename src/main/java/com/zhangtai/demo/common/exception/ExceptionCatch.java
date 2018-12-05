package com.zhangtai.demo.common.exception;

import com.google.common.collect.ImmutableMap;
import com.zhangtai.demo.common.result.Result;
import com.zhangtai.demo.common.result.ResultCode;
import com.zhangtai.demo.common.result.impl.CommonResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangtai
 * @date 2018/12/5 22:32
 * @Description:
 */
@ControllerAdvice//控制器增强
public class ExceptionCatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    //定义map,配置异常类型所对应的错误代码
    private static ImmutableMap<Class<? extends Throwable>,ResultCode> EXCEPTIONS;
    //定义build对象,构建ImmutableMap
    protected static ImmutableMap.Builder<Class<? extends Throwable>,ResultCode> builder = ImmutableMap.builder();
    static {
        builder.put(ArithmeticException.class,CommonResultCode.NUMBER_FAIL);
    }
    //捕获自定义异常
    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public Result commonExcetion(CommonException commonException){
        LOGGER.error("捕获异常信息:"+commonException.getMessage());
        ResultCode resultCode = commonException.getResultCode();
        return new Result(resultCode);
    }

    //捕获异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result excetion(Exception exception){
        LOGGER.error("捕获异常信息:"+exception.getMessage());
        if(EXCEPTIONS==null){
            EXCEPTIONS = builder.build();
        }
        ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if(resultCode!=null){
            return new Result(resultCode);
        }

        return new Result(CommonResultCode.FAIL);
    }
}
