package com.vv.tool.film.assistant.crawler.webmagic.douban;

import com.vv.tool.film.assistant.crawler.webmagic.pipeline.MoviePipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @description:
 * @creator
 * @date 2021/8/20 15:26
 */
public class NowPlayingPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    /**
     * process the page, extract urls to fetch, extract the data and store
     *
     * @param page page
     */
    @Override
    public void process(Page page) {
        page.putField("movies", page.getHtml().xpath("//div[@id='nowplaying']").css("li.list-item", "data-title").all());
        page.putField("rate", page.getHtml().xpath("//div[@id='nowplaying']").css("li.list-item", "data-score").all());
    }

    /**
     * get the site settings
     *
     * @return site
     * @see Site
     */
    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        String url = "https://movie.douban.com/cinema/nowplaying/chongqing";
        Spider.create(new NowPlayingPageProcessor()).addUrl(url)
                .addPipeline(new MoviePipeline()).run();
    }

}
