package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.MessageDao;
import com.zhiyou.dao.impl.MessageDaoImpl;
import com.zhiyou.model.Message;
import com.zhiyou.model.User;
import com.zhiyou.service.MessageService;

public class MessageServiceImpl implements MessageService {

	MessageDao dao = new MessageDaoImpl();

	@Override
	public void add(Message Message) {
		// TODO Auto-generated method stub
		dao.add(Message);
	}

	@Override
	public void senddelete(Integer id) {
		// TODO Auto-generated method stub
		dao.senddelete(id);
	}

	public void Re_Bindelete(Integer id) {
		dao.Re_Bindelete(id);
	}

	@Override
	public void Se_Bindelete(Integer id) {
		// TODO Auto-generated method stub
		dao.Se_Bindelete(id);
	}

	@Override
	public void receivedelete(Integer id) {
		// TODO Auto-generated method stub
		dao.receivedelete(id);
	}

	@Override
	public void update(Message Message) {
		// TODO Auto-generated method stub
		dao.update(Message);
	}

	@Override
	public Message selectById(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

	@Override
	public List<Message> selectByContent(String content) {
		// TODO Auto-generated method stub
		return dao.selectByContent(content);
	}

	@Override
	public Message selectBySender(Integer sender) {
		// TODO Auto-generated method stub
		return dao.selectBySender(sender);
	}

	@Override
	public Message selectByReceiver(Integer receiver) {
		// TODO Auto-generated method stub
		return dao.selectByReceiver(receiver);
	}

	@Override
	public List<Message> selectBySubject(String name) {
		// TODO Auto-generated method stub
		return dao.selectBySubject(name);
	}

	@Override
	public List<Message> selectAll(int number, int page) {
		// TODO Auto-generated method stub
		return dao.selectAll(number, page);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount();
	}

	@Override
	public List<Message> selectAll(int number, int page, User user) {
		// TODO Auto-generated method stub
//		List<Message> list = new ArrayList<Message>();
//		Message message = new Message();
//		list.add(message);
//		if (dao.selectAll(number, page, user) == null) {
//			return list;
//		}
		return dao.selectAll(number, page, user);
	}

	@Override
	public List<Message> selectReceive_Delete(User user) {
		// TODO Auto-generated method stub
		return dao.selectReceive_Delete(user);
	}

	@Override
	public List<Message> selectSend_Delete(User user) {
		// TODO Auto-generated method stub
		return dao.selectSend_Delete(user);
	}

	@Override
	public List<Message> selectSend_status0(User user) {
		// TODO Auto-generated method stub
		return dao.selectSend_status0(user);
	}

	@Override
	public List<Message> selectSend_status2(User user) {
		// TODO Auto-generated method stub
		return dao.selectSend_status2(user);
	}

	@Override
	public int selectState0Count() {
		// TODO Auto-generated method stub
		return dao.selectState0Count();
	}

	@Override
	public int selectState2Count() {
		// TODO Auto-generated method stub
		return dao.selectState2Count();
	}

	@Override
	public List<Message> selectsend_delete0(User user) {
		// TODO Auto-generated method stub

		return dao.selectsend_delete0(user);

	}

	@Override
	public void ReallyDelete(Integer id) {
		// TODO Auto-generated method stub
		dao.ReallyDelete(id);
	}

	@Override
	public boolean selectByAllUser(Integer id) {
		// TODO Auto-generated method stub
		List<User> list = dao.selectUserAll(id);
		if (list.size() == 0) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public List<Message> selectreceive_delete0(User user) {
		// TODO Auto-generated method stub
		return dao.selectreceive_delete0(user);
	}

	@Override
	public void AgainSend(Integer id) {
		// TODO Auto-generated method stub
		dao.AgainSend(id);
	}

}
