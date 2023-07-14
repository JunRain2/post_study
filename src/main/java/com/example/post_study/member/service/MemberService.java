package com.example.post_study.member.service;

import com.example.post_study.member.domain.entity.Member;
import com.example.post_study.member.domain.repository.MemberRepository;
import com.example.post_study.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void registrationMember(Member member) {
        memberRepository.save(member);
    }

    public boolean isDuplicatedNickname(String nickname){
        return memberRepository.existsByNickname(nickname);
    }

    public boolean isDuplicatedEmail(String email){
        return memberRepository.existsByEmail(email);
    }
}
