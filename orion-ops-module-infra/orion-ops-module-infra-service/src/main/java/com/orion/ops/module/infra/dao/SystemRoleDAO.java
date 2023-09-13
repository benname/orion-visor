package com.orion.ops.module.infra.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.orion.ops.framework.mybatis.core.mapper.IMapper;
import com.orion.ops.module.infra.entity.domain.SystemRoleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * 角色 Mapper 接口
 *
 * @author Jiahang Li
 * @version 1.0.0
 * @since 2023-7-16 22:31
 */
@Mapper
public interface SystemRoleDAO extends IMapper<SystemRoleDO> {

    /**
     * 通过编码查询角色
     *
     * @param codeList codeList
     * @return roles
     */
    default List<SystemRoleDO> selectByCodeList(Collection<String> codeList) {
        LambdaQueryWrapper<SystemRoleDO> wrapper = this.wrapper()
                .in(SystemRoleDO::getCode, codeList);
        return this.selectList(wrapper);
    }

}
