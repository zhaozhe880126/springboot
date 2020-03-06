package com.zz.boot.scaffold.authmanage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zz.boot.scaffold.authmanage.entity.SysAnnouncementSend;
import com.zz.boot.scaffold.authmanage.mapper.SysAnnouncementSendMapper;
import com.zz.boot.scaffold.authmanage.model.AnnouncementSendModel;
import com.zz.boot.scaffold.authmanage.service.ISysAnnouncementSendService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 用户通告阅读标记表
 */
@Service
public class SysAnnouncementSendServiceImpl extends ServiceImpl<SysAnnouncementSendMapper, SysAnnouncementSend> implements ISysAnnouncementSendService {

	@Resource
	private SysAnnouncementSendMapper sysAnnouncementSendMapper;
	
	@Override
	public List<String> queryByUserId(String userId) {
		return sysAnnouncementSendMapper.queryByUserId(userId);
	}

	@Override
	public Page<AnnouncementSendModel> getMyAnnouncementSendPage(Page<AnnouncementSendModel> page,
																 AnnouncementSendModel announcementSendModel) {
		 return page.setRecords(sysAnnouncementSendMapper.getMyAnnouncementSendList(page, announcementSendModel));
	}

}
