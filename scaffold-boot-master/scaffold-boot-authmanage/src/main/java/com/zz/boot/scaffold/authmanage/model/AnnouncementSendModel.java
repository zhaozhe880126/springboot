package com.zz.boot.scaffold.authmanage.model;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * @Description: 用户通告阅读标记表
 */
@Data
@TableName("sys_announcement_send")
public class AnnouncementSendModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**id*/
	@TableId(type = IdType.ID_WORKER_STR)
	private String id;
	/**通告id*/
	private String anntId;
	/**用户id*/
	private String userId;
	/**标题*/
	private String titile;
	/**内容*/
	private String msgContent;
	/**发布人*/
	private String sender;
	/**优先级（L低，M中，H高）*/
	private String priority;
	/**阅读状态*/
	private String readFlag;
	/**发布时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date sendTime;
	/**页数*/
	private Integer pageNo;
	/**大小*/
	private Integer pageSize;
    /**
     * 消息类型1:通知公告2:系统消息
     */
    private String msgCategory;
	/**
	 * 业务id
	 */
	private String busId;
	/**
	 * 打开方式 组件：component 路由：url
	 */
	private String openType;
	/**
	 * 组件/路由 地址
	 */
	private String openPage;
}
