package com.pollen.pollenweb.exception;

import com.pollen.pollenweb.result.ResponseEnum;

public class PwException extends RuntimeException{
    private ResponseEnum responseEnum;

    public void setResponseEnum(ResponseEnum responseEnum) {
        this.responseEnum = responseEnum;
    }

    public ResponseEnum getResponseEnum() {
        return responseEnum;
    }

    public PwException(ResponseEnum responseEnum) {
        super(responseEnum.getMsg());
        this.responseEnum = responseEnum;
    }
}
