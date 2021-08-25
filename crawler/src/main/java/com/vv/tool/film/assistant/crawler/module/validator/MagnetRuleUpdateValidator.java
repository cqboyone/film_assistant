package com.vv.tool.film.assistant.crawler.module.validator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 磁力规则(MagnetRule)表更新校验实体
 *
 * @author vv
 * @since 2021-08-25 20:28:54
 */
@SuppressWarnings("serial")
@Data
@ApiModel(value = "MagnetRuleUpdateValidator", description = "磁力规则更新校验实体")
public class MagnetRuleUpdateValidator extends MagnetRuleInsertValidator implements Serializable {
    private static final long serialVersionUID = -73370148454861560L;

    @NotBlank
    @ApiModelProperty(name = "id", value = "主键", allowEmptyValue = true, example = "")
    private String id;

}
