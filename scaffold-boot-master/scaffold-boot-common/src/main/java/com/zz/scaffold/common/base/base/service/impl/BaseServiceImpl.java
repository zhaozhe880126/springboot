package com.zz.scaffold.common.base.base.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.scaffold.common.base.base.entity.BaseEntity;
import com.zz.scaffold.common.base.base.service.BaseService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: ServiceImpl基类
 */
@Slf4j
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> implements BaseService<T> {

}
