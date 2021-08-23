package com.vv.tool.film.assistant.crawler.module.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vv.tool.film.assistant.crawler.module.dao.MovieSourceDao;
import com.vv.tool.film.assistant.crawler.module.entity.MovieSource;
import com.vv.tool.film.assistant.crawler.module.service.MovieSourceService;
import org.springframework.stereotype.Service;

/**
 * 电影资源(MovieSource)表服务实现类
 *
 * @author vv
 * @since 2021-08-23 23:11:56
 */
@Service("movieSourceService")
public class MovieSourceServiceImpl extends ServiceImpl<MovieSourceDao, MovieSource> implements MovieSourceService {

}
