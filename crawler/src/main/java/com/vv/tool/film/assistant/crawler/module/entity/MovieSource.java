package com.vv.tool.film.assistant.crawler.module.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 电影资源(MovieSource)表实体类
 *
 * @author vv
 * @since 2021-08-23 23:51:39
 */
@SuppressWarnings("serial")
@Data
public class MovieSource extends Model<MovieSource> {
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
     * 电影id
     */
    private String movieId;
    /**
     * 资源类型
     */
    private String sourceType;
    /**
     * 资源详情
     */
    private String sourceDetail;
    /**
     * 资源大小
     */
    private String sourceSize;
    /**
     * 资源上线时间
     */
    private String sourceTime;

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
