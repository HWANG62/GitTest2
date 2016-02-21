package org.bookmgr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class BaseDao {
	private final String DRIVERCLASS="com.microsoft.sqlserver.jdbc.SQLServerDriver";//qudong
	private final String URL="jdbc:sqlserver://localhost:1433;databaseName=NewsManagerSystem";
	private final String USERNAME="sa";
	private final String PASSWORD="sa";
	protected Connection con=null;
	protected PreparedStatement pstm=null;
	protected ResultSet rs=null;
	
	public Connection getConnection(){
		try {
			Class.forName(DRIVERCLASS);
			con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public void closeAll(ResultSet rs,PreparedStatement pstm,Connection con){
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
			if (con!=null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 执行更新操作的方法
	 * @
	 * 
	 */
	public int executeUpdate(String sql,List<Object> list){
		try {
			con=getConnection();
			pstm=con.prepareStatement(sql);
			if(list!=null){
				for (int i = 0; i < list.size(); i++) {
					pstm.setObject(i+1, list.get(i));//依次给sql语句的参数赋值
				}
			}
			return pstm.executeUpdate();//执行sql语句，返回int
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs, pstm, con);
		}
		return -1;
	}
}




