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

    @GetMapping("/random")
    public String showByRandom(Model model)
    {
        Anime anime = service.findByRandom();
        model.addAttribute("anime", anime);
        return "anime/showByRandom";
    }

    @GetMapping("/all")
    public String ShowAll(Model model)
    {
        List<Anime> animeList = service.findAllByPage(0);
        model.addAttribute("animeList", animeList);
        return "anime/showAll";
    }

    @GetMapping("/all/{page}")
    public String ShowAll(@PathVariable int page, Model model)
    {
        List<Anime> animeList = service.findAllByPage(page);
        model.addAttribute("animeList", animeList);
        return "anime/showAll";
    }

    @GetMapping("/year")
    public String ShowByYear(Model model)
    {

        model.addAttribute("", null);
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
