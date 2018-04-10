package com.xp.sys.api;

import java.util.List;

import com.xp.sys.entity.SysNews;

public interface SysNewsMapper {
    long countByExample(SysNews example);

    int deleteByExample(SysNews example);

    int insert(SysNews record);

    List<SysNews> selectByExample(SysNews example);

    int updateByExample(SysNews record);
}