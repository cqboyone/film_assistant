package com.vv.tool.film.assistant.crawler.module.validator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 电影集(MovieCollect)表更新校验实体
 *
 * @author vv
 * @since 2021-08-22 21:40:42
 */
@SuppressWarnings("serial")
@Data
@ApiModel(value = "MovieCollectUpdateValidator", description = "电影集更新校验实体")
public class MovieCollectUpdateValidator extends MovieCollectInsertValidator implements Serializable {
    private static final long serialVersionUID = 332582393468449672L;

    @NotBlank
    @ApiModelProperty(name = "id", value = "主键", allowEmptyValue = true, example = "")
    private String id;

}
