package com.zz.boot.scaffold.authmanage.service;

import java.util.Map;

import com.zz.boot.scaffold.authmanage.entity.SysUserRole;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户角色表 服务类
 * </p>
 */
public interface ISysUserRoleService extends IService<SysUserRole> {
	
	/**
	 * 查询所有的用户角色信息
	 * @return
	 */
	Map<String,String> queryUserRole();
}
