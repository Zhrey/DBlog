package com.zyd.blog.business.dto;

import lombok.Data;

/**
 * 系统通知详情，用于页面传输
 *
 * @author zhrey
 * @website http://www.zhrey.cn
 * @date 2018/4/16 16:26
 */
@Data
public class SysNoticeDTO {
    private String title;
    private String content;
}
