package com.sw.randomanirecommand.repository;

import com.sw.randomanirecommand.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnimeRepository extends JpaRepository<Anime, Long>
{
    @Query("select i from Anime i order by rand() limit 1")
    Anime findByRandom();
}
