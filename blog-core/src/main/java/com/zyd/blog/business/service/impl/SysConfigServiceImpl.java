package com.zyd.blog.business.service.impl;

import com.zyd.blog.business.consts.DateConst;
import com.zyd.blog.business.entity.Config;
import com.zyd.blog.business.service.SysConfigService;
import com.zyd.blog.persistence.beans.SysConfig;
import com.zyd.blog.persistence.mapper.SysConfigMapper;
import com.zyd.blog.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Map;

/**
 * 系统配置
 *
 * @author zhrey
 * @website http://www.zhrey.cn
 * @date 2018/4/16 16:26
 */
@Service
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private SysConfigMapper sysConfigMapper;

    /**
     * 获取系统配置
     *
     * @return
     */
    @Override
    public Config get() {
        SysConfig config = sysConfigMapper.get();
        return null == config ? null : new Config(config);
    }

    /**
     * 添加系统配置
     *
     * @param config
     * @return
     */
    @Override
    public Config insert(Config config) {
        config.setCreateTime(new Date());
        config.setUpdateTime(new Date());
        sysConfigMapper.insert(config.getSysConfig());
        return config;
    }

    /**
     * 删除系统配置记录
     *
     * @param id
     */
    @Override
    public void remove(Long id) {
        sysConfigMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改系统配置记录
     *
     * @param config
     */
    @Override
    public void update(Config config) {
        config.setUpdateTime(new Date());
        sysConfigMapper.updateByPrimaryKeySelective(config.getSysConfig());
        this.get();// 重置缓存
    }

    /**
     * 获取网站详情
     *
     * @return
     */
    @Override
    public Map<String, Object> getSiteInfo() {
        Map<String, Object> map = sysConfigMapper.getSiteInfo();
        if (!CollectionUtils.isEmpty(map)) {
            Date recordeTime = (Date) map.get("recordeTime");
            if (!StringUtils.isEmpty(recordeTime)) {
                map.put("recordeTime", DateUtil.date2Str(recordeTime, "yyyy年MM月dd日HH点"));
            }
            Date buildSiteDate = DateUtil.str2Date("2016-10-27 00:00:00", DateConst.YYYY_MM_DD_HH_MM_SS_EN);
            // 获取建站天数
            map.put("buildSiteDate", DateUtil.getGapDay(buildSiteDate, new Date()));
        }
        return map;
    }
}
