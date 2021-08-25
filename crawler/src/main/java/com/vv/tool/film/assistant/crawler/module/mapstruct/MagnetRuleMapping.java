package com.vv.tool.film.assistant.crawler.module.mapstruct;

import com.vv.tool.film.assistant.crawler.module.entity.MagnetRule;
import com.vv.tool.film.assistant.crawler.module.validator.MagnetRuleInsertValidator;
import com.vv.tool.film.assistant.crawler.module.validator.MagnetRuleUpdateValidator;
import com.vv.tool.film.assistant.crawler.module.vo.MagnetRuleVo;
import org.mapstruct.Mapper;

/**
 * 磁力规则(MagnetRule)表实体转换类
 *
 * @author vv
 * @since 2021-08-25 20:28:53
 */
@Mapper(componentModel = "spring")
public interface MagnetRuleMapping {

    MagnetRuleVo po2Vo(MagnetRule po);

    MagnetRule insert2Po(MagnetRuleInsertValidator v);

    MagnetRule update2Po(MagnetRuleUpdateValidator v);
}
