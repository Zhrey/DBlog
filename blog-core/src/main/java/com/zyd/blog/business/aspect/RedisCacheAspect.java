package com.zyd.blog.business.aspect;

import com.zyd.blog.business.annotation.RedisCache;
import com.zyd.blog.framework.property.AppProperties;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis业务层数据缓存
 *
 * @author zhrey
 * @website http://www.zhrey.cn
 * @date 2018/4/16 16:26
 */
@Aspect
@Component
public class RedisCacheAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCacheAspect.class);

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private AppProperties propertiesConfig;

    @Pointcut(value = "@annotation(com.zyd.blog.business.annotation.RedisCache)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
        // 获取拦截的方法名
        Signature sig = point.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        if (!currentMethod.isAnnotationPresent(RedisCache.class)) {
            throw new RuntimeException("未指定RedisChache注解！");
        }
        // 获取拦截方法的参数
        String className = point.getTarget().getClass().getName();
        String methodName = currentMethod.getName();
        // 获取操作名称
        RedisCache cache = currentMethod.getAnnotation(RedisCache.class);
        boolean flush = cache.flush();
        StringBuilder key = new StringBuilder();
        //类名 + 方法名
        key.append(className).append(".").append(methodName);
        if (flush) {
            LOGGER.info("{}-清空缓存", key.toString());
            Set<String> keys = redisTemplate.keys(className + "*");
            if (!CollectionUtils.isEmpty(keys)) {
                redisTemplate.delete(keys);
            }
            LOGGER.info("Clear all the cached query result from redis");
            return point.proceed();
        }
        long expire = cache.expire();
        TimeUnit unit = cache.unit();
        Object[] params = point.getArgs();
        if (StringUtils.isEmpty(cache.key())) {
            if (null != params && params.length > 0) {
                for (Object obj : params) {
                    key.append(obj.toString());
                }
            }
        } else {
            key.append(cache.key());
        }
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key.toString());
        if (hasKey) {
            try {
                LOGGER.info("{}从缓存中获取数据", key.toString());
                return redisTemplate.opsForValue().get(key);
            } catch (Exception e) {
                LOGGER.error("从缓存中获取数据失败！", e);
            }
        }
        // 先执行业务
        Object result = point.proceed();
        // 向Redis中添加数据，有效时间是30天
        redisTemplate.opsForValue().set(key.toString(), result, expire, unit);
        LOGGER.info("Put query result to redis");
        LOGGER.info("{}从数据库中获取数据", key.toString());
        return result;
    }
}
