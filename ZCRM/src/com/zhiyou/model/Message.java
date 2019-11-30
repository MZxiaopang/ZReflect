package com.zhiyou.model;

import java.util.Date;

public class Message {
	private Integer message_id;// 邮件ID
	private String subject;// 邮件主题
	private String content;// 内容
	private Integer sender;// 发件人
	private Integer send_delete;// 2 正常 0 删除到垃圾箱 -2 彻底删除 发件人删除
	private Integer send_status;// 0草稿，2已发送 发布状态
	private Date save_time;// 保存草稿时间
	private Date send_time;// 发送时间
	private Date send_update_time;// 发送方更新时间
	private Integer receiver;// 接收人
	private Integer receive_delete;// 2 正常 0 删除到垃圾箱 -2 彻底删除 收件人删除
	private Integer receive_status;// 0未读，2已读 收件状态
	private Date receive_update_time;// 收件方更新时间

	public Integer getMessage_id() {
		return message_id;
	}

	public Message() {
		super();
	}

	public void setMessage_id(Integer message_id) {
		this.message_id = message_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getSender() {
		return sender;
	}

	public void setSender(Integer sender) {
		this.sender = sender;
	}

	public Integer getSend_delete() {
		return send_delete;
	}

	public void setSend_delete(Integer send_delete) {
		this.send_delete = send_delete;
	}

	public Integer getSend_status() {
		return send_status;
	}

	public void setSend_status(Integer send_status) {
		this.send_status = send_status;
	}

	public Date getSave_time() {
		return save_time;
	}

	public void setSave_time(Date save_time) {
		this.save_time = save_time;
	}

	public Date getSend_time() {
		return send_time;
	}

	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}

	public Date getSend_update_time() {
		return send_update_time;
	}

	public void setSend_update_time(Date send_update_time) {
		this.send_update_time = send_update_time;
	}

	public Integer getReceiver() {
		return receiver;
	}

	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}

	public Integer getReceive_delete() {
		return receive_delete;
	}

	public void setReceive_delete(Integer receive_delete) {
		this.receive_delete = receive_delete;
	}

	public Integer getReceive_status() {
		return receive_status;
	}

	public void setReceive_status(Integer receive_status) {
		this.receive_status = receive_status;
	}

	public Date getReceive_update_time() {
		return receive_update_time;
	}

	public void setReceive_update_time(Date receive_update_time) {
		this.receive_update_time = receive_update_time;
	}

	public Message(String subject, String content, Integer sender, Integer send_delete, Integer send_status,
			Date save_time, Date send_time, Date send_update_time, Integer receiver, Integer receive_delete,
			Integer receive_status, Date receive_update_time) {
		super();
		this.subject = subject;
		this.content = content;
		this.sender = sender;
		this.send_delete = send_delete;
		this.send_status = send_status;
		this.save_time = save_time;
		this.send_time = send_time;
		this.send_update_time = send_update_time;
		this.receiver = receiver;
		this.receive_delete = receive_delete;
		this.receive_status = receive_status;
		this.receive_update_time = receive_update_time;
	}

	public Message(Integer message_id, String subject, String content, Integer sender, Integer send_delete,
			Integer send_status, Date save_time, Date send_time, Date send_update_time, Integer receiver,
			Integer receive_delete, Integer receive_status, Date receive_update_time) {
		super();
		this.message_id = message_id;
		this.subject = subject;
		this.content = content;
		this.sender = sender;
		this.send_delete = send_delete;
		this.send_status = send_status;
		this.save_time = save_time;
		this.send_time = send_time;
		this.send_update_time = send_update_time;
		this.receiver = receiver;
		this.receive_delete = receive_delete;
		this.receive_status = receive_status;
		this.receive_update_time = receive_update_time;
	}

	public Message(Integer message_id, String subject, String content, Integer sender, Integer send_status,
			Integer receiver, Integer receive_status, Integer receive_delete) {
		super();
		this.message_id = message_id;
		this.subject = subject;
		this.content = content;
		this.sender = sender;
		this.send_status = send_status;
		this.receiver = receiver;
		this.receive_status = receive_status;
		this.receive_delete = receive_delete;
	}

	public Message(String subject, String content, Integer sender, Integer send_status, Integer receiver,
			Integer send_delete, Integer receive_status, Integer receive_delete) {
		super();
		this.subject = subject;
		this.content = content;
		this.sender = sender;
		this.send_status = send_status;
		this.receiver = receiver;
		this.send_delete = send_delete;
		this.receive_status = receive_status;
		this.receive_delete = receive_delete;
	}

	@Override
	public String toString() {
		return "Message [message_id=" + message_id + ", subject=" + subject + ", content=" + content + ", sender="
				+ sender + ", send_delete=" + send_delete + ", send_status=" + send_status + ", save_time=" + save_time
				+ ", send_time=" + send_time + ", send_update_time=" + send_update_time + ", receiver=" + receiver
				+ ", receive_delete=" + receive_delete + ", receive_status=" + receive_status + ", receive_update_time="
				+ receive_update_time + "]";
	}

}
