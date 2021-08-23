package com.vv.tool.film.assistant.crawler.module.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vv.tool.film.assistant.crawler.common.bo.BasePage;
import com.vv.tool.film.assistant.crawler.common.bo.BaseResult;
import com.vv.tool.film.assistant.crawler.common.exception.ApiException;
import com.vv.tool.film.assistant.crawler.module.entity.MovieSource;
import com.vv.tool.film.assistant.crawler.module.mapstruct.MovieSourceMapping;
import com.vv.tool.film.assistant.crawler.module.service.MovieSourceService;
import com.vv.tool.film.assistant.crawler.module.validator.MovieSourceInsertValidator;
import com.vv.tool.film.assistant.crawler.module.validator.MovieSourcePageValidator;
import com.vv.tool.film.assistant.crawler.module.validator.MovieSourceUpdateValidator;
import com.vv.tool.film.assistant.crawler.module.vo.MovieSourceVo;
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
 * 电影资源(MovieSource)表控制层
 *
 * @author vv
 * @since 2021-08-23 23:11:56
 */
@RestController
@RequestMapping("movieSource")
@Api(tags = "电影资源")
@Validated //要验证list需要使用该注解
@Slf4j
public class MovieSourceController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private MovieSourceService movieSourceService;

    /**
     * mapping
     */
    @Resource
    private MovieSourceMapping movieSourceMapping;

    /**
     * 分页查询所有数据
     *
     * @param v 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据", notes = "分页查询所有数据")
    @PostMapping("page")
    public BaseResult<BasePage<MovieSourceVo>> selectAll(@Valid @RequestBody MovieSourcePageValidator v) {
        Page<MovieSource> page = new Page(v.getPageNumber(), v.getPageSize());
        Page<MovieSource> infoPage = this.movieSourceService.page(page);
        BasePage<MovieSourceVo> basePage = new BasePage(infoPage.getTotal(),
                infoPage.getRecords().stream().map(e -> this.movieSourceMapping.po2Vo(e)).collect(Collectors.toList()));
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
    public BaseResult<MovieSourceVo> selectOne(@PathVariable @ApiParam(value = "主键") Serializable id) {
        return BaseResult.success(
                Optional.ofNullable(this.movieSourceService.getById(id))
                        .map(e -> this.movieSourceMapping.po2Vo(e))
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
    public BaseResult insert(@Valid @RequestBody MovieSourceInsertValidator v) {
        MovieSource movieSource = this.movieSourceMapping.insert2Po(v);
        this.movieSourceService.save(movieSource);
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
    public BaseResult update(@Valid @RequestBody MovieSourceUpdateValidator v) {
        this.movieSourceService.updateById(this.movieSourceMapping.update2Po(v));
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
        this.movieSourceService.removeByIds(idList);
        return BaseResult.success();
    }
}
