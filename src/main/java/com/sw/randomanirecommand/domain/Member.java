package com.sw.randomanirecommand.domain;

import com.sw.randomanirecommand.form.MemberForm;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;

@Getter
@NoArgsConstructor
@Entity
public class Member
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String uid;

    @Column(nullable = false, length = 200)
    private String upw;

    @Column(nullable = false, unique = true, length = 50)
    private String nickName;

    @CreationTimestamp
    private Date regDate;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Builder
    public Member(String uid, String upw, String nickName, MemberRole role)
    {
        this.uid = uid;
        this.upw = upw;
        this.nickName = nickName;
        this.role = role;
    }


    public static Member createMember(MemberForm memberForm, PasswordEncoder passwordEncoder)
    {
        return Member.builder()
                .uid(memberForm.getUid())
                .upw(passwordEncoder.encode(memberForm.getUpw()))
                .nickName(memberForm.getNickName())
                .role(MemberRole.USER)
                .build();
    }
}
