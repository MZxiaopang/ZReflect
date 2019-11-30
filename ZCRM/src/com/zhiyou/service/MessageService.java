package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Message;
import com.zhiyou.model.User;

public interface MessageService {
	// 增
	void add(Message Message);

	// 删
	void senddelete(Integer id);

	void Re_Bindelete(Integer id);

	void Se_Bindelete(Integer id);

	// 删
	void receivedelete(Integer id);

	// 删
	void ReallyDelete(Integer id);

	// 改
	void update(Message Message);

	// 再次发送
	void AgainSend(Integer id);

	// 根据ID查
	Message selectById(Integer id);

	boolean selectByAllUser(Integer id);

	// 根据内容查
	List<Message> selectByContent(String content);

	// 根据发件人查
	Message selectBySender(Integer sender);

	// 根据接收人查
	Message selectByReceiver(Integer receiver);

	// 根据名字查
	List<Message> selectBySubject(String name);

	// 查询所有用户
	List<Message> selectAll(int number, int page);

	// 查询所有用户信息
	List<Message> selectAll(int number, int page, User user);

	// 根据收件人receive_delete 删除状态查
	List<Message> selectReceive_Delete(User user);

	// 根据发件人send_delete 删除状态查
	List<Message> selectSend_Delete(User user);

	// 根据发件人send_status 发布状态
	List<Message> selectSend_status0(User user);

	// 查找删除邮件send_delete=0
	List<Message> selectsend_delete0(User user);

	// 查找删除邮件receive_delete=0
	List<Message> selectreceive_delete0(User user);

	// 根据发件人send_status 发布状态
	List<Message> selectSend_status2(User user);

	int selectState0Count();

	int selectState2Count();

	// 查数据总数
	int selectCount();

}
