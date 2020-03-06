package com.zz.boot.scaffold.authmanage.mapper;

import java.util.List;

import com.zz.boot.scaffold.authmanage.entity.SysAnnouncement;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @Description: 系统通告表
 */
public interface SysAnnouncementMapper extends BaseMapper<SysAnnouncement> {

	
	List<SysAnnouncement> querySysCementListByUserId(Page<SysAnnouncement> page, @Param("userId") String userId, @Param("msgCategory") String msgCategory);

}
