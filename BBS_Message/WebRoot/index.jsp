<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
</head>
  
  <body>
  	<form method="post" action="user?action=login">
  		<table width="400" align="center">
  		<tr>
  			<th colspan="2" >用户登录</th>
  		</tr>
  		<tr>
  			<td colspan="2" align="right">
  			<c:if test="${ !empty requestScope.error }">登录失败！</c:if>
  			&nbsp;  		
  			<c:if test="${requestScope.regInfo=='success' }">注册成功！</c:if>	
  			</td>
  		</tr>
  		<tr>
  			<td>用户名：</td>
  			<td><input type="text"  name="uname" /></td>
  		</tr>
  		<tr>
  			<td>密码：</td>
  			<td><input type="password"  name="upwd"/></td>
  		</tr>
  		<tr>
  			<td>&nbsp;</td>
  			<td><input type="submit"  value=" 登录 "/>
  			<a href="register.jsp"> 注 册 </a>
  			</td>
  		</tr>
  		</table>
  	</form>
  </body>
</html>
