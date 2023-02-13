create table ANIME
(
    code           bigint generated by default as identity,
    title          varchar2(100) unique,
    thumb          varchar2(200),
    originaltitle  varchar2(100),
    director       varchar2(100),
    production     varchar2(100),
    genre          varchar2(100),
    classification varchar2(50),
    airingyear     int,
    airingdate     varchar2(50),
    grade          varchar2(50),
    episodes       varchar2(50),
    primary key (code)
);

show columns from ANIME;

select * from ANIME order by rand() limit 1;