package com.zyd.blog.business.service;


import com.zyd.blog.framework.object.AbstractService;
import com.zyd.blog.business.entity.ArticleLove;
import com.zyd.blog.business.vo.ArticleLoveConditionVO;
import com.github.pagehelper.PageInfo;

/**
 * 文章点赞
 *
 * @author zhrey
 * @website http://www.zhrey.cn
 * @date 2018/4/16 16:26
 */
public interface BizArticleLoveService extends AbstractService<ArticleLove, Integer> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<ArticleLove> findPageBreakByCondition(ArticleLoveConditionVO vo);
}
