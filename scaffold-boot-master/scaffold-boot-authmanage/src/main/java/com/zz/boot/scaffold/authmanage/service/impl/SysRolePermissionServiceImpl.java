package com.zz.boot.scaffold.authmanage.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zz.boot.scaffold.authmanage.entity.SysRolePermission;
import com.zz.boot.scaffold.authmanage.mapper.SysRolePermissionMapper;
import com.zz.boot.scaffold.authmanage.service.ISysRolePermissionService;
import com.zz.scaffold.common.util.ConvertUtils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限表 服务实现类
 * </p>
 */
@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements ISysRolePermissionService {

	@Override
	public void saveRolePermission(String roleId, String permissionIds) {
		LambdaQueryWrapper<SysRolePermission> query = new QueryWrapper<SysRolePermission>().lambda().eq(SysRolePermission::getRoleId, roleId);
		this.remove(query);
		List<SysRolePermission> list = new ArrayList<SysRolePermission>();
        String[] arr = permissionIds.split(",");
		for (String p : arr) {
			if(ConvertUtils.isNotEmpty(p)) {
				SysRolePermission rolepms = new SysRolePermission(roleId, p);
				list.add(rolepms);
			}
		}
		this.saveBatch(list);
	}

	@Override
	public void saveRolePermission(String roleId, String permissionIds, String lastPermissionIds) {
		List<String> add = getDiff(lastPermissionIds,permissionIds);
		if(add!=null && add.size()>0) {
			List<SysRolePermission> list = new ArrayList<SysRolePermission>();
			for (String p : add) {
				if(ConvertUtils.isNotEmpty(p)) {
					SysRolePermission rolepms = new SysRolePermission(roleId, p);
					list.add(rolepms);
				}
			}
			this.saveBatch(list);
		}
		
		List<String> delete = getDiff(permissionIds,lastPermissionIds);
		if(delete!=null && delete.size()>0) {
			for (String permissionId : delete) {
				this.remove(new QueryWrapper<SysRolePermission>().lambda().eq(SysRolePermission::getRoleId, roleId).eq(SysRolePermission::getPermissionId, permissionId));
			}
		}
	}
	
	/**
	 * 从diff中找出main中没有的元素
	 * @param main
	 * @param diff
	 * @return
	 */
	private List<String> getDiff(String main,String diff){
		if(ConvertUtils.isEmpty(diff)) {
			return null;
		}
		if(ConvertUtils.isEmpty(main)) {
			return Arrays.asList(diff.split(","));
		}
		
		String[] mainArr = main.split(",");
		String[] diffArr = diff.split(",");
		Map<String, Integer> map = new HashMap<>();
		for (String string : mainArr) {
			map.put(string, 1);
		}
		List<String> res = new ArrayList<String>();
		for (String key : diffArr) {
			if(ConvertUtils.isNotEmpty(key) && !map.containsKey(key)) {
				res.add(key);
			}
		}
		return res;
	}

}
