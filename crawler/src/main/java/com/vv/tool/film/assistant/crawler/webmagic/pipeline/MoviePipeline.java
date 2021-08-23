package com.vv.tool.film.assistant.crawler.webmagic.pipeline;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.vv.tool.film.assistant.crawler.module.entity.MovieCollect;
import com.vv.tool.film.assistant.crawler.module.service.MovieCollectService;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

@NoArgsConstructor
public class MoviePipeline implements Pipeline {

    private MovieCollectService movieCollectService;

    public MoviePipeline(MovieCollectService movieCollectService) {
        this.movieCollectService = movieCollectService;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<String> movies = resultItems.get("movies");
        List<String> rate = resultItems.get("rate");
        for (int i = 0; i < movies.size(); i++) {
            String movieName = movies.get(i);
            if(StringUtils.isBlank(movieName)){
                continue;
            }
            //过滤评分
            double score = Double.parseDouble(rate.get(i));
            if (score < 7) {
                continue;
            }
            MovieCollect movieCollect = new MovieCollect();
            movieCollect.setMovieName(movieName);
            movieCollect.setMovieScore(score);
            movieCollectService.saveOrUpdate(movieCollect, new LambdaUpdateWrapper<MovieCollect>()
                    .eq(MovieCollect::getMovieName, movieName));
        }
    }
}
