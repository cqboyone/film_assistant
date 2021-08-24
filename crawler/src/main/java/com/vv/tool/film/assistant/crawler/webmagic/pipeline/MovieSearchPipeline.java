package com.vv.tool.film.assistant.crawler.webmagic.pipeline;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.vv.tool.film.assistant.crawler.module.entity.MovieSource;
import com.vv.tool.film.assistant.crawler.module.service.MovieCollectService;
import com.vv.tool.film.assistant.crawler.module.service.MovieSourceService;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @creator vv
 * @date 2021/8/23 20:01
 */
@NoArgsConstructor
public class MovieSearchPipeline implements Pipeline {

    private MovieSourceService movieSourceService;

    private MovieCollectService movieCollectService;

    private String movieId;

    public MovieSearchPipeline(
            String movieId,
            MovieSourceService movieSourceService,
            MovieCollectService movieCollectService) {
        this.movieId = movieId;
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
            MovieSource movieSource = new MovieSource();
            movieSource.setMovieId(movieId);
            movieSource.setSourceDetail(extractMagnet(href.get(i)));
            movieSource.setSourceSize(size.get(i));
            movieSource.setSourceTime(time.get(i));
            movieSourceService.saveOrUpdate(movieSource, new LambdaUpdateWrapper<MovieSource>()
                    .eq(MovieSource::getSourceDetail, href.get(i))
            );
        }
    }

    public String extractMagnet(String url) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        final String regex_magnet = "magnet:\\?xt=urn:btih:";
        boolean matches = Pattern.matches(regex_magnet, url);
        if (matches) {
            return url.toLowerCase();
        }
        final String regex_hash_32_40 = "[\\da-zA-Z]{32,40}";
        Pattern pattern = Pattern.compile(regex_hash_32_40);
        Matcher m = pattern.matcher(url);
        while (m.find()) {
            return "magnet:?xt=urn:btih:" + m.group(0).toLowerCase();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new MovieSearchPipeline().extractMagnet("//btsow.one/magnet/detail/hash/987B947ADBB94E0A9F119F9FF243ABD3E9EB2209"));
    }
}
