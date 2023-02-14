package com.sw.randomanirecommand.repository;

import com.sw.randomanirecommand.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>
{
    Member findByUid(String uid);

    Member findByNickName(String nickName);
}
