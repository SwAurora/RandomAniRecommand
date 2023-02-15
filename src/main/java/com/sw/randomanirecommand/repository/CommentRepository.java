package com.sw.randomanirecommand.repository;

import com.sw.randomanirecommand.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>
{
    @Query("select c from Comment c where c.code = :code order by c.no desc")
    List<Comment> getCommentListByCode(@Param("code") Long code);
}
