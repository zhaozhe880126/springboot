package com.zz.boot.scaffold.authmanage.model;

import com.zz.boot.scaffold.authmanage.entity.SysDepart;
import com.zz.boot.scaffold.authmanage.entity.SysUser;
import lombok.Data;

/**
 * 包含 SysUser 和 SysDepart 的 Model

 */
@Data
public class SysUserSysDepartModel {

    private SysUser sysUser;
    private SysDepart sysDepart;

}
