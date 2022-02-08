package com.pollen.pollenweb.exception;

import com.pollen.pollenweb.result.ResponseEnum;
import com.pollen.pollenweb.result.ResultMapUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class UnifiedExceptionHandler {

    @ExceptionHandler(value = PwException.class)
    public Object handlerException(PwException e){
        ResponseEnum responseEnum = e.getResponseEnum();
        log.info("----error----");
        log.info("【"+"code:"+responseEnum.getCode()+"---msg:"+responseEnum.getMsg()+"】");
        return ResultMapUtil.getHashMapLogin(responseEnum.getMsg(),Integer.toString(responseEnum.getCode()));
//        int res = responseEnum.getCode().intValue();
//        return res;
    }
}
