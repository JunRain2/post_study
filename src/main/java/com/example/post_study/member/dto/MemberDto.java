package com.example.post_study.member.dto;

import com.example.post_study.member.domain.entity.Member;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class MemberDto {

    @NotEmpty
    @Email(message = "유효하지 않은 이메일 형식입니다.",
            regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private String email;

    @NotEmpty
    @Pattern(message = "숫자로 시작하지 않고 특수문자를 제외한 2이상 8이하의 문자여야 합니다.",
            regexp = "^[a-zA-Z가-힣]{2,8}$")
    private String nickname;

    @NotEmpty
    @Pattern(message = "최소 한개 이상의 대소문자와 숫자, 특수문자를 포함한 8자 이상 16자 이하의 비밀번호를 입력해야 합니다.",
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!~$%^&-+=()])(?=\\S+$).{8,16}$")
    private String password;

    public static Member toEntity(PasswordEncoder passwordEncoder, MemberDto memberDto) {
        return Member.builder()
                .email(memberDto.email)
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .nickname(memberDto.nickname)
                .build();
    }
}
