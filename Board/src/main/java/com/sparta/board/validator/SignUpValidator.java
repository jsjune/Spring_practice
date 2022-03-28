package com.sparta.board.validator;

import com.sparta.board.dto.SignupRequestDto;
import com.sparta.board.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Component
public class SignUpValidator {


    private final UserRepository userRepository;

    public SignUpValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getValidMessage(SignupRequestDto requestDto, Errors errors) {
        if (errors.hasErrors()) {
            // 유효성 통과 못한 필드와 메시지를 핸들링
            Map<String, String> validatorResult = validateHandling(errors);
            return validatorResult.get("message");
        } else if(checkNicknameDuplicate(requestDto.getUsername())) {
            return "이미 사용중인 닉네임입니다.";
        } else if(!requestDto.getPassword().equals(requestDto.getPassword2())) {
            return "비밀번호가 일치하지 않습니다";
        } else if(requestDto.getPassword().contains(requestDto.getUsername())) {
            return "비밀번호가 닉네임과 일치합니다";
        } else
            return "회원가입 성공";
    }

    // 회원가입 시, 유효성 체크
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = "message";
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }


    //닉네임 중복 체크
    public boolean checkNicknameDuplicate(String username) {
        return userRepository.existsByUsername(username);
    }

//    public String getValidMessageForTest(SignupRequestDto requestDto) {
//        if (!Pattern.matches("^[A-Za-z0-9]{3,}", requestDto.getUsername())) {
//            return "닉네임을 확인하세요.";
//        } else if (!Pattern.matches("^[A-Za-z0-9]{4,}", requestDto.getPassword())){
//            return "비밀번호를 확인하세요.";
//        } else if(checkNicknameDuplicate(requestDto.getUsername())) {
//            return "이미 사용중인 닉네임입니다.";
//        } else if(!requestDto.getPassword().equals(requestDto.getPassword2())) {
//            return "비밀번호가 일치하지 않습니다.";
//        } else if(requestDto.getPassword().contains(requestDto.getUsername())) {
//            return "비밀번호는 닉네임을 포함할 수 없습니다.";
//        } else
//            return "회원가입 성공";
//    }
}
