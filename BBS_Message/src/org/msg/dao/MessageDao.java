package org.msg.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.msg.entity.Message;

import com.sun.mail.handlers.message_rfc822;

public class MessageDao extends BaseDao implements IMessageDao{
	

	@Override
	public List<Message> getMessagesBySendTo(String name) {
		List<Message> list=new ArrayList<Message>();
		
		String sql="select msgid,username,title,msgcontent,state,sendto,msg_create_date from msg  where sendto=? order by msg_create_date desc";
		try {
			this.getConnection();
			pstm=con.prepareStatement(sql);
			pstm.setString(1, name);
			rs=pstm.executeQuery();
			while(rs.next()){
				Message msg=new Message();
				msg.setMsgId(rs.getInt("msgid"));
				msg.setUserName(rs.getString("username"));
				msg.setTitle(rs.getString("title"));
				msg.setMsgContent(rs.getString("msgcontent"));
				msg.setState(rs.getInt("state"));
				msg.setSendTo(rs.getString("sendto"));
				msg.setMsgCreateDate(rs.getDate("msg_create_date"));
				list.add(msg);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}		
		return null;
	}

	@Override
	public int deleteMsg(String msgid) {
		String sql="delete from msg where msgid="+msgid;		
		return this.executeUpdate(sql, null);
	}

	@Override
	public int insertMsg(Message msg) {
		String sql="insert into msg(username,title,msgcontent,state,sendto,msg_create_date)values(?,?,?,0,?,GETDATE())";
		List<Object> list=Arrays.asList(new Object[]{
				msg.getUserName(),
				msg.getTitle(),
				msg.getMsgContent(),
				msg.getSendTo()
		});
		return this.executeUpdate(sql, list);
	}

	@Override
	public Message getMessageById(String msgid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateState(String msgid) {
		// TODO Auto-generated method stub
		return 0;
	}

}







