package com.vv.tool.film.assistant.crawler.module.validator;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 电影集(MovieCollect)表分页查询校验实体
 *
 * @author vv
 * @since 2021-08-22 21:40:43
 */
@SuppressWarnings("serial")
@Data
@ApiModel(value = "MovieCollectPageValidator", description = "电影集分页查询校验实体")
public class MovieCollectPageValidator extends BasePageValidator implements Serializable {
    private static final long serialVersionUID = 798112819706051538L;

}
