-- create
-- database film_assistant;

create table movie_collect
(
    id                varchar(32)  not null comment '主键'
        primary key,
    created_time      datetime     not null comment '创建时间',
    updated_time      datetime     not null comment '更新时间',
    movie_name        varchar(128) not null comment '电影名称',
    movie_score       double null comment '评分',
    douban_id         varchar(32) null comment '豆瓣id',
    movie_stage_photo text null comment '剧照',
    constraint movie_collect_movie_name_uindex
        unique (movie_name)
) comment '电影集';
create
unique index movie_collect_movie_name_uindex
	on movie_collect (movie_name);