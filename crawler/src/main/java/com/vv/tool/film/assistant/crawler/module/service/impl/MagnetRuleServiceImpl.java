package com.vv.tool.film.assistant.crawler.module.service.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
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

    @Override
    public void saveByJson(String json) {
        JSONObject jsonObject = JSONUtil.parseObj(json);
        String id = jsonObject.getStr("id");
        String name = jsonObject.getStr("name");
        String url = jsonObject.getStr("url");
        String icon = jsonObject.getStr("icon");
        Boolean proxy = jsonObject.getBool("proxy");
        JSONObject paths = jsonObject.getJSONObject("paths");
        JSONObject xpath = jsonObject.getJSONObject("xpath");
        String pathsPreset = paths.getStr("preset");
        String pathsTime = paths.getStr("time");
        String pathsSize = paths.getStr("size");
        String pathsHot = paths.getStr("hot");
        String xpathGroup = xpath.getStr("group");
        String xpathMagnet = xpath.getStr("magnet");
        String xpathName = xpath.getStr("name");
        String xpathSize = xpath.getStr("size");
        String xpathDate = xpath.getStr("date");
        String xpathHot = xpath.getStr("hot");
        String xpathDetail = xpath.getStr("detail");
        MagnetRule magnetRule = MagnetRule.builder()
                .id(id)
                .magnetName(name)
                .magnetUrl(url)
                .magnetIcon(icon)
                .magnetProxy(proxy)
                .pathsPreset(pathsPreset)
                .pathsTime(pathsTime)
                .pathsSize(pathsSize)
                .pathsHot(pathsHot)
                .xpathGroup(xpathGroup)
                .xpathMagnet(xpathMagnet)
                .xpathName(xpathName)
                .xpathSize(xpathSize)
                .xpathDate(xpathDate)
                .xpathHot(xpathHot)
                .xpathDetail(xpathDetail)
                .build();
        this.save(magnetRule);
    }
}
