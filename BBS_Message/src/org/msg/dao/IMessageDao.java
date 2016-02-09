package org.msg.dao;

import java.util.List;

import org.msg.entity.Message;

public interface IMessageDao {
	
	//��ѯ�յ���������Ϣ
	List<Message> getMessagesBySendTo(String name);
	
	int deleteMsg(String msgid);
	
	int insertMsg(Message msg);
	//��ѯ��Ϣ
	Message getMessageById(String msgid);
	
	//�޸���Ϣ״̬
	int updateState(String msgid);
}





