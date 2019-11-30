package com.zhiyou.model;

import java.util.Date;

public class Customer_Link_Record {
	private Integer record_id;// 记录ID
	private Integer customer_id;// 客户ID
	private String link_type;// 联系类型
	private String link_subject;// 联系主题
	private Date link_nexttime;// 下次联系时间
	private Integer status;// 状态
	private String remark;// 备注
	private Date next_time;// 下次关怀时间
	private Date create_time;// 添加时间
	private Integer creater;// 添加人
	private Date update_time;// 修改时间
	private Integer updater;// 修改人

	public Integer getRecord_id() {
		return record_id;
	}

	public void setRecord_id(Integer record_id) {
		this.record_id = record_id;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public String getLink_type() {
		return link_type;
	}

	public void setLink_type(String link_type) {
		this.link_type = link_type;
	}

	public String getLink_subject() {
		return link_subject;
	}

	public void setLink_subject(String link_subject) {
		this.link_subject = link_subject;
	}

	public Date getLink_nexttime() {
		return link_nexttime;
	}

	public void setLink_nexttime(Date link_nexttime) {
		this.link_nexttime = link_nexttime;
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

	public Date getNext_time() {
		return next_time;
	}

	public void setNext_time(Date next_time) {
		this.next_time = next_time;
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

	public Customer_Link_Record(Integer customer_id, String link_type, String link_subject, Date link_nexttime,
			Integer status, String remark, Date next_time, Date create_time, Integer creater, Date update_time,
			Integer updater) {
		super();
		this.customer_id = customer_id;
		this.link_type = link_type;
		this.link_subject = link_subject;
		this.link_nexttime = link_nexttime;
		this.status = status;
		this.remark = remark;
		this.next_time = next_time;
		this.create_time = create_time;
		this.creater = creater;
		this.update_time = update_time;
		this.updater = updater;
	}

	public Customer_Link_Record(Integer record_id, Integer customer_id, String link_type, String link_subject,
			Date link_nexttime, Integer status, String remark, Date next_time, Date create_time, Integer creater,
			Date update_time, Integer updater) {
		super();
		this.record_id = record_id;
		this.customer_id = customer_id;
		this.link_type = link_type;
		this.link_subject = link_subject;
		this.link_nexttime = link_nexttime;
		this.status = status;
		this.remark = remark;
		this.next_time = next_time;
		this.create_time = create_time;
		this.creater = creater;
		this.update_time = update_time;
		this.updater = updater;
	}

	public Customer_Link_Record() {
		super();
	}

}
