package com.zz.boot.scaffold.authmanage.mapper;

import java.util.List;

import com.zz.boot.scaffold.authmanage.entity.SysUserDepart;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import io.lettuce.core.dynamic.annotation.Param;

public interface SysUserDepartMapper extends BaseMapper<SysUserDepart>{
	
	List<SysUserDepart> getUserDepartByUid(@Param("userId") String userId);
}
