package com.vv.tool.film.assistant.crawler.module.mapstruct;

import com.vv.tool.film.assistant.crawler.module.entity.MovieCollect;
import com.vv.tool.film.assistant.crawler.module.validator.MovieCollectInsertValidator;
import com.vv.tool.film.assistant.crawler.module.validator.MovieCollectUpdateValidator;
import com.vv.tool.film.assistant.crawler.module.vo.MovieCollectVo;
import org.mapstruct.Mapper;

/**
 * 电影集(MovieCollect)表实体转换类
 *
 * @author vv
 * @since 2021-08-22 18:22:51
 */
@Mapper(componentModel = "spring")
public interface MovieCollectMapping {

    MovieCollectVo po2Vo(MovieCollect po);

    MovieCollect insert2Po(MovieCollectInsertValidator v);

    MovieCollect update2Po(MovieCollectUpdateValidator v);
}
