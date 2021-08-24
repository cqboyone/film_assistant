package com.vv.tool.film.assistant.crawler.webmagic;

import com.vv.tool.film.assistant.crawler.module.entity.MovieCollect;
import com.vv.tool.film.assistant.crawler.module.service.MovieCollectService;
import com.vv.tool.film.assistant.crawler.module.service.MovieSourceService;
import com.vv.tool.film.assistant.crawler.webmagic.btsow.BtSowSearchBT;
import com.vv.tool.film.assistant.crawler.webmagic.douban.NowPlayingPageProcessor;
import com.vv.tool.film.assistant.crawler.webmagic.pipeline.MovieSavePipeline;
import com.vv.tool.film.assistant.crawler.webmagic.pipeline.MovieSearchPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import java.util.List;

@Component
public class CrawlerManager {

    @Autowired
    private MovieCollectService movieCollectService;

    @Autowired
    private MovieSourceService movieSourceService;

    @Scheduled(cron = "${cron.1:0 0/1 * * * ?}")
    public void findNowPlaying() {
        String url = "https://movie.douban.com/cinema/nowplaying/chongqing";
        Spider.create(new NowPlayingPageProcessor()).addUrl(url)
                .addPipeline(new MovieSavePipeline(movieCollectService)).run();
    }

    @Scheduled(cron = "${cron.2:0 0/1 * * * ?}")
    public void findMovieSource() {
        List<MovieCollect> unArchive = movieCollectService.getUnArchive();
        unArchive.stream()
                .forEach(e -> {
                    String url = "https://btsow.one/search/" + e.getMovieName();
                    Spider.create(
                            new BtSowSearchBT())
                            .addUrl(url)
                            .addPipeline(new MovieSearchPipeline(e.getId(), movieSourceService, movieCollectService))
                            .run();

                });
    }
}
