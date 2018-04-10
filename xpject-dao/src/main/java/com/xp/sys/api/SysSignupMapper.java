package com.xp.sys.api;

import java.util.List;

import com.xp.sys.entity.SysSignup;

public interface SysSignupMapper {
    long countByExample(SysSignup example);

    int deleteByExample(SysSignup example);

    int insert(SysSignup record);

    List<SysSignup> selectByExample(SysSignup example);

    int updateByExample(SysSignup record);
}