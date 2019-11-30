package com.zhiyou.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class User11 {
	private Integer user_id;// 员工ID
	private Integer department_id;// 部门ID
	private Integer role_id;// 角色ID
	private String username;// 姓名
	private boolean is_male;// 性别
	private String mobile;// 手机
	private Integer age;// 年龄
	private String address;// 地址
	private boolean is_admin;// 是否管理员
	private boolean is_system;// 是否为系统内置（不能删除）
	private String password;// 密码
	private String tel;// 座机
	private String id_num;// 身份证
	private String email;// E_mail
	private String hobby;// 爱好
	private Integer education;// 学历
	private String card_num;// 工资卡号
	private String nation;// 民族
	private Integer marry;// 婚姻状况
	private Integer status;// 用户状态
	private String remark;// 操作备注
	private Date create_time;// 添加时间
	private Integer creater;// 添加人
	private Date update_time;// 修改时间
	private Integer updater;// 修改人
	private Integer qq;

	public User11(Integer user_id, Integer department_id, Integer role_id, String username, boolean is_male,
			String mobile, Integer age, String address, boolean is_admin, boolean is_system, String password,
			String tel, String id_num, String email, String hobby, Integer education, String card_num, String nation,
			Integer marry, Integer status, String remark, Date create_time, Integer creater, Date update_time,
			Integer updater, Integer qq) {
		super();
		this.user_id = user_id;
		this.department_id = department_id;
		this.role_id = role_id;
		this.username = username;
		this.is_male = is_male;
		this.mobile = mobile;
		this.age = age;
		this.address = address;
		this.is_admin = is_admin;
		this.is_system = is_system;
		this.password = password;
		this.tel = tel;
		this.id_num = id_num;
		this.email = email;
		this.hobby = hobby;
		this.education = education;
		this.card_num = card_num;
		this.nation = nation;
		this.marry = marry;
		this.status = status;
		this.remark = remark;
		this.create_time = create_time;
		this.creater = creater;
		this.update_time = update_time;
		this.updater = updater;
		this.qq = qq;
	}

	public User11(Integer department_id, Integer role_id, String username, boolean is_male, String mobile, Integer age,
			String address, boolean is_admin, boolean is_system, String password, String tel, String id_num,
			String email, String hobby, Integer education, String card_num, String nation, Integer marry,
			Integer status, String remark, Date create_time, Integer creater, Date update_time, Integer updater,
			Integer qq) {
		super();
		this.department_id = department_id;
		this.role_id = role_id;
		this.username = username;
		this.is_male = is_male;
		this.mobile = mobile;
		this.age = age;
		this.address = address;
		this.is_admin = is_admin;
		this.is_system = is_system;
		this.password = password;
		this.tel = tel;
		this.id_num = id_num;
		this.email = email;
		this.hobby = hobby;
		this.education = education;
		this.card_num = card_num;
		this.nation = nation;
		this.marry = marry;
		this.status = status;
		this.remark = remark;
		this.create_time = create_time;
		this.creater = creater;
		this.update_time = update_time;
		this.updater = updater;
		this.qq = qq;
	}

}
