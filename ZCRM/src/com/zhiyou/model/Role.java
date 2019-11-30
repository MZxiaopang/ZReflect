package com.zhiyou.model;

import java.util.Date;

public class Role {
	private Integer role_id;// 角色ID
	private String role_name;// 角色名
	private Integer role_permission;// 取值范围1，5，数字越大权限越大 权限等级
	private Integer status;// 默认值：2 正常：2已删除：-2 部门状态
	private String remark;// 操作备注
	private Date create_time;// 添加时间
	private Integer creater;// 添加人
	private Date update_time;// 修改时间
	private Integer updater;// 修改人

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Integer getRole_permission() {
		return role_permission;
	}

	public void setRole_permission(Integer role_permission) {
		this.role_permission = role_permission;
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

	public Role() {
		super();
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + ", role_permission=" + role_permission
				+ ", status=" + status + ", remark=" + remark + ", create_time=" + create_time + ", creater=" + creater
				+ ", update_time=" + update_time + ", updater=" + updater + "]";
	}

	public Role(Integer role_id, String role_name, Integer role_permission, Integer status, String remark,
			Date create_time, Integer creater, Date update_time, Integer updater) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_permission = role_permission;
		this.status = status;
		this.remark = remark;
		this.create_time = create_time;
		this.creater = creater;
		this.update_time = update_time;
		this.updater = updater;
	}

	public Role(String role_name, Integer role_permission, Integer status, String remark, Date create_time,
			Integer creater, Date update_time, Integer updater) {
		super();
		this.role_name = role_name;
		this.role_permission = role_permission;
		this.status = status;
		this.remark = remark;
		this.create_time = create_time;
		this.creater = creater;
		this.update_time = update_time;
		this.updater = updater;
	}

	public Role(Integer role_id, String role_name, String remark, Date create_time, Integer creater, Integer updater,
			Date update_time) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.remark = remark;
		this.create_time = create_time;
		this.creater = creater;
		this.updater = updater;
		this.update_time = update_time;
	}

	public Role(String role_name, String remark, Integer creater, Date create_time) {
		super();
		this.role_name = role_name;
		this.remark = remark;
		this.create_time = create_time;
		this.creater = creater;
	}

}
