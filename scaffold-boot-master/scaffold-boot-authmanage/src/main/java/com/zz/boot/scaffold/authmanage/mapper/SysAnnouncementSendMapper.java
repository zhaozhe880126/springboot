package com.zz.boot.scaffold.authmanage.mapper;

import java.util.List;

import com.zz.boot.scaffold.authmanage.entity.SysAnnouncementSend;
import com.zz.boot.scaffold.authmanage.model.AnnouncementSendModel;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @Description: 用户通告阅读标记表
 */
public interface SysAnnouncementSendMapper extends BaseMapper<SysAnnouncementSend> {

	public List<String> queryByUserId(@Param("userId") String userId);

	/**
	 * @功能：获取我的消息
	 * @param announcementSendModel
	 * @param page
	 * @return
	 */
	public List<AnnouncementSendModel> getMyAnnouncementSendList(Page<AnnouncementSendModel> page, @Param("announcementSendModel") AnnouncementSendModel announcementSendModel);

}
