package com.zyd.blog.business.vo;

import com.zyd.blog.business.entity.Role;
import com.zyd.blog.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author zhrey
 * @website http://www.zhrey.cn
 * @date 2018/4/16 16:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleConditionVO extends BaseConditionVO {
    private Role role;
}

