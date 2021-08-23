package com.vv.tool.film.assistant.crawler.webmagic;

import com.vv.tool.film.assistant.crawler.module.service.MovieCollectService;
import com.vv.tool.film.assistant.crawler.webmagic.douban.NowPlayingPageProcessor;
import com.vv.tool.film.assistant.crawler.webmagic.pipeline.MovieSavePipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

@Component
public class CrawlerManager {

    @Autowired
    private MovieCollectService movieCollectService;

    @Scheduled(cron = "${cron.1:0 0/1 * * * ?}")
    public void updateLikedCountForProductInfo() {
        String url = "https://movie.douban.com/cinema/nowplaying/chongqing";
        Spider.create(new NowPlayingPageProcessor()).addUrl(url)
                .addPipeline(new MovieSavePipeline(movieCollectService)).start();
    }
}
