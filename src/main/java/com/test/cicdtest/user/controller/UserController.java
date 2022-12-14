package com.test.cicdtest.user.controller;



import com.test.cicdtest.global.MsgResponseDto;
import com.test.cicdtest.global.exception.SuccessCode;
import com.test.cicdtest.user.dto.SignupRequestDto;
import com.test.cicdtest.user.dto.UserRequestDto;
import com.test.cicdtest.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 회원 가입
    @PostMapping("/signup")
    public MsgResponseDto signup(
            @RequestBody
            @Valid SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
        return new MsgResponseDto(SuccessCode.SIGN_UP);
    }

    // 로그인
    @PostMapping("/signin")
    public MsgResponseDto login(
            @RequestBody UserRequestDto loginRequestDto,
            HttpServletResponse response) {
        //클라이언트에 반환하기 위해 response 객체
        userService.login(loginRequestDto, response);
        return new MsgResponseDto(SuccessCode.LOG_IN);
    }

    // 아이디 중복 확인
    @GetMapping("/idDupleCheck")
    public ResponseEntity<Boolean> checkUserNameDuplicate (
            @RequestParam String userId){
        return ResponseEntity.ok(userService.checkUserIdDuplicate(userId));
    }
}
