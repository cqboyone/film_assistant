package com.vv.tool.film.assistant.crawler.module.validator;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 电影资源(MovieSource)表分页查询校验实体
 *
 * @author vv
 * @since 2021-08-23 23:51:39
 */
@SuppressWarnings("serial")
@Data
@ApiModel(value = "MovieSourcePageValidator", description = "电影资源分页查询校验实体")
public class MovieSourcePageValidator extends BasePageValidator implements Serializable {
    private static final long serialVersionUID = -86789788785554536L;

}
