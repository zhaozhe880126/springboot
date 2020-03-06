package com.zz.boot.scaffold.authmanage.service;

import java.util.List;

import com.zz.boot.scaffold.authmanage.entity.SysAnnouncementSend;
import com.zz.boot.scaffold.authmanage.model.AnnouncementSendModel;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 用户通告阅读标记表
 */
public interface ISysAnnouncementSendService extends IService<SysAnnouncementSend> {

	public List<String> queryByUserId(String userId);
	
	/**
	 * @功能：获取我的消息
	 * @param announcementSendModel
	 * @return
	 */
	public Page<AnnouncementSendModel> getMyAnnouncementSendPage(Page<AnnouncementSendModel> page, AnnouncementSendModel announcementSendModel);

}
