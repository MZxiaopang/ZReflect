package com.zhiyou.model;

import java.util.Date;

public class Customer_Source {
	private Integer customer_source_id;// 客户来源ID
	private String customer_source_name;// 客户来源
	private String customer_source_desc;// 来源说明
	private Integer status;// 状态
	private String remark;// 备注
	private Date create_time;// 添加时间
	private Integer creater;// 添加人
	private Date update_time;// 修改时间
	private Integer updater;// 修改人

	public Integer getCustomer_source_id() {
		return customer_source_id;
	}

	public void setCustomer_source_id(Integer customer_source_id) {
		this.customer_source_id = customer_source_id;
	}

	public String getCustomer_source_name() {
		return customer_source_name;
	}

	public void setCustomer_source_name(String customer_source_name) {
		this.customer_source_name = customer_source_name;
	}

	public String getCustomer_source_desc() {
		return customer_source_desc;
	}

	public void setCustomer_source_desc(String customer_source_desc) {
		this.customer_source_desc = customer_source_desc;
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

	public Customer_Source(String customer_source_name, String customer_source_desc, Integer status, String remark,
			Date create_time, Integer creater, Date update_time, Integer updater) {
		super();
		this.customer_source_name = customer_source_name;
		this.customer_source_desc = customer_source_desc;
		this.status = status;
		this.remark = remark;
		this.create_time = create_time;
		this.creater = creater;
		this.update_time = update_time;
		this.updater = updater;
	}

	public Customer_Source(Integer customer_source_id, String customer_source_name, String customer_source_desc,
			Integer status, String remark, Date create_time, Integer creater, Date update_time, Integer updater) {
		super();
		this.customer_source_id = customer_source_id;
		this.customer_source_name = customer_source_name;
		this.customer_source_desc = customer_source_desc;
		this.status = status;
		this.remark = remark;
		this.create_time = create_time;
		this.creater = creater;
		this.update_time = update_time;
		this.updater = updater;
	}

	public Customer_Source() {
		super();
	}

}
