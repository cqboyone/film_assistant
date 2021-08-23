package com.vv.tool.film.assistant.crawler.webmagic.btsow;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @description:
 * @creator vv
 * @date 2021/8/23 19:53
 */
public class BtSowSearchBT implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        page.putField("name",page.getHtml().xpath("//div[@class='data-list']/div[@class='row']/a/@title").all());
        page.putField("href",page.getHtml().xpath("//div[@class='data-list']/div[@class='row']/a/@href").all());
        page.putField("size",page.getHtml().xpath("//div[@class='data-list']/div[@class='row']/div[@class='size']/text()").all());
        page.putField("time",page.getHtml().xpath("//div[@class='data-list']/div[@class='row']/div[@class='date']/text()").all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
//        String url ="https://btsow.one/search/夏日友晴天";
//        Spider.create(new BtSowSearchBT()).addUrl(url).addPipeline(new MovieSearchPipeline()).start();
    }
}
