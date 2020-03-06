package com.zz.boot.scaffold.authmanage.service;

import java.util.List;

import com.zz.boot.scaffold.authmanage.entity.SysMessageTemplate;
import com.zz.scaffold.common.base.base.service.BaseService;

/**
 * @Description: 消息模板
 */
public interface ISysMessageTemplateService extends BaseService<SysMessageTemplate> {
    List<SysMessageTemplate> selectByCode(String code);
}
