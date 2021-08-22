package com.vv.tool.film.assistant.crawler.module.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vv.tool.film.assistant.crawler.module.dao.MovieCollectDao;
import com.vv.tool.film.assistant.crawler.module.entity.MovieCollect;
import com.vv.tool.film.assistant.crawler.module.service.MovieCollectService;
import org.springframework.stereotype.Service;

/**
 * 电影集(MovieCollect)表服务实现类
 *
 * @author vv
 * @since 2021-08-22 18:22:50
 */
@Service("movieCollectService")
public class MovieCollectServiceImpl extends ServiceImpl<MovieCollectDao, MovieCollect> implements MovieCollectService {

}
