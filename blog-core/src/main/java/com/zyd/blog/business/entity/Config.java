package com.zyd.blog.business.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zyd.blog.business.consts.DateConst;
import com.zyd.blog.persistence.beans.SysConfig;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zhrey
 * @website http://www.zhrey.cn
 * @date 2018/4/16 16:26
 */
public class Config {
    private SysConfig sysConfig;

    public Config() {
        this.sysConfig = new SysConfig();
    }

    public Config(SysConfig sysConfig) {
        this.sysConfig = sysConfig;
    }

    @JsonIgnore
    public SysConfig getSysConfig() {
        return this.sysConfig;
    }

    public Long getId() {
        return this.sysConfig.getId();
    }

    public void setId(Long id) {
        this.sysConfig.setId(id);
    }

    public String getHomeDesc() {
        return this.sysConfig.getHomeDesc();
    }

    public void setHomeDesc(String homeDesc) {
        this.sysConfig.setHomeDesc(homeDesc);
    }

    public String getHomeKeywords() {
        return this.sysConfig.getHomeKeywords();
    }

    public void setHomeKeywords(String homeKeywords) {
        this.sysConfig.setHomeKeywords(homeKeywords);
    }

    public String getDomain() {
        return this.sysConfig.getDomain();
    }

    public void setDomain(String domain) {
        this.sysConfig.setDomain(domain);
    }

    public String getSiteUrl() {
        return this.sysConfig.getSiteUrl();
    }

    public void setSiteUrl(String siteUrl) {
        this.sysConfig.setSiteUrl(siteUrl);
    }

    public String getSiteName() {
        return this.sysConfig.getSiteName();
    }

    public void setSiteName(String siteName) {
        this.sysConfig.setSiteName(siteName);
    }

    public String getSiteDesc() {
        return this.sysConfig.getSiteDesc();
    }

    public void setSiteDesc(String siteDesc) {
        this.sysConfig.setSiteDesc(siteDesc);
    }

    public String getSiteFavicon() {
        return this.sysConfig.getSiteFavicon();
    }

    public void setSiteFavicon(String siteFavicon) {
        this.sysConfig.setSiteFavicon(siteFavicon);
    }

    public String getStaticWebSite() {
        return this.sysConfig.getStaticWebSite();
    }

    public void setStaticWebSite(String staticWebSite) {
        this.sysConfig.setStaticWebSite(staticWebSite);
    }

    public String getAuthorName() {
        return this.sysConfig.getAuthorName();
    }

    public void setAuthorName(String authorName) {
        this.sysConfig.setAuthorName(authorName);
    }

    public String getAuthorEmail() {
        return this.sysConfig.getAuthorEmail();
    }

    public void setAuthorEmail(String authorEmail) {
        this.sysConfig.setAuthorEmail(authorEmail);
    }

    public String getWxCode() {
        return this.sysConfig.getWxCode();
    }

    public void setWxCode(String wxCode) {
        this.sysConfig.setWxCode(wxCode);
    }

    public String getQq() {
        return this.sysConfig.getQq();
    }

    public void setQq(String qq) {
        this.sysConfig.setQq(qq);
    }

    public String getWeibo() {
        return this.sysConfig.getWeibo();
    }

    public void setWeibo(String weibo) {
        this.sysConfig.setWeibo(weibo);
    }

    public String getGithub() {
        return this.sysConfig.getGithub();
    }

    public void setGithub(String github) {
        this.sysConfig.setGithub(github);
    }

    public boolean isMaintenance() {
        Boolean value = this.sysConfig.getMaintenance();
        return value != null ? value : false;
    }

    public void setMaintenance(boolean maintenance) {
        this.sysConfig.setMaintenance(maintenance);
    }

    @JsonFormat(timezone = "GMT+8", pattern = DateConst.YYYY_MM_DD_HH_MM_SS_EN)
    public Date getMaintenanceData() {
        return this.sysConfig.getMaintenanceData();
    }

    @DateTimeFormat(pattern = DateConst.YYYY_MM_DD_HH_MM_SS_EN)
    public void setMaintenanceData(Date maintenanceData) {
        this.sysConfig.setMaintenanceData(maintenanceData);
    }

    public boolean isComment() {
        Boolean value = this.sysConfig.getComment();
        return value != null ? value : false;
    }

    public void setComment(boolean comment) {
        this.sysConfig.setComment(comment);
    }

    public Date getCreateTime() {
        return this.sysConfig.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.sysConfig.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return this.sysConfig.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.sysConfig.setUpdateTime(updateTime);
    }

    public String getQiuniuBasePath() {
        return this.sysConfig.getQiuniuBasePath();
    }

    public void setQiuniuBasePath(String qiuniuBasePath) {
        this.sysConfig.setQiuniuBasePath(qiuniuBasePath);
    }

}

