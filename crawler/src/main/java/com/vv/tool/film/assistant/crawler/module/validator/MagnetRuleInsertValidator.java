package com.vv.tool.film.assistant.crawler.module.validator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 磁力规则(MagnetRule)表插入校验实体
 *
 * @author vv
 * @since 2021-08-25 20:28:54
 */
@SuppressWarnings("serial")
@Data
@ApiModel(value = "MagnetRuleInsertValidator", description = "磁力规则插入校验实体")
public class MagnetRuleInsertValidator implements Serializable {
    private static final long serialVersionUID = -95575050518713061L;

    @ApiModelProperty(name = "magnetName", value = "源站名称", allowEmptyValue = true)
    private String magnetName;

    @ApiModelProperty(name = "magnetUrl", value = "源站首页", allowEmptyValue = true)
    private String magnetUrl;

    @ApiModelProperty(name = "magnetIcon", value = "源站图标", allowEmptyValue = true)
    private String magnetIcon;

    //    @Min(value = 0, message = "参数magnetProxy不能小于0")
    @ApiModelProperty(name = "magnetProxy", value = "是否需要代理", allowEmptyValue = true)
    private Integer magnetProxy;

    @ApiModelProperty(name = "pathsPreset", value = "默认排序路径", allowEmptyValue = true)
    private String pathsPreset;

    @ApiModelProperty(name = "pathsTime", value = "时间排序路径", allowEmptyValue = true)
    private String pathsTime;

    @ApiModelProperty(name = "pathsSize", value = "文件大小排序路径	", allowEmptyValue = true)
    private String pathsSize;

    @ApiModelProperty(name = "pathsHot", value = "人气排序路径", allowEmptyValue = true)
    private String pathsHot;

    @ApiModelProperty(name = "xpathGroup", value = "xpath:Item容器", allowEmptyValue = true)
    private String xpathGroup;

    @ApiModelProperty(name = "xpathMagnet", value = "xpath:磁力链接", allowEmptyValue = true)
    private String xpathMagnet;

    @ApiModelProperty(name = "xpathName", value = "xpath:名称", allowEmptyValue = true)
    private String xpathName;

    @ApiModelProperty(name = "xpathSize", value = "xpath:文件大小", allowEmptyValue = true)
    private String xpathSize;

    @ApiModelProperty(name = "xpathDate", value = "xpath:时间", allowEmptyValue = true)
    private String xpathDate;

    @ApiModelProperty(name = "xpathHot", value = "xpath:人气", allowEmptyValue = true)
    private String xpathHot;

    @ApiModelProperty(name = "xpathDetail", value = "xpath:详情", allowEmptyValue = true)
    private String xpathDetail;

}
