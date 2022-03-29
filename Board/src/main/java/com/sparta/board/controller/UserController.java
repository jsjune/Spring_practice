package com.sparta.board.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.board.dto.SignupRequestDto;
import com.sparta.board.security.UserDetailsImpl;
import com.sparta.board.service.KakaoUserService;
import com.sparta.board.service.UserService;
import com.sparta.board.validator.SignUpValidator;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
//@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final SignUpValidator signUpValidator;
    private final KakaoUserService kakaoUserService;

    public UserController(UserService userService, SignUpValidator signUpValidator, KakaoUserService kakaoUserService) {
        this.userService = userService;
        this.signUpValidator = signUpValidator;
        this.kakaoUserService = kakaoUserService;
    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        if(userDetails != null) {
            model.addAttribute("loggedIn", true);
            model.addAttribute("message", "이미 로그인 하셨습니다.");
        } else {
            model.addAttribute("loggedIn", false);
        }
        return "login";
    }

    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/user/signup")
    public String signup(@Valid SignupRequestDto requestDto, Errors errors, Model model) {
        String message = signUpValidator.getValidMessage(requestDto, errors);
//        System.out.println(message);
        if(message.equals("회원가입 성공")) {
            userService.registerUser(requestDto);
            return "login";
        }else {
            model.addAttribute("message", message);
            return "signup";
        }

    }

//    // 회원 가입 요청 처리
//    @PostMapping("/user/signup")
//    public String registerUser(@Valid SignupRequestDto requestDto, Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            return "signup";
//        }
//        userService.registerUser(requestDto);
//        return "redirect:/user/login";
//    }


    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
        // authorizedCode: 카카오 서버로부터 받은 인가 코드
        kakaoUserService.kakaoLogin(code);

        return "redirect:/";
    }
}