package com.zz.boot.scaffold.authmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.boot.scaffold.authmanage.entity.SysMessageTemplate;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description: 消息模板
 */
public interface SysMessageTemplateMapper extends BaseMapper<SysMessageTemplate> {
    @Select("SELECT * FROM SYS_SMS_TEMPLATE WHERE TEMPLATE_CODE = #{code}")
    List<SysMessageTemplate> selectByCode(String code);
}
