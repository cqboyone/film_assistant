package com.vv.tool.film.assistant.crawler.module.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vv.tool.film.assistant.crawler.module.dao.MovieCollectDao;
import com.vv.tool.film.assistant.crawler.module.entity.MovieCollect;
import com.vv.tool.film.assistant.crawler.module.service.MovieCollectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 电影集(MovieCollect)表服务实现类
 *
 * @author vv
 * @since 2021-08-22 18:22:50
 */
@Service("movieCollectService")
public class MovieCollectServiceImpl extends ServiceImpl<MovieCollectDao, MovieCollect> implements MovieCollectService {

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    @Override
    public MovieCollect getByDouBanId(String douBanId) {
        return this.getOne(new LambdaQueryWrapper<MovieCollect>()
                .eq(MovieCollect::getDoubanId, douBanId));
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    @Override
    public List<MovieCollect> getUnArchive() {
        return this.list(new LambdaQueryWrapper<MovieCollect>()
                .eq(MovieCollect::getArchive, false));
    }
}
