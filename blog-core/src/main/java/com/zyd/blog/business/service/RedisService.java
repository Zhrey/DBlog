package com.zyd.blog.business.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhrey
 * @website http://www.zhrey.cn
 * @date 2018/4/16 16:26
 */
public interface RedisService {
    void set(String key, String value);

    void set(String key, String value, long expire, TimeUnit timeUnit);

    String get(String key);

    boolean expire(String key, long expire);

    void del(String key);

    <T> void setList(String key, List<T> list);

    <T> void setList(String key, List<T> list, long expire, TimeUnit timeUnit);

    <T> List<T> getList(String key, Class<T> clz);
}
