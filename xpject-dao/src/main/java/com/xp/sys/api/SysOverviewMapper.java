package com.xp.sys.api;

import java.util.List;

import com.xp.sys.entity.SysOverview;

public interface SysOverviewMapper {
    long countByExample(SysOverview example);

    int deleteByExample(SysOverview example);

    int insert(SysOverview record);

    List<SysOverview> selectByExample(SysOverview example);

    int updateByExample(SysOverview record);

}