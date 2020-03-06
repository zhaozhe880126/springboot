package com.zz.boot.scaffold.authmanage.mapper;

import com.zz.boot.scaffold.authmanage.entity.SysDataLog;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface SysDataLogMapper extends BaseMapper<SysDataLog>{
	/**
	 * 通过表名及数据Id获取最大版本
	 * @param tableName
	 * @param dataId
	 * @return
	 */
	public String queryMaxDataVer(@Param("tableName") String tableName, @Param("dataId") String dataId);
	
}
