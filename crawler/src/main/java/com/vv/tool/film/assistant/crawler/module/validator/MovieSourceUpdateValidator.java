package com.vv.tool.film.assistant.crawler.module.validator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 电影资源(MovieSource)表更新校验实体
 *
 * @author vv
 * @since 2021-08-23 23:51:39
 */
@SuppressWarnings("serial")
@Data
@ApiModel(value = "MovieSourceUpdateValidator", description = "电影资源更新校验实体")
public class MovieSourceUpdateValidator extends MovieSourceInsertValidator implements Serializable {
    private static final long serialVersionUID = -21899163387449795L;

    @NotBlank
    @ApiModelProperty(name = "id", value = "主键", allowEmptyValue = true, example = "")
    private String id;

}
