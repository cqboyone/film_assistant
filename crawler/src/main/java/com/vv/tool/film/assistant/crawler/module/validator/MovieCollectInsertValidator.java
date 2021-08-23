package com.vv.tool.film.assistant.crawler.module.validator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 电影集(MovieCollect)表插入校验实体
 *
 * @author vv
 * @since 2021-08-22 21:40:41
 */
@SuppressWarnings("serial")
@Data
@ApiModel(value = "MovieCollectInsertValidator", description = "电影集插入校验实体")
public class MovieCollectInsertValidator implements Serializable {
    private static final long serialVersionUID = 989719133016388008L;

    @ApiModelProperty(name = "movieName", value = "电影名称", allowEmptyValue = true)
    private String movieName;

    @ApiModelProperty(name = "movieScore", value = "评分", allowEmptyValue = true)
    private Double movieScore;

    @ApiModelProperty(name = "doubanId", value = "豆瓣id", allowEmptyValue = true)
    private String doubanId;

    @ApiModelProperty(name = "movieStagePhoto", value = "剧照", allowEmptyValue = true)
    private String movieStagePhoto;

    @ApiModelProperty(name = "archive", value = "归档")
    private String archive;

}
