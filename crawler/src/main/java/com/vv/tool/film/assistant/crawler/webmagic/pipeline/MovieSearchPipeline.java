package com.vv.tool.film.assistant.crawler.webmagic.pipeline;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.vv.tool.film.assistant.crawler.module.entity.MovieSource;
import com.vv.tool.film.assistant.crawler.module.service.MovieCollectService;
import com.vv.tool.film.assistant.crawler.module.service.MovieSourceService;
import com.vv.tool.film.assistant.crawler.webmagic.btsow.BtSowDetail;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * @description:
 * @creator vv
 * @date 2021/8/23 20:01
 */
@NoArgsConstructor
public class MovieSearchPipeline implements Pipeline {

    private MovieSourceService movieSourceService;

    private MovieCollectService movieCollectService;

    private String movieId;

    public MovieSearchPipeline(
            String movieId,
            MovieSourceService movieSourceService,
            MovieCollectService movieCollectService) {
        this.movieId = movieId;
        this.movieSourceService = movieSourceService;
        this.movieCollectService = movieCollectService;
    }

    /**
     * Process extracted results.
     *
     * @param resultItems resultItems
     * @param task        task
     */
    @Override
    public void process(ResultItems resultItems, Task task) {
        List<String> name = resultItems.get("name");
        List<String> href = resultItems.get("href");
        List<String> size = resultItems.get("size");
        List<String> time = resultItems.get("time");
        if (ObjectUtils.isEmpty(name) || ObjectUtils.isEmpty(href) || name.size() != href.size()) {
            return;
        }
        for (int i = 0; i < href.size(); i++) {
            ResultItems ri = Spider.create(new BtSowDetail()).get("https:" + href.get(i));
            if (ri == null) {
                continue;
            }
            String bt = ri.get("bt");
            MovieSource movieSource = new MovieSource();
            movieSource.setMovieId(movieId);
            movieSource.setSourceDetail(bt);
            movieSource.setSourceSize(size.get(i));
            movieSource.setSourceTime(time.get(i));
            movieSourceService.saveOrUpdate(movieSource, new LambdaUpdateWrapper<MovieSource>()
                    .eq(MovieSource::getSourceDetail, bt)
            );
        }
    }
}
