<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
  </head>
  
  <body>
  	<form method="post" action="msg?method=send">
  	<table width="600" align="center">
  		<tr>
  			<td align="right">当前用户：<a href="#">${sessionScope.user.userName }</a>   <a href="#">退出</a></td>
  		</tr>
  		<tr align="left">
  			<td>发送给: <select name="sendto">
  			<c:forEach items="${except }" var="user" >
  				<option value="${user.userName }"  <c:if test="${!empty senduser&& senduser==user.userName }">selected='selected'</c:if> >${user.userName }</option>
  			</c:forEach>
  			</select> 
  				标题：<input type="text"  name="msgtitle"  <c:if test="${!empty title }">value='回复：${title }'</c:if>  />  			
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<textarea rows="10" cols="40" name="msgcontent"></textarea>
  			</td>
  		</tr>
  		<tr>
  			<td><input type="submit"  value=" 发 送 " /></td>
  		</tr> 
  	</table>
  	</form>
  </body>
</html>
