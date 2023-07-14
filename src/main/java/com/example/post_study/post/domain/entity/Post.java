package com.example.post_study.post.domain.entity;

import com.example.post_study.global.BaseTimeEntity;
import com.example.post_study.member.domain.entity.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long id;

    @ColumnDefault("0")
    private Long recommend;

    private String title;

    @Lob
    private String content;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ColumnDefault("false")
    private Boolean is_deleted;

    @Builder
    public Post(Long recommend, String title, String content, Member member) {
        this.recommend = recommend;
        this.title = title;
        this.content = content;
        this.member = member;
    }
}
