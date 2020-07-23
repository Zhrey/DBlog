package com.zyd.blog.framework.config;

import com.jagregory.shiro.freemarker.ShiroTags;
import com.zyd.blog.business.service.SysConfigService;
import com.zyd.blog.framework.tag.ArticleTagDirective;
import com.zyd.blog.framework.tag.CustomTagDirective;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * freemarker配置类
 * @author zhrey
 * @website http://www.zhrey.cn
 * @date 2018/4/16 16:26
 */
@Configuration
public class FreeMarkerConfig {

    @Autowired
    protected freemarker.template.Configuration configuration;
    @Autowired
    protected CustomTagDirective customTagDirective;
    @Autowired
    protected ArticleTagDirective articleTagDirective;
    @Autowired
    private SysConfigService configService;

    /**
     * 添加自定义标签
     */
    @PostConstruct
    public void setSharedVariable() {
        configuration.setSharedVariable("zhydTag", customTagDirective);
        configuration.setSharedVariable("articleTag", articleTagDirective);
        try {
            configuration.setSharedVariable("config", configService.get());
            //shiro标签
            configuration.setSharedVariable("shiro", new ShiroTags());
        } catch (TemplateModelException e) {
            e.printStackTrace();
        }
    }
}
