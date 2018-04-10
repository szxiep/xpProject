package com.xp.sys.api;

import java.util.List;

import com.xp.sys.entity.SysBanner;

public interface SysBannerMapper {
	
    long countByExample(SysBanner example);

    int deleteByExample(SysBanner example);

    int insert(SysBanner record);

    List<SysBanner> selectByExample(SysBanner example);

    int updateByExample(SysBanner record);
}