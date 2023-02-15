create table Anime
(
    code           bigint auto_increment,
    title          varchar(100) unique,
    thumb          varchar(200),
    originaltitle  varchar(100),
    director       varchar(100),
    production     varchar(100),
    genre          varchar(100),
    classification varchar(50),
    airingyear     int,
    airingdate     varchar(50),
    grade          varchar(50),
    episodes       varchar(50),
    primary key (code)
);

create table Member
(
    id bigint auto_increment,
    uid varchar(50) unique,
    upw varchar(200) not null,
    nickName varchar(50) unique,
    regDate date not null,
    role varchar(10) not null,
    primary key (id)
);

create table Comment
(
    no bigint auto_increment,
    code bigint,
    nickName varchar(50),
    comment varchar(200),
    primary key (no)
);

update Anime set title = 'W`z (위즈)' where title in (select title from (select title from Anime where title like '%위즈%') as A);