package com.vv.tool.film.assistant.crawler.webmagic.douban;

import com.vv.tool.film.assistant.crawler.webmagic.pipeline.MovieSavePipeline;
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
        //xpath css 混合.也可以用xpath方式
        page.putField("movies", page.getHtml().xpath("//div[@id='nowplaying']").css("li.list-item", "data-title").all());
//        //xpath
//        page.putField("movies", page.getHtml().xpath("//div[@id='nowplaying']/div[2]/ul/li/ul/li[@class='stitle']/a/text()").all());
        //这里用css是因为没有评分的话就没有标签，但是属性里面是有参数的。是0。
        page.putField("rates", page.getHtml().xpath("//div[@id='nowplaying']").css("li.list-item", "data-score").all());
        page.putField("imgs", page.getHtml().xpath("//div[@id='nowplaying']/div[@class='mod-bd']/ul/li/ul/li/a/img/@src").all());
        page.putField("ids", page.getHtml().xpath("//div[@id='nowplaying']/div[@class='mod-bd']/ul/li/@id").all());
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
                .addPipeline(new MovieSavePipeline()).start();
    }

}
