package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.MessageDao;
import com.zhiyou.model.Message;
import com.zhiyou.model.User;
import com.zhiyou.util.JDBCUtil;

public class MessageDaoImpl implements MessageDao {

	@Override
	public void add(Message Message) {
		// TODO Auto-generated method stub
		String sql = "insert into message(subject,content,sender,send_delete,send_status,save_time,send_time,send_update_time,receiver,receive_delete,receive_status,receive_update_time) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		JDBCUtil.dbDML(sql, Message.getSubject(), Message.getContent(), Message.getSender(), Message.getSend_delete(),
				Message.getSend_status(), Message.getSave_time(), Message.getSend_time(), Message.getSend_update_time(),
				Message.getReceiver(), Message.getReceive_delete(), Message.getReceive_status(),
				Message.getReceive_update_time());
	}

	@Override
	public void senddelete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "update message set send_delete=0 where message_id=?";
		JDBCUtil.dbDML(sql, id);
	}

	@Override
	public void receivedelete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "update message set receive_delete=0 where message_id=?";
		JDBCUtil.dbDML(sql, id);
	}

	public void Re_Bindelete(Integer id) {
		String sql = "update message set receive_delete=-2 where message_id=?";
		JDBCUtil.dbDML(sql, id);
	}

	@Override
	public void Se_Bindelete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "update message set send_delete=-2 where message_id=?";
		JDBCUtil.dbDML(sql, id);
	}

	@Override
	public void ReallyDelete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from message where message_id=?";
		JDBCUtil.dbDML(sql, id);
	}

	@Override
	public void update(Message Message) {
		// TODO Auto-generated method stub
		String sql = "update message set subject=?,content=?,sender=?,send_delete=?,send_status=?,save_time=?,send_time=?,send_update_time=?,receiver=?,receive_delete=?,receive_status=?,receive_update_time=? where message_id=?";
		JDBCUtil.dbDML(sql, Message.getSubject(), Message.getContent(), Message.getSender(), Message.getSend_delete(),
				Message.getSend_status(), Message.getSave_time(), Message.getSend_time(), Message.getSend_update_time(),
				Message.getReceiver(), Message.getReceive_delete(), Message.getReceive_status(),
				Message.getReceive_update_time(), Message.getMessage_id());
	}

	@Override
	public Message selectById(Integer id) {
		String sql = "select *from message where message_id=?";
		List<Message> list = JDBCUtil.dbDQL(sql, Message.class, id);
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}

	}

	@Override
	public List<Message> selectByContent(String content) {
		String sql = "select *from message where content like '%" + content + "?%'";
		List<Message> list = JDBCUtil.dbDQL(sql, Message.class);
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public Message selectBySender(Integer sender) {

		String sql = "select *from message where sender=?";
		List<Message> list = JDBCUtil.dbDQL(sql, Message.class, sender);
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public Message selectByReceiver(Integer receiver) {
		String sql = "select *from message where receiver=?";
		List<Message> list = JDBCUtil.dbDQL(sql, Message.class, receiver);
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public List<Message> selectBySubject(String subject) {
		String sql = "select *from message where subject like '%" + subject + "%'";
		List<Message> list = JDBCUtil.dbDQL(sql, Message.class);
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public List<Message> selectAll(int number, int page) {
		String sql = "select *from message limit " + number + "," + page;
		List<Message> list = JDBCUtil.dbDQL(sql, Message.class);
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public int selectCount() {
		String sql = "select count(*) from message";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int selectState2Count() {
		String sql = "select count(*) from message where send_status =2";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int selectState0Count() {
		String sql = "select count(*) from message where send_status=0";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Message> selectReceive_Delete(User user) {

		String sql = "select *from message where receiver=" + user.getUser_id() + " and receive_delete=0";

		List<Message> list = JDBCUtil.dbDQL(sql, Message.class);

		return list;

	}

	@Override
	public List<Message> selectAll(int number, int page, User user) {
		String sql = "select *from message " + " where receiver= " + user.getUser_id()
				+ " and send_status=2 and receive_delete=2 limit " + number + "," + page;
		List<Message> list = JDBCUtil.dbDQL(sql, Message.class);
		return list;
	}

	@Override
	public List<Message> selectSend_Delete(User user) {
		String sql = "select *from message where send=? and send_delete=0";

		List<Message> list = JDBCUtil.dbDQL(sql, Message.class, user.getUser_id());
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public List<Message> selectSend_status2(User user) {
		String sql = "select *from message where sender=" + user.getUser_id() + " and send_status=2 and send_delete=2";

		List<Message> list = JDBCUtil.dbDQL(sql, Message.class);

		return list;

	}

	@Override
	public List<Message> selectSend_status0(User user) {
		String sql = "select *from message where sender=" + user.getUser_id() + " and send_status=0 and send_delete=2";

		List<Message> list = JDBCUtil.dbDQL(sql, Message.class);

		return list;

	}

	@Override
	public List<User> selectUserAll(Integer User_id) {
		// TODO Auto-generated method stub
		String sql = "select *from user where user_id=?";
		List<User> list = JDBCUtil.dbDQL(sql, User.class, User_id);
		return list;
	}

	@Override
	public List<Message> selectsend_delete0(User user) {
		String sql = "select *from message where sender=" + user.getUser_id() + " and  send_delete=0";

		List<Message> list = JDBCUtil.dbDQL(sql, Message.class);
		return list;
	}

	@Override
	public List<Message> selectreceive_delete0(User user) {
		String sql = "select *from message where receiver=" + user.getUser_id() + " and receive_delete=0";

		List<Message> list = JDBCUtil.dbDQL(sql, Message.class);
		return list;
	}

	@Override
	public void AgainSend(Integer id) {
		// TODO Auto-generated method stub
		String sql = "update message set  send_status=2,send_delete=2 where message_id=?";
		JDBCUtil.dbDML(sql, id);
	}

}
