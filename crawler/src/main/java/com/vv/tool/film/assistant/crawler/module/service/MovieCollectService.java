package com.vv.tool.film.assistant.crawler.module.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vv.tool.film.assistant.crawler.module.entity.MovieCollect;

/**
 * 电影集(MovieCollect)表服务接口
 *
 * @author vv
 * @since 2021-08-22 18:22:49
 */
public interface MovieCollectService extends IService<MovieCollect> {

    MovieCollect getByDouBanId(String douBanId);

}
