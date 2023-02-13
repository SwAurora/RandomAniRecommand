package com.sw.randomanirecommand.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Anime
{
    @Id
    private long code;
    private String title;
    private String thumb;
    private String originalTitle;
    private String director;
    private String production;
    private String genre;
    private String classification;
    private int airingYear;
    private String airingDate;
    private String grade;
    private String episodes;
}