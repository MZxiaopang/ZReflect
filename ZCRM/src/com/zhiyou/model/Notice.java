package com.zhiyou.model;

import java.util.Date;

public class Notice {
	private Integer notice_id;// 公告信息ID
	private Integer receive_id;// 接收部门
	private String subject;// 公告主题
	private String text;// 公告内容
	private Date pub_time;// 发布时间
	private Date expire_time;// 过期时间
	private Integer status;// 公告状态 默认值：2正常：2已删除：-2
	private String remark;// 备注
	private Date create_time;// 添加时间
	private Integer creater;// 添加人
	private Date update_time;// 修改时间
	private Integer updater;// 修改人

	public Notice(Integer notice_id, Integer receive_id, String subject, String text, Date pub_time, Date expire_time,
			Integer creater, Date create_time, Integer updater, Date update_time) {
		super();

		this.notice_id = notice_id;
		this.receive_id = receive_id;
		this.subject = subject;
		this.text = text;
		this.pub_time = pub_time;
		this.expire_time = expire_time;
		this.creater = creater;
		this.create_time = create_time;
		this.updater = updater;
		this.update_time = update_time;
	}

	public Notice(Integer receive_id, String subject, String text, Date pub_time, Date expire_time, Integer creater,
			Date create_time) {
		super();
		this.receive_id = receive_id;
		this.subject = subject;
		this.text = text;
		this.pub_time = pub_time;
		this.expire_time = expire_time;
		this.creater = creater;
		this.create_time = create_time;
	}

	public Integer getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(Integer notice_id) {
		this.notice_id = notice_id;
	}

	public Integer getReceive_id() {
		return receive_id;
	}

	public void setReceive_id(Integer receive_id) {
		this.receive_id = receive_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getPub_time() {
		return pub_time;
	}

	public void setPub_time(Date pub_time) {
		this.pub_time = pub_time;
	}

	public Date getExpire_time() {
		return expire_time;
	}

	public void setExpire_time(Date expire_time) {
		this.expire_time = expire_time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Integer getCreater() {
		return creater;
	}

	public void setCreater(Integer creater) {
		this.creater = creater;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Integer getUpdater() {
		return updater;
	}

	public void setUpdater(Integer updater) {
		this.updater = updater;
	}

	public Notice() {
		super();
	}

	@Override
	public String toString() {
		return "Notice [notice_id=" + notice_id + ", receive_id=" + receive_id + ", subject=" + subject + ", text="
				+ text + ", pub_time=" + pub_time + ", expire_time=" + expire_time + ", status=" + status + ", remark="
				+ remark + ", create_time=" + create_time + ", creater=" + creater + ", upDate_time=" + update_time
				+ ", upDater=" + updater + "]";
	}

}
