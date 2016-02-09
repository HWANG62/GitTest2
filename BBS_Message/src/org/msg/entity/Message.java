package org.msg.entity;

import java.util.Date;

public class Message {
	private int msgId;
	private String userName;
	private String title;
	private String msgContent;
	private int state;
	private String sendTo;
	private Date msgCreateDate;
	
	
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public Date getMsgCreateDate() {
		return msgCreateDate;
	}
	public void setMsgCreateDate(Date msgCreateDate) {
		this.msgCreateDate = msgCreateDate;
	}
	
	
}
