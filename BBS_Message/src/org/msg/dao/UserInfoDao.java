package org.msg.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.msg.entity.UserInfo;

public class UserInfoDao extends BaseDao implements IUserInfoDao{

	@Override
	public List<UserInfo> getUsers(UserInfo user,String opr) {
		List<UserInfo> list=new ArrayList<UserInfo>();
		
		String userName=user.getUserName();
		String pwd=user.getPassword();
		String sql="select * from msg_userinfo where 1=1 ";
		
		if(opr!=null && opr.equals("except")){
			sql+=(userName!=null)?" and userName!='"+userName+"'" :"";
		}else{
			sql+=(userName!=null)?" and userName='"+userName+"'" :"";
		}
		sql+= (pwd!=null)?" and password='"+pwd+"'":"";
		try {
			this.getConnection();
			pstm=con.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				UserInfo uf=new UserInfo();
				uf.setUserName(rs.getString("username"));
				uf.setPassword(rs.getString("password"));
				uf.setEmail(rs.getString("email"));
				list.add(uf);//
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}		
		return null;
	}

	@Override
	public int regUserInfo(UserInfo user) {
		String sql="insert into msg_userinfo(username,password,email)values(?,?,?)";
		List<Object> list=Arrays.asList(
			new Object[]{user.getUserName(),user.getPassword(),user.getEmail()}//把users里面的属性内容拿出来
			);
		
		return this.executeUpdate(sql, list);//给sql里面的问号赋值
	}

}










