package com.zyd.blog.persistence.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;

/**
 * 文章归档
 *
 * @author zhrey
 * @website http://www.zhrey.cn
 * @date 2018/4/16 16:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizArticleArchives {
    @Transient
    Long id;
    @Transient
    private String title;
    @Transient
    private String original;
    @Transient
    private String datetime;
}
