package com.sw.randomanirecommand.service;

import com.sw.randomanirecommand.domain.Member;
import com.sw.randomanirecommand.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService implements UserDetailsService
{
    private final MemberRepository repository;

    public void saveMember(Member member)
    {
        validateDuplicateMember(member);
        repository.save(member);
    }

    private void validateDuplicateMember(Member member)
    {
        Member findByUid = repository.findByUid(member.getUid());
        if(findByUid != null)
        {
            throw new IllegalStateException("이미 가입된 아이디입니다.");
        }

        Member findByNickName = repository.findByNickName(member.getNickName());
        if(findByNickName != null)
        {
            throw new IllegalStateException("이미 가입된 닉네임입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException
    {
        Member member = repository.findByUid(uid);

        if(member == null)
        {
            throw new UsernameNotFoundException(uid);
        }

        return User.builder()
                .username(member.getUid())
                .password(member.getUpw())
                .roles(member.getRole().toString())
                .build();
    }
}
