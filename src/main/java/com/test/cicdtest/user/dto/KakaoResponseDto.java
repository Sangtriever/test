package com.test.cicdtest.user.dto;


import com.test.cicdtest.global.exception.SuccessCode;
import lombok.Getter;

@Getter
public class KakaoResponseDto {
    private int status;
    private String msg;

    public KakaoResponseDto(SuccessCode successCode){
        this.status = successCode.getHttpStatus().value();
        this.msg = successCode.getMessage();

    }
}