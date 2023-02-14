package com.sw.randomanirecommand.repository;

import com.sw.randomanirecommand.domain.Anime;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long>
{
    @Query("select a from Anime a order by rand() limit 1")
    Anime findByRandom();

    @Query("select a from Anime a where a.genre like :genre order by rand() limit 1")
    Anime findByGenreRandom(@Param("genre") String genre);

    Anime findByTitle(String title);

    @Query("select a from Anime a order by a.code desc")
    List<Anime> findAllByPage(Pageable pageable);

    @Query("select a from Anime a where a.airingYear = :year order by a.code desc")
    List<Anime> findByAiringYearPage(@Param("year") int year, Pageable pageable);

    int countByAiringYear(int year);
    
    @Query("select a.genre from Anime a")
    List<String> findGenre();
}
