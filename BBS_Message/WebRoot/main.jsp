<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
  	<style type="text/css">
  		td{ border-bottom:1px dashed #666; padding:10px;}
  	</style>
  </head>  
  <body>
  	<table width="800" align="center">
  		<tr>
  			<td colspan="6" align="right">当前用户：<a href="#">${sessionScope.user.userName }</a> <a href="user?action=send">发短消息</a>  <a href="#">退出</a></td>
  		</tr>
  		<c:if test="${ !empty messages }">
  		<c:forEach  items="${messages }" var="msg">
  		<tr>
  			<td><c:if test="${msg.state==1 }">已读</c:if>
  			<c:if test="${msg.state==0 }">未读</c:if>&nbsp;
  			</td>
  			<td><a href="msg?method=read&msgid=${msg.msgId }">${msg.title }</a></td>
  			<td width="320">${msg.msgContent.substring(0,3) } ......</td>
  			<td><a href="msg?method=delete&msgid=${msg.msgId }"  onclick="return confirm('确定要删除本消息吗？');">删除</a></td>
  			<td><a href="user?action=send&sendto=${msg.userName }&title=${msg.title}">回信</a></td>
  			<td>${msg.msgCreateDate }</td>
  		</tr>
  		</c:forEach>
  		</c:if>
  	</table>    
  </body>
</html>
