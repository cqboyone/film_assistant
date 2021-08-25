package com.vv.tool.film.assistant.crawler.module.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vv.tool.film.assistant.crawler.module.dao.MagnetRuleDao;
import com.vv.tool.film.assistant.crawler.module.entity.MagnetRule;
import com.vv.tool.film.assistant.crawler.module.service.MagnetRuleService;
import org.springframework.stereotype.Service;

/**
 * 磁力规则(MagnetRule)表服务实现类
 *
 * @author vv
 * @since 2021-08-25 20:28:53
 */
@Service("magnetRuleService")
public class MagnetRuleServiceImpl extends ServiceImpl<MagnetRuleDao, MagnetRule> implements MagnetRuleService {

}
