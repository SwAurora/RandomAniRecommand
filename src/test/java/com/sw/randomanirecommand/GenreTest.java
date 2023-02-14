package com.sw.randomanirecommand;

import com.sw.randomanirecommand.domain.Anime;
import com.sw.randomanirecommand.service.AnimeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class GenreTest
{
    @Autowired
    AnimeService service;

    @Test
    void test1()
    {
        List<String> genres = new ArrayList<>();

        List<String> findGenre = service.findGenre();
        for(String s : findGenre)
        {
            genres.addAll(Arrays.asList(s.split(",")));
        }

        genres.stream().distinct().toList().forEach(System.out::println);
    }

    @Test
    void test2()
    {
        String genre = "%이세계%";
        Anime anime = service.findByGenreRandom(genre);
        System.out.println(anime);
    }
}
