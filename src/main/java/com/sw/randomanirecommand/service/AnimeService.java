package com.sw.randomanirecommand.service;

import com.sw.randomanirecommand.domain.Anime;
import com.sw.randomanirecommand.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService
{
    private final AnimeRepository repository;

    public Anime findByRandom()
    {
        return repository.findByRandom();
    }

    public Anime findByTitle(String title)
    {
        return repository.findByTitle(title);
    }

    public List<Anime> findAllByPage(int page)
    {
        return repository.findAllByPage(PageRequest.of(page, 20));
    }
}
