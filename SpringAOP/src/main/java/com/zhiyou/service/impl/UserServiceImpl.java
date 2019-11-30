package com.zhiyou.service.impl;

import org.springframework.stereotype.Service;

import com.zhiyou.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	public void ddUser() {
		// TODO Auto-generated method stub
		System.out.println("增加一个员工");
		System.out.println(5 / 0);
	}

	public void deleteUser() {
		// TODO Auto-generated method stub
		System.out.println("删除一个员工");
	}

}
