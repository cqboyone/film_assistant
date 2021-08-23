package com.vv.tool.film.assistant.crawler.module.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 电影资源(MovieSource)表展示
 *
 * @author vv
 * @since 2021-08-23 23:11:56
 */
@SuppressWarnings("serial")
@Data
@ApiModel(value = "MovieSourceVo", description = "展示电影资源")
public class MovieSourceVo implements Serializable {
    private static final long serialVersionUID = -89074741727802294L;
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
     * 电影id
     */
    @ApiModelProperty(name = "movieId", value = "电影id")
    private String movieId;
    /**
     * 资源类型
     */
    @ApiModelProperty(name = "sourceType", value = "资源类型")
    private String sourceType;
    /**
     * 资源详情
     */
    @ApiModelProperty(name = "sourceDetail", value = "资源详情")
    private String sourceDetail;
}
