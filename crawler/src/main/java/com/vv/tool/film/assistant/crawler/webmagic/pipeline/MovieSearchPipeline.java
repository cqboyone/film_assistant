package com.vv.tool.film.assistant.crawler.webmagic.pipeline;

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

    public MovieSearchPipeline(MovieSourceService movieSourceService, MovieCollectService movieCollectService) {
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
            String bt = ri.get("bt");
            href.set(i, bt);
            MovieSource movieSource = new MovieSource();
//            movieSource.setMovieId(movieCollectService.getByDouBanId());
            movieSource.setSourceDetail(ri.get("bt"));
        }
        System.out.println(resultItems);
    }
}
