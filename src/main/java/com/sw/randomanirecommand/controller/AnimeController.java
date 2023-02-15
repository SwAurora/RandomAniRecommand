package com.sw.randomanirecommand.controller;

import com.sw.randomanirecommand.domain.Anime;
import com.sw.randomanirecommand.domain.Comment;
import com.sw.randomanirecommand.domain.Member;
import com.sw.randomanirecommand.service.AnimeService;
import com.sw.randomanirecommand.service.CommentService;
import com.sw.randomanirecommand.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/anime")
@RequiredArgsConstructor
public class AnimeController
{
    private final AnimeService animeService;
    private final CommentService commentService;
    private final MemberService memberService;

    private static final int ROW = 20;

    @GetMapping("/random")
    public String showByRandom(@Param("genre") String genre, Model model)
    {
        Anime anime;
        if(genre == null)
        {
            anime = animeService.findByRandom();
        }
        else
        {
            anime = animeService.findByGenreRandom("%" + genre + "%");
        }

        List<String> genres = getGenre();

        model.addAttribute("nowGenre", genre);
        model.addAttribute("genres", genres);
        model.addAttribute("anime", anime);
        return "anime/showByRandom";
    }

    private List<String> getGenre()
    {
        List<String> genres = new ArrayList<>();
        List<String> findGenre = animeService.findGenre();
        for(String s : findGenre)
        {
            genres.addAll(Arrays.asList(s.split(",")));
        }
        return genres.stream().distinct().toList();
    }

    @GetMapping("/all")
    public String ShowAll()
    {
        return "redirect:/anime/all/1";
    }

    @GetMapping("/all/{page}")
    public String ShowAll(@PathVariable int page, Model model)
    {
        List<Anime> animeList = animeService.findAllByPage(page - 1, ROW);
        model.addAttribute("animeList", animeList);
        long count = animeService.getCount();
        model.addAttribute("total", count);
        model.addAttribute("row", ROW);
        model.addAttribute("nowPage", page);
        return "anime/showAll";
    }

    @GetMapping("/year")
    public String ShowByYear()
    {
        return "redirect:/anime/year/2022/1";
    }

    @GetMapping("/year/{year}/{page}")
    public String ShowByYear(@PathVariable int year, @PathVariable int page, Model model)
    {
        List<Anime> animeList = animeService.findByAiringYearPage(year, page - 1, ROW);
        model.addAttribute("animeList", animeList);
        long count = animeService.getCountByYear(year);
        model.addAttribute("total", count);
        model.addAttribute("row", ROW);
        model.addAttribute("nowPage", page);
        model.addAttribute("nowYear", year);
        return "anime/showByYear";
    }

    @GetMapping("/info")
    public String AnimeInfo(String title, Model model)
    {
        Anime anime = animeService.findByTitle(title);
        List<Comment> comments = commentService.getCommentListByCode(anime.getCode());
        for(Comment comment : comments)
        {
            comment.setComment(returnEntityCode(comment.getComment()));
        }
        model.addAttribute("anime", anime);
        model.addAttribute("comments", comments);
        return "anime/info";
    }

    @PostMapping("/comment")
    public String animeReview(String title, @RequestParam("comment") String paramComment, Long code, Principal principal)
    {
        String encodedTitle = URLEncoder.encode(title, StandardCharsets.UTF_8);
        String uid = principal.getName();
        Member member = memberService.findByUid(uid);
        Comment comment = new Comment();
        comment.setCode(code);
        comment.setNickName(member.getNickName());
        comment.setComment(replaceEntityCode(paramComment));

        commentService.saveComment(comment);

        return "redirect:/anime/info?title=" + encodedTitle;
    }

    private String replaceEntityCode(String sentence)
    {
        sentence = sentence.replaceAll("<", "&lt");
        sentence = sentence.replaceAll(">", "&gt");
        sentence = sentence.replaceAll("&", "&amp");
        sentence = sentence.replaceAll(",", "&quot");
        sentence = sentence.replaceAll("\n", "<br>");
        return sentence;
    }

    private String returnEntityCode(String sentence)
    {
        sentence = sentence.replaceAll("&lt", "<");
        sentence = sentence.replaceAll("&gt", ">");
        sentence = sentence.replaceAll("&amp", "&");
        sentence = sentence.replaceAll("&quot", ",");
        return sentence;
    }
}
