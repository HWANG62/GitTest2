<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  <a href="bool?method=list">返回首页：</a>
    <form action="user">
    	<table>
    		<tr>
    			<td>用户名：</td>
    			<td><input type="text" name="uname"/></td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td><input type="password" name="upwd"/></td>
    		</tr>
    		<tr>
    			<td>&nbsp;</td>
    			<td><input type="submit" value="提交"/></td>
    		</tr>
    	
    	</table>
    </form>
  </body>
</html>
