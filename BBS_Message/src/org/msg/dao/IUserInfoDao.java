package org.msg.dao;

import java.util.List;

import org.msg.entity.UserInfo;

public interface IUserInfoDao {
	
	List<UserInfo> getUsers(UserInfo user,String opr);
	
	//ע���û�
	int regUserInfo(UserInfo user);
	
}
