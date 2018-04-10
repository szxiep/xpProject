package com.xp.sys.api;

import com.xp.sys.entity.SysEducationinfo;
import java.util.List;

public interface SysEducationinfoMapper {
	
    long countByExample(SysEducationinfo example);

    int deleteByExample(SysEducationinfo example);

    int insert(SysEducationinfo record);

    List<SysEducationinfo> selectByExample(SysEducationinfo example);

    int updateByExample(SysEducationinfo record);
}