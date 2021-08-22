package com.vv.tool.film.assistant.crawler.module.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 电影集(MovieCollect)表实体类
 *
 * @author vv
 * @since 2021-08-22 21:40:37
 */
@SuppressWarnings("serial")
@Data
public class MovieCollect extends Model<MovieCollect> {
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
     * 电影名称
     */
    private String movieName;
    /**
     * 评分
     */
    private Double movieScore;
    /**
     * 豆瓣id
     */
    private String doubanId;
    /**
     * 剧照
     */
    private String movieStagePhoto;

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
