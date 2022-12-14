package com.test.cicdtest.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.cicdtest.global.MsgResponseDto;
import com.test.cicdtest.global.exception.SuccessCode;
import com.test.cicdtest.user.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class KakaoUserController {

    private final KakaoService kakaoService;

    /*@PostMapping("/loginKakao") // code: 카카오 서버로부터 받은 인가 코드
    public MsgResponseDto kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
        *//*String createToken = *//*kakaoService.kakaoLogin(code, response);
        // Cookie 생성 및 직접 브라우저에 Set
      *//*  Cookie cookie = new Cookie(JwtUtil.AUTHORIZATION_HEADER, createToken.substring(7));
        cookie.setPath("/");
        response.addCookie(cookie);*//*

        return new MsgResponseDto(SuccessCode.LOG_IN);
    }*/


    @GetMapping("/kakao/callback")
    public ResponseEntity<?> kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
        // code: 카카오 서버로부터 받은 인가 코드
        // 인가코드를 서비스로 전달
        kakaoService.kakaoLogin(code, response);
        return ResponseEntity.ok().body(new MsgResponseDto(SuccessCode.LOG_IN));
    }
}
