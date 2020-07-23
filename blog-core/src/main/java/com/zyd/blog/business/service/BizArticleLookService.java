package com.zyd.blog.business.service;


import com.zyd.blog.framework.object.AbstractService;
import com.zyd.blog.business.entity.ArticleLook;
import com.zyd.blog.business.vo.ArticleLookConditionVO;
import com.github.pagehelper.PageInfo;

/**
 * 文章浏览记录
 *
 * @author zhrey
 * @website http://www.zhrey.cn
 * @date 2018/4/16 16:26
 */
public interface BizArticleLookService extends AbstractService<ArticleLook, Integer> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<ArticleLook> findPageBreakByCondition(ArticleLookConditionVO vo);
}
