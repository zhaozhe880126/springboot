package com.zz.boot.scaffold.authmanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.boot.scaffold.authmanage.entity.SysDepartRolePermission;
import com.zz.boot.scaffold.authmanage.mapper.SysDepartRolePermissionMapper;
import com.zz.boot.scaffold.authmanage.service.ISysDepartRolePermissionService;
import com.zz.scaffold.common.util.ConvertUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.*;

/**
 * @Description: 部门角色权限
 */
@Service
public class SysDepartRolePermissionServiceImpl extends ServiceImpl<SysDepartRolePermissionMapper, SysDepartRolePermission> implements ISysDepartRolePermissionService {

    @Override
    public void saveDeptRolePermission(String roleId, String permissionIds, String lastPermissionIds) {
        List<String> add = getDiff(lastPermissionIds,permissionIds);
        if(add!=null && add.size()>0) {
            List<SysDepartRolePermission> list = new ArrayList<SysDepartRolePermission>();
            for (String p : add) {
                if(ConvertUtils.isNotEmpty(p)) {
                    SysDepartRolePermission rolepms = new SysDepartRolePermission(roleId, p);
                    list.add(rolepms);
                }
            }
            this.saveBatch(list);
        }

        List<String> delete = getDiff(permissionIds,lastPermissionIds);
        if(delete!=null && delete.size()>0) {
            for (String permissionId : delete) {
                this.remove(new QueryWrapper<SysDepartRolePermission>().lambda().eq(SysDepartRolePermission::getRoleId, roleId).eq(SysDepartRolePermission::getPermissionId, permissionId));
            }
        }
    }

    /**
     * 从diff中找出main中没有的元素
     * @param main
     * @param diff
     * @return
     */
    private List<String> getDiff(String main, String diff){
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
