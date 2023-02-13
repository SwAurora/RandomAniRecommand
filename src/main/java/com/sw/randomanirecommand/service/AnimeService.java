package com.sw.randomanirecommand.service;

import com.sw.randomanirecommand.domain.Anime;
import com.sw.randomanirecommand.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimeService
{
    private final AnimeRepository repository;

    public Anime findByRandom()
    {
        return repository.findByRandom();
    }
}
