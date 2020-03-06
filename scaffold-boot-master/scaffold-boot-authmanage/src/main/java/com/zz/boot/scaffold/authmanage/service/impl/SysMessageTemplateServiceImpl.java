package com.zz.boot.scaffold.authmanage.service.impl;

import com.zz.boot.scaffold.authmanage.entity.SysMessageTemplate;
import com.zz.boot.scaffold.authmanage.mapper.SysMessageTemplateMapper;
import com.zz.boot.scaffold.authmanage.service.ISysMessageTemplateService;
import com.zz.scaffold.common.base.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Description: 消息模板
 */
@Service
public class SysMessageTemplateServiceImpl extends BaseServiceImpl<SysMessageTemplateMapper, SysMessageTemplate> implements ISysMessageTemplateService {

    @Autowired
    private SysMessageTemplateMapper sysMessageTemplateMapper;


    @Override
    public List<SysMessageTemplate> selectByCode(String code) {
        return sysMessageTemplateMapper.selectByCode(code);
    }
}
