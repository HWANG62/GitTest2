package org.msg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BaseDao {
	private final String DRIVERCLASS="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final String URL="jdbc:sqlserver://localhost:1433;databaseName=BBS_Message";
	private final String USERNAME="sa";
	private final String PASSWORD="sa";
	protected Connection con=null;
	protected PreparedStatement pstm=null;
	protected ResultSet rs=null;
	
	public Connection getConnection(){
		try {
			Class.forName(DRIVERCLASS);
			con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			//Context ctx=new InitialContext();
			//DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/news");
			//con=ds.getConnection();//获取连接		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeAll(){
		try {
			if(rs!=null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(pstm!=null)
				pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(con!=null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int executeUpdate(String sql,List<Object> list){
		try {
			this.getConnection();
			pstm=con.prepareStatement(sql);
			if(list!=null){
				for(int i=0;i<list.size();i++){
					pstm.setObject(i+1, list.get(i));//从1开始给sql的问号赋值
				}
			}
			return pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return 0;
	}
	

}
