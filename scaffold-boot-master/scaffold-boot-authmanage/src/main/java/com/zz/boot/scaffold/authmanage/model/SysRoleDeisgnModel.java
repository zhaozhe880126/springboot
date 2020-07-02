package com.zz.boot.scaffold.authmanage.model;

import lombok.Data;


@Data
public class SysRoleDeisgnModel {
    /**主键*/
    private String id;
    /**变单设计器code*/
    private String desformCode;
    /**变单设计器名称*/
    private String desformName;
    /**变单设计器图标*/
    private String desformIcon;
    /**流程类型*/
    private String procType;
    /**流程名称*/
    private String procName;
    /**标题表达式*/
    private String titleExp;
}