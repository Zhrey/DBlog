package com.zyd.blog.persistence.beans;

import com.zyd.blog.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;
import java.util.List;

/**
 * @author zhrey
 * @website http://www.zhrey.cn
 * @date 2018/4/16 16:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizArticle extends AbstractDO {
    @Transient
    List<BizTags> tags;
    @Transient
    BizType bizType;
    private String title;
    private Long userId;
    private String coverImage;
    private String qrcodePath;
    private String content;
    private Boolean top;
    private Long typeId;
    private Integer status;
    private Boolean recommended;
    private Boolean original;
    private String description;
    private String keywords;
    @Transient
    private Integer lookCount;
    @Transient
    private Integer commentCount;
    @Transient
    private Integer loveCount;
}
