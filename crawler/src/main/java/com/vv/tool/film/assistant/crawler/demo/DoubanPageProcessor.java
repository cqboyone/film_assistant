package com.vv.tool.film.assistant.crawler.demo;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @creator
 * @date 2021/8/20 15:11
 */
public class DoubanPageProcessor implements PageProcessor {

    private Site site;

    public DoubanPageProcessor(String urlPattern) {
        this.site = Site.me().setRetryTimes(3).setSleepTime(300);  // 设置站点重试次数3 间隔300ms
    }

    @Override
    public void process(Page page) {
        page.putField("title", page.getHtml().xpath("//title/text()")); //爬取网页标题
//        page.putField("html", page.getHtml().toString()); //爬取整个页面的html
        page.putField("titleList", page.getHtml().css("div.short-content", "text").all()); // 我们要爬取的核心信息内容，获取方式与css选择器用法一样
//        page.putField("content", page.getHtml().smartContent());
    }

    @Override
    public Site getSite() {
        //settings
        return site;
    }

    public static void main(String[] args) {

        Spider spider = Spider.create(new DoubanPageProcessor("https://movie\\.douban\\.com\\d+"));
        ResultItems resultItems = spider.<ResultItems>get("https://movie.douban.com/subject/35096844/reviews?start=0");// 爬取并获得爬取结果
        Map<String, Object> map = resultItems.getAll();
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue()); //打印爬取的所有内容
        }
        List<String> shortList = (List<String>) map.get("titleList");
        System.out.println("=====================分隔线===================\n短评如下：");
        for (int i = 0; i < shortList.size(); i++) {
            System.out.println(i + "、" + shortList.get(i).trim()); // 打印爬取的评论内容
        }
        spider.close();
    }

}