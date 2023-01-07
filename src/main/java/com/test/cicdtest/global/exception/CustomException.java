package com.test.cicdtest.global.exception;

import com.test.cicdtest.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    private int statuscode;
    private String msg;

    public CustomException(ErrorCode errorCode) {
        this.statuscode = errorCode.getHttpStatus().value();
        this.msg = errorCode.getMessage();
    }

    public CustomException(int statusCode, String msg) {
        this.statuscode = statusCode;
        this.msg = msg;
    }
}