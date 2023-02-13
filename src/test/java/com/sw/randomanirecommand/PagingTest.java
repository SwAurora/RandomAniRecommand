package com.sw.randomanirecommand;

import com.sw.randomanirecommand.domain.Anime;
import com.sw.randomanirecommand.repository.AnimeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootTest
public class PagingTest
{
    @Autowired
    AnimeRepository repository;

    @Test
    void test1()
    {
        List<Anime> animeList = repository.findAllByPage(PageRequest.of(10, 10));
        for(Anime anime : animeList)
        {
            System.out.println(anime);
        }
    }

    @Test
    void test2()
    {
        long count = repository.count();
        System.out.println(count);
    }
}
