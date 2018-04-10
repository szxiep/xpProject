package com.xp.sys.api;

import java.util.List;

import com.xp.sys.entity.SysUser;

public interface SysUserMapper {
    long countByExample(SysUser example);

    int deleteByExample(SysUser example);

    int insert(SysUser record);

    List<SysUser> selectByExample(SysUser example);

    int updateByExample(SysUser record);
    
    int disabledUser(Integer userid);
}