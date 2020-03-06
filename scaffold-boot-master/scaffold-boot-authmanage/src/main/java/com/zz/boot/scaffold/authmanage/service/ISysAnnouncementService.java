package com.zz.boot.scaffold.authmanage.service;

import com.zz.boot.scaffold.authmanage.entity.SysAnnouncement;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 系统通告表
 */
public interface ISysAnnouncementService extends IService<SysAnnouncement> {

	public void saveAnnouncement(SysAnnouncement sysAnnouncement);

	public boolean upDateAnnouncement(SysAnnouncement sysAnnouncement);

	public void saveSysAnnouncement(String title, String msgContent);

	public Page<SysAnnouncement> querySysCementPageByUserId(Page<SysAnnouncement> page, String userId, String msgCategory);


}
