package com.vv.tool.film.assistant.crawler.module.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 磁力规则(MagnetRule)表实体类
 *
 * @author vv
 * @since 2021-08-25 20:28:53
 */
@SuppressWarnings("serial")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MagnetRule extends Model<MagnetRule> {
    /**
     * 主键
     */
    private String id;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;
    /**
     * 源站名称
     */
    private String magnetName;
    /**
     * 源站首页
     */
    private String magnetUrl;
    /**
     * 源站图标
     */
    private String magnetIcon;
    /**
     * 是否需要代理
     */
    private Boolean magnetProxy;
    /**
     * 默认排序路径
     */
    private String pathsPreset;
    /**
     * 时间排序路径
     */
    private String pathsTime;
    /**
     * 文件大小排序路径
     */
    private String pathsSize;
    /**
     * 人气排序路径
     */
    private String pathsHot;
    /**
     * xpath:Item容器
     */
    private String xpathGroup;
    /**
     * xpath:磁力链接
     */
    private String xpathMagnet;
    /**
     * xpath:名称
     */
    private String xpathName;
    /**
     * xpath:文件大小
     */
    private String xpathSize;
    /**
     * xpath:时间
     */
    private String xpathDate;
    /**
     * xpath:人气
     */
    private String xpathHot;
    /**
     * xpath:详情
     */
    private String xpathDetail;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
