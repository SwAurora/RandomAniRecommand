package com.sw.randomanirecommand.repository;

import com.sw.randomanirecommand.domain.Anime;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long>
{
    @Query("select i from Anime i order by rand() limit 1")
    Anime findByRandom();

    Anime findByTitle(String title);

    @Query("select i from Anime i order by i.code desc")
    List<Anime> findAllByPage(Pageable pageable);
}