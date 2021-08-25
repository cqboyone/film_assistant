package com.vv.tool.film.assistant.crawler.module.validator;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 磁力规则(MagnetRule)表分页查询校验实体
 *
 * @author vv
 * @since 2021-08-25 20:28:54
 */
@SuppressWarnings("serial")
@Data
@ApiModel(value = "MagnetRulePageValidator", description = "磁力规则分页查询校验实体")
public class MagnetRulePageValidator extends BasePageValidator implements Serializable {
    private static final long serialVersionUID = 941037521289503816L;

}
