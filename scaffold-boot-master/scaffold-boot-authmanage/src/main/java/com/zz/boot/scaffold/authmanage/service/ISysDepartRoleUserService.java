package com.zz.boot.scaffold.authmanage.service;

import com.zz.boot.scaffold.authmanage.entity.SysDepartRoleUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 部门角色人员信息
 */
public interface ISysDepartRoleUserService extends IService<SysDepartRoleUser> {

    void deptRoleUserAdd(String userId, String newRoleId, String oldRoleId);
}
