package com.vv.tool.film.assistant.crawler.module.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vv.tool.film.assistant.crawler.module.entity.MagnetRule;

/**
 * 磁力规则(MagnetRule)表服务接口
 *
 * @author vv
 * @since 2021-08-25 20:28:53
 */
public interface MagnetRuleService extends IService<MagnetRule> {

    void saveByJson(String json);

}
