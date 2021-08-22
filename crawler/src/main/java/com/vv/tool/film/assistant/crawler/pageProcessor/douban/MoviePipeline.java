package com.vv.tool.film.assistant.crawler.pageProcessor.douban;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.HashMap;
import java.util.List;

public class MoviePipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        List<String> movies = resultItems.get("movies");
        List<String> rate = resultItems.get("rate");
        HashMap<String, String> moviesMap = new HashMap<>();
        for (int i = 0; i < movies.size(); i++) {
            //过滤评分
            if (Double.parseDouble(rate.get(i)) < 7) {
                continue;
            }
            moviesMap.put(movies.get(i), rate.get(i));
        }
        System.out.println(moviesMap);
    }
}
