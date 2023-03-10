package com.sw.randomanirecommand.service;

import com.sw.randomanirecommand.domain.Anime;
import com.sw.randomanirecommand.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AnimeService
{
    private final AnimeRepository repository;

    public Anime findByRandom()
    {
        return repository.findByRandom();
    }

    public Anime findByGenreRandom(String genre)
    {
        return repository.findByGenreRandom(genre);
    }

    public Anime findByTitle(String title)
    {
        return repository.findByTitle(title);
    }

    public List<Anime> findAllByPage(int page, int row)
    {
        return repository.findAllByPage(PageRequest.of(page, row));
    }

    public long getCount()
    {
        return repository.count();
    }

    public List<Anime> findByAiringYearPage(int year, int page, int row)
    {
        return repository.findByAiringYearPage(year, PageRequest.of(page, row));
    }

    public int getCountByYear(int year)
    {
        return repository.countByAiringYear(year);
    }

    public List<String> findGenre()
    {
        return repository.findGenre();
    }
}
