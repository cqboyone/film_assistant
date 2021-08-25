package com.vv.tool.film.assistant.crawler.module.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 磁力规则(MagnetRule)表展示
 *
 * @author vv
 * @since 2021-08-25 20:28:53
 */
@SuppressWarnings("serial")
@Data
@ApiModel(value = "MagnetRuleVo", description = "展示磁力规则")
public class MagnetRuleVo implements Serializable {
    private static final long serialVersionUID = -25502975372403121L;
    /**
     * 主键
     */
    @ApiModelProperty(name = "id", value = "主键")
    private String id;
    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createdTime", value = "创建时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(name = "updatedTime", value = "更新时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;
    /**
     * 源站名称
     */
    @ApiModelProperty(name = "magnetName", value = "源站名称")
    private String magnetName;
    /**
     * 源站首页
     */
    @ApiModelProperty(name = "magnetUrl", value = "源站首页")
    private String magnetUrl;
    /**
     * 源站图标
     */
    @ApiModelProperty(name = "magnetIcon", value = "源站图标")
    private String magnetIcon;
    /**
     * 是否需要代理
     */
    @ApiModelProperty(name = "magnetProxy", value = "是否需要代理")
    private Integer magnetProxy;
    /**
     * 默认排序路径
     */
    @ApiModelProperty(name = "pathsPreset", value = "默认排序路径")
    private String pathsPreset;
    /**
     * 时间排序路径
     */
    @ApiModelProperty(name = "pathsTime", value = "时间排序路径")
    private String pathsTime;
    /**
     * 文件大小排序路径
     */
    @ApiModelProperty(name = "pathsSize", value = "文件大小排序路径	")
    private String pathsSize;
    /**
     * 人气排序路径
     */
    @ApiModelProperty(name = "pathsHot", value = "人气排序路径")
    private String pathsHot;
    /**
     * xpath:Item容器
     */
    @ApiModelProperty(name = "xpathGroup", value = "xpath:Item容器")
    private String xpathGroup;
    /**
     * xpath:磁力链接
     */
    @ApiModelProperty(name = "xpathMagnet", value = "xpath:磁力链接")
    private String xpathMagnet;
    /**
     * xpath:名称
     */
    @ApiModelProperty(name = "xpathName", value = "xpath:名称")
    private String xpathName;
    /**
     * xpath:文件大小
     */
    @ApiModelProperty(name = "xpathSize", value = "xpath:文件大小")
    private String xpathSize;
    /**
     * xpath:时间
     */
    @ApiModelProperty(name = "xpathDate", value = "xpath:时间")
    private String xpathDate;
    /**
     * xpath:人气
     */
    @ApiModelProperty(name = "xpathHot", value = "xpath:人气")
    private String xpathHot;
    /**
     * xpath:详情
     */
    @ApiModelProperty(name = "xpathDetail", value = "xpath:详情")
    private String xpathDetail;
}
