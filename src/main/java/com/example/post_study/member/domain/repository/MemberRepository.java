package com.example.post_study.member.domain.repository;

import com.example.post_study.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

   public boolean existsByEmail(String email);

   public boolean existsByNickname(String nickname);
}
