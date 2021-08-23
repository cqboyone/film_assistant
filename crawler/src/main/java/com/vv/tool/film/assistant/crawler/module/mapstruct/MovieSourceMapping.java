package com.vv.tool.film.assistant.crawler.module.mapstruct;

import com.vv.tool.film.assistant.crawler.module.entity.MovieSource;
import com.vv.tool.film.assistant.crawler.module.validator.MovieSourceInsertValidator;
import com.vv.tool.film.assistant.crawler.module.validator.MovieSourceUpdateValidator;
import com.vv.tool.film.assistant.crawler.module.vo.MovieSourceVo;
import org.mapstruct.Mapper;

/**
 * 电影资源(MovieSource)表实体转换类
 *
 * @author vv
 * @since 2021-08-23 23:11:56
 */
@Mapper(componentModel = "spring")
public interface MovieSourceMapping {

    MovieSourceVo po2Vo(MovieSource po);

    MovieSource insert2Po(MovieSourceInsertValidator v);

    MovieSource update2Po(MovieSourceUpdateValidator v);
}
