package com.sparta.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@NoArgsConstructor
public class SignupRequestDto {

    @NotBlank
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{3,}",
            message = "닉네임은 영문 대,소문자 또는 숫자로 3자이상이어야 합니다.")
    private String username;

    @NotBlank
    @Pattern(regexp=".{4,}", message = "비밀번호는 4자이상의 비밀번호여야 합니다.")
    private String password;

    private String password2;
}