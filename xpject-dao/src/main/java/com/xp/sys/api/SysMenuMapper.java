package com.xp.sys.api;

import java.util.List;

import com.xp.sys.entity.SysMenu;

public interface SysMenuMapper {
    long countByExample(SysMenu example);

    int deleteByExample(SysMenu example);

    int insert(SysMenu record);

    List<SysMenu> selectByExample(SysMenu example);

    int updateByExample(SysMenu record);
}