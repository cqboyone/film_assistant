package com.vv.tool.film.assistant.crawler.module.validator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 电影资源(MovieSource)表插入校验实体
 *
 * @author vv
 * @since 2021-08-23 23:11:57
 */
@SuppressWarnings("serial")
@Data
@ApiModel(value = "MovieSourceInsertValidator", description = "电影资源插入校验实体")
public class MovieSourceInsertValidator implements Serializable {
    private static final long serialVersionUID = 524944255539448171L;

    @ApiModelProperty(name = "movieId", value = "电影id", allowEmptyValue = true)
    private String movieId;

    @ApiModelProperty(name = "sourceType", value = "资源类型", allowEmptyValue = true)
    private String sourceType;

    @ApiModelProperty(name = "sourceDetail", value = "资源详情", allowEmptyValue = true)
    private String sourceDetail;

}
