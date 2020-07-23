package com.zyd.blog.business.service;

import java.util.List;
import java.util.Map;

/**
 * 归档目录
 *
 * @author zhrey
 * @website http://www.zhrey.cn
 * @date 2018/4/16 16:26
 */
public interface BizArticleArchivesService {

    /**
     * 获取归档目录列表
     *
     * @return
     */
    Map<String, List> listArchives();
}
