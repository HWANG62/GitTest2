package org.msg.dao;

import java.util.List;

import org.msg.entity.Message;

public interface IMessageDao {
	
	//查询收到的所有消息
	List<Message> getMessagesBySendTo(String name);
	
	int deleteMsg(String msgid);
	
	int insertMsg(Message msg);
	//查询消息
	Message getMessageById(String msgid);
	
	//修改消息状态
	int updateState(String msgid);
}





