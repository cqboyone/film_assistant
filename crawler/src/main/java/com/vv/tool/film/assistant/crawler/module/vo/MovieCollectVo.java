package com.vv.tool.film.assistant.crawler.module.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 电影集(MovieCollect)表展示
 *
 * @author vv
 * @since 2021-08-22 21:40:40
 */
@SuppressWarnings("serial")
@Data
@ApiModel(value = "MovieCollectVo", description = "展示电影集")
public class MovieCollectVo implements Serializable {
    private static final long serialVersionUID = -44771995858770974L;
    /**
     * 主键
     */
    @ApiModelProperty(name = "id", value = "主键")
    private String id;
    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createdTime", value = "创建时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(name = "updatedTime", value = "更新时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;
    /**
     * 电影名称
     */
    @ApiModelProperty(name = "movieName", value = "电影名称")
    private String movieName;
    /**
     * 评分
     */
    @ApiModelProperty(name = "movieScore", value = "评分")
    private Double movieScore;
    /**
     * 豆瓣id
     */
    @ApiModelProperty(name = "doubanId", value = "豆瓣id")
    private String doubanId;
    /**
     * 剧照
     */
    @ApiModelProperty(name = "movieStagePhoto", value = "剧照")
    private String movieStagePhoto;
    /**
     * 归档
     */
    @ApiModelProperty(name = "archive", value = "归档")
    private String archive;
}
