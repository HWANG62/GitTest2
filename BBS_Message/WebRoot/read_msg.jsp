<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
    <table width="600" align="center">
  		<tr>
  			<td align="right">当前用户：<a href="#">${sessionScope.user.userName }</a>   <a href="#">退出</a></td>
  		</tr>
  		<tr align="left">
  			<td>  			
  				标题：${msg.title }  来自：${msg.userName }  时间：${msg.msgCreateDate }   	 		
  			</td>
  		</tr>
  		<tr>
  			<td height="100"> ${msg.msgContent }</td>
  		</tr>  		
  	</table>
  </body>
</html>
