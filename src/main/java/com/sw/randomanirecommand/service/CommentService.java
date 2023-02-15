package com.sw.randomanirecommand.service;

import com.sw.randomanirecommand.domain.Comment;
import com.sw.randomanirecommand.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService
{
    private final CommentRepository repository;

    public void saveComment(Comment comment)
    {
        repository.save(comment);
    }

    public List<Comment> getCommentListByCode(Long code)
    {
        return repository.getCommentListByCode(code);
    }
}