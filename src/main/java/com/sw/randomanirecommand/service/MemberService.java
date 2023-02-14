package com.sw.randomanirecommand.service;

import com.sw.randomanirecommand.domain.Member;
import com.sw.randomanirecommand.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService
{
    private final MemberRepository repository;

    public Member saveMember(Member member)
    {
        validateDuplicateMember(member);
        return repository.save(member);
    }

    private void validateDuplicateMember(Member member)
    {
        Member findMember = repository.findByUid(member.getUid());
        if(findMember != null)
        {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
