package com.sw.randomanirecommand.controller;

import com.sw.randomanirecommand.domain.Anime;
import com.sw.randomanirecommand.service.AnimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/anime")
@RequiredArgsConstructor
public class AnimeController
{
    private final AnimeService service;

    private static final int ROW = 20;

    @GetMapping("/random")
    public String showByRandom(Model model)
    {
        Anime anime = service.findByRandom();
        model.addAttribute("anime", anime);
        return "anime/showByRandom";
    }

    @GetMapping("/all")
    public String ShowAll()
    {
        return "redirect:/anime/all/1";
    }

    @GetMapping("/all/{page}")
    public String ShowAll(@PathVariable int page, Model model)
    {
        List<Anime> animeList = service.findAllByPage(page - 1, ROW);
        model.addAttribute("animeList", animeList);
        long count = service.getCount();
        model.addAttribute("total", count);
        model.addAttribute("row", ROW);
        model.addAttribute("nowPage", page);
        return "anime/showAll";
    }

    @GetMapping("/year")
    public String ShowByYear()
    {
        return "redirect:/anime/year/2011/1";
    }

    @GetMapping("/year/{year}/{page}")
    public String ShowByYear(@PathVariable int year, @PathVariable int page, Model model)
    {
        List<Anime> animeList = service.findByAiringYearPage(year, page - 1, ROW);
        model.addAttribute("animeList", animeList);
        long count = service.getCountByYear(year);
        model.addAttribute("total", count);
        model.addAttribute("row", ROW);
        model.addAttribute("nowPage", page);
        model.addAttribute("nowYear", year);
        return "anime/showByYear";
    }

    @GetMapping("/info")
    public String AnimeInfo(String title, Model model)
    {
        Anime anime = service.findByTitle(title);
        model.addAttribute("anime", anime);
        return "anime/info";
    }

}
