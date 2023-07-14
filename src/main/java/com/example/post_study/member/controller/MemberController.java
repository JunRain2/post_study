package com.example.post_study.member.controller;

import com.example.post_study.member.domain.entity.Member;
import com.example.post_study.member.dto.MemberDto;
import com.example.post_study.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.example.post_study.global.HttpStatusResponseEntity.*;
import static com.example.post_study.member.controller.MemberController.MEMBER_URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(MEMBER_URI)
public class MemberController {

    public static final String MEMBER_URI = "/members";

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid MemberDto memberDto) {
        if (memberService.isDuplicatedEmail(memberDto.getEmail())) {
            return RESPONSE_CONFLICT;
        }
        if (memberService.isDuplicatedNickname(memberDto.getNickname())) {
            return RESPONSE_CONFLICT;
        }

        Member member = MemberDto.toEntity(passwordEncoder, memberDto);
        memberService.registrationMember(member);

        return RESPONSE_OK;
    }
}
