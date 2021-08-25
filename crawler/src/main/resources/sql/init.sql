-- create database film_assistant;

create table movie_collect
(
    id                varchar(32)  not null comment '主键'
        primary key,
    created_time      datetime     not null comment '创建时间',
    updated_time      datetime     not null comment '更新时间',
    movie_name        varchar(128) not null comment '电影名称',
    movie_score       double       null comment '评分',
    douban_id         varchar(32)  null comment '豆瓣id',
    movie_stage_photo text         null comment '剧照',
    archive           boolean      not null default false comment '归档',
    constraint movie_collect_movie_name_uindex
        unique (movie_name)
) comment '电影集';
create
    unique index movie_collect_movie_name_uindex
    on movie_collect (movie_name);

create table movie_source
(
    id            varchar(32) not null comment '主键'
        primary key,
    created_time  datetime    not null comment '创建时间',
    updated_time  datetime    not null comment '更新时间',
    movie_id      varchar(32) not null comment '电影id',
    source_type   varchar(32) not null default 'bt' comment '资源类型',
    source_detail text        not null comment '资源详情',
    source_size   varchar(32) null comment '资源大小',
    source_time   varchar(64) null comment '资源上线时间'
) comment '电影资源';

create table magnet_rule
(
    id           varchar(32)  not null comment '主键'
        primary key,
    created_time datetime     not null comment '创建时间',
    updated_time datetime     not null comment '更新时间',
    magnet_name  varchar(64)  not null comment '源站名称',
    magnet_url   varchar(512) not null comment '源站首页',
    magnet_icon  varchar(512) null comment '源站图标',
    magnet_proxy boolean      null default false comment '是否需要代理',
    paths_preset varchar(512) null comment '默认排序路径',
    paths_time   varchar(512) null comment '时间排序路径',
    paths_size   varchar(512) null comment '文件大小排序路径	',
    paths_hot    varchar(512) null comment '人气排序路径',
    xpath_group  varchar(512) not null comment 'xpath:Item容器',
    xpath_magnet varchar(512) not null comment 'xpath:磁力链接',
    xpath_name   varchar(512) not null comment 'xpath:名称',
    xpath_size   varchar(512) not null comment 'xpath:文件大小',
    xpath_date   varchar(512) not null comment 'xpath:时间',
    xpath_hot    varchar(512) not null comment 'xpath:人气',
    xpath_detail varchar(512) null comment 'xpath:详情'
) comment '磁力规则';