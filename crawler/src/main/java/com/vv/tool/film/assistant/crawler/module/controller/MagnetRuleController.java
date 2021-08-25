package com.vv.tool.film.assistant.crawler.module.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vv.tool.film.assistant.crawler.common.bo.BasePage;
import com.vv.tool.film.assistant.crawler.common.bo.BaseResult;
import com.vv.tool.film.assistant.crawler.common.exception.ApiException;
import com.vv.tool.film.assistant.crawler.module.entity.MagnetRule;
import com.vv.tool.film.assistant.crawler.module.mapstruct.MagnetRuleMapping;
import com.vv.tool.film.assistant.crawler.module.service.MagnetRuleService;
import com.vv.tool.film.assistant.crawler.module.validator.MagnetRuleInsertValidator;
import com.vv.tool.film.assistant.crawler.module.validator.MagnetRulePageValidator;
import com.vv.tool.film.assistant.crawler.module.validator.MagnetRuleUpdateValidator;
import com.vv.tool.film.assistant.crawler.module.vo.MagnetRuleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.vv.tool.film.assistant.crawler.common.enums.CommonErrorCode.FIND_DATA_IS_NULL;

/**
 * 磁力规则(MagnetRule)表控制层
 *
 * @author vv
 * @since 2021-08-25 20:28:53
 */
@RestController
@RequestMapping("magnetRule")
@Api(tags = "磁力规则")
@Validated //要验证list需要使用该注解
@Slf4j
public class MagnetRuleController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private MagnetRuleService magnetRuleService;

    /**
     * mapping
     */
    @Resource
    private MagnetRuleMapping magnetRuleMapping;

    /**
     * 分页查询所有数据
     *
     * @param v 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据", notes = "分页查询所有数据")
    @PostMapping("page")
    public BaseResult<BasePage<MagnetRuleVo>> selectAll(@Valid @RequestBody MagnetRulePageValidator v) {
        Page<MagnetRule> page = new Page(v.getPageNumber(), v.getPageSize());
        Page<MagnetRule> infoPage = this.magnetRuleService.page(page);
        BasePage<MagnetRuleVo> basePage = new BasePage(infoPage.getTotal(),
                infoPage.getRecords().stream().map(e -> this.magnetRuleMapping.po2Vo(e)).collect(Collectors.toList()));
        return BaseResult.success(basePage);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据", notes = "通过主键查询单条数据")
    @GetMapping("{id}")
    public BaseResult<MagnetRuleVo> selectOne(@PathVariable @ApiParam(value = "主键") Serializable id) {
        return BaseResult.success(
                Optional.ofNullable(this.magnetRuleService.getById(id))
                        .map(e -> this.magnetRuleMapping.po2Vo(e))
                        .orElseThrow(() -> new ApiException(FIND_DATA_IS_NULL)));
    }

    /**
     * 新增数据
     *
     * @param v 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据", notes = "新增数据")
    @PostMapping
    public BaseResult insert(@Valid @RequestBody MagnetRuleInsertValidator v) {
        MagnetRule magnetRule = this.magnetRuleMapping.insert2Po(v);
        this.magnetRuleService.save(magnetRule);
        return BaseResult.success();
    }

    /**
     * 新增数据
     *
     * @param v 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据2", notes = "新增数据")
    @PostMapping("2")
    public BaseResult insertStr(@Valid @RequestBody String v) {
        this.magnetRuleService.saveByJson(v);
        return BaseResult.success();
    }

    /**
     * 修改数据
     *
     * @param v 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据", notes = "修改数据")
    @PutMapping
    public BaseResult update(@Valid @RequestBody MagnetRuleUpdateValidator v) {
        this.magnetRuleService.updateById(this.magnetRuleMapping.update2Po(v));
        return BaseResult.success();
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation(value = "删除数据", notes = "删除数据")
    @DeleteMapping
    public BaseResult delete(@ApiParam(value = "主键列表") @RequestParam("idList") List<String> idList) {
        this.magnetRuleService.removeByIds(idList);
        return BaseResult.success();
    }
}
