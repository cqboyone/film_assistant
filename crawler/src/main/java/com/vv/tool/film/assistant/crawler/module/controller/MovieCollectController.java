package com.vv.tool.film.assistant.crawler.module.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vv.tool.film.assistant.crawler.common.BO.BasePage;
import com.vv.tool.film.assistant.crawler.common.BO.BaseResult;
import com.vv.tool.film.assistant.crawler.common.exception.ApiException;
import com.vv.tool.film.assistant.crawler.module.entity.MovieCollect;
import com.vv.tool.film.assistant.crawler.module.mapstruct.MovieCollectMapping;
import com.vv.tool.film.assistant.crawler.module.service.MovieCollectService;
import com.vv.tool.film.assistant.crawler.module.validator.MovieCollectInsertValidator;
import com.vv.tool.film.assistant.crawler.module.validator.MovieCollectPageValidator;
import com.vv.tool.film.assistant.crawler.module.validator.MovieCollectUpdateValidator;
import com.vv.tool.film.assistant.crawler.module.vo.MovieCollectVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.vv.tool.film.assistant.crawler.common.enums.CommonErrorCode.FIND_DATA_IS_NULL;

/**
 * 电影集(MovieCollect)表控制层
 *
 * @author vv
 * @since 2021-08-22 18:22:50
 */
@RestController
@RequestMapping("movieCollect")
@Api(tags = "电影集")
@Validated //要验证list需要使用该注解
@Slf4j
public class MovieCollectController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private MovieCollectService movieCollectService;

    /**
     * mapping
     */
    @Resource
    private MovieCollectMapping movieCollectMapping;

    /**
     * 分页查询所有数据
     *
     * @param v 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据", notes = "分页查询所有数据")
    @PostMapping("page")
    public BaseResult<BasePage<MovieCollectVo>> selectAll(@Valid @RequestBody MovieCollectPageValidator v) {
        Page<MovieCollect> page = new Page(v.getPageNumber(), v.getPageSize());
        Page<MovieCollect> infoPage = this.movieCollectService.page(page);
        BasePage<MovieCollectVo> basePage = new BasePage(infoPage.getTotal(),
                infoPage.getRecords().stream().map(e -> this.movieCollectMapping.po2Vo(e)).collect(Collectors.toList()));
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
    public BaseResult<MovieCollectVo> selectOne(@PathVariable @ApiParam(value = "主键") Serializable id) {
        return BaseResult.success(
                Optional.ofNullable(this.movieCollectService.getById(id))
                        .map(e -> this.movieCollectMapping.po2Vo(e))
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
    public BaseResult insert(@Valid @RequestBody MovieCollectInsertValidator v) {
        MovieCollect movieCollect = this.movieCollectMapping.insert2Po(v);
        this.movieCollectService.save(movieCollect);
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
    public BaseResult update(@Valid @RequestBody MovieCollectUpdateValidator v) {
        this.movieCollectService.updateById(this.movieCollectMapping.update2Po(v));
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
        this.movieCollectService.removeByIds(idList);
        return BaseResult.success();
    }
}
