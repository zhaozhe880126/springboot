package com.zz.boot.scaffold.authmanage.service;

import com.zz.boot.scaffold.authmanage.entity.SysDataLog;

import com.baomidou.mybatisplus.extension.service.IService;

public interface ISysDataLogService extends IService<SysDataLog> {
	
	/**
	 * 添加数据日志
	 */
	public void addDataLog(String tableName, String dataId, String dataContent);

}
