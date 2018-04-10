package com.xp.sys.api;

import java.util.List;

import com.xp.sys.entity.SysNotice;

public interface SysNoticeMapper {
    long countByExample(SysNotice example);

    int deleteByExample(SysNotice example);

    int insert(SysNotice record);

    List<SysNotice> selectByExample(SysNotice example);

    int updateByExample(SysNotice record);

}