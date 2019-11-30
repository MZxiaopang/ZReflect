package com.zhiyou.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer_State {
	@NonNull
	private Integer customer_state_id;// 状态ID
	@NonNull
	private String customer_state_name;// 状态名称
	@NonNull
	private String customer_state_desc;// 状态描述
	@NonNull
	private Integer status;// 状态
	@NonNull
	private String remark;// 备注
	@NonNull
	private Date create_time;// 添加时间
	@NonNull
	private Integer creater;// 添加人
	@NonNull
	private Date update_time;// 修改时间
	@NonNull
	private Integer updater;// 修改人

	public Customer_State(String customer_state_name, String customer_state_desc, Integer status, String remark,
			Date create_time, Integer creater, Date update_time, Integer updater) {
		super();
		this.customer_state_name = customer_state_name;
		this.customer_state_desc = customer_state_desc;
		this.status = status;
		this.remark = remark;
		this.create_time = create_time;
		this.creater = creater;
		this.update_time = update_time;
		this.updater = updater;
	}

}
