package com.vv.tool.film.assistant.crawler.webmagic.btsow;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @description:
 * @creator vv
 * @date 2021/8/23 20:30
 */
public class BtSowDetail implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(300);

    /**
     * process the page, extract urls to fetch, extract the data and store
     *
     * @param page page
     */
    @Override
    public void process(Page page) {
        page.putField("bt",page.getHtml().xpath("//textarea[@id='magnetLink']/text()").get());
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
        String url ="https://btsow.one/magnet/detail/hash/987B947ADBB94E0A9F119F9FF243ABD3E9EB2209";
        ResultItems resultItems = Spider.create(new BtSowDetail()).get(url);
        System.out.println(resultItems.get("bt").toString());
    }
}
