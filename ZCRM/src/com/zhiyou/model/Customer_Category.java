package com.zhiyou.model;

import java.util.Date;

public class Customer_Category {
	private Integer customer_category_id;// 客户种类ID
	private String customer_category_name;// 分类名称
	private String customer_category_desc;// 分类描述
	private Integer status;// 状态
	private String remark;// 备注
	private Date create_time;// 添加时间
	private Integer creater;// 添加人
	private Date update_time;// 修改时间
	private Integer updater;// 修改人

	public Integer getCustomer_category_id() {
		return customer_category_id;
	}

	public void setCustomer_category_id(Integer customer_category_id) {
		this.customer_category_id = customer_category_id;
	}

	public String getCustomer_category_name() {
		return customer_category_name;
	}

	public void setCustomer_category_name(String customer_category_name) {
		this.customer_category_name = customer_category_name;
	}

	public String getCustomer_category_desc() {
		return customer_category_desc;
	}

	public void setCustomer_category_desc(String customer_category_desc) {
		this.customer_category_desc = customer_category_desc;
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

	public Customer_Category(Integer customer_category_id, String customer_category_name, String customer_category_desc,
			Integer status, String remark, Date create_time, Integer creater, Date update_time, Integer updater) {
		super();
		this.customer_category_id = customer_category_id;
		this.customer_category_name = customer_category_name;
		this.customer_category_desc = customer_category_desc;
		this.status = status;
		this.remark = remark;
		this.create_time = create_time;
		this.creater = creater;
		this.update_time = update_time;
		this.updater = updater;
	}

	public Customer_Category(String customer_category_name, String customer_category_desc, Integer status,
			String remark, Date create_time, Integer creater, Date update_time, Integer updater) {
		super();
		this.customer_category_name = customer_category_name;
		this.customer_category_desc = customer_category_desc;
		this.status = status;
		this.remark = remark;
		this.create_time = create_time;
		this.creater = creater;
		this.update_time = update_time;
		this.updater = updater;
	}

	public Customer_Category() {
		super();
	}

}
