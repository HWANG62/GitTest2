<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
    <form method="post" action="user?action=reg">
    	<table width="500" align="center">
    		<tr>
    			<td colspan="2" >注 册 信 息</td>
    		</tr>
    		<tr>
    			<td >用户名：</td>
    			<td><input type="text"  name="uname" /></td>
    		</tr>
    		<tr>
    			<td >密码：</td>
    			<td><input type="password"  name="pwd" /></td>
    		</tr>
    		<tr>
    			<td >确认密码：</td>
    			<td><input type="password"  name="repwd" /></td>
    		</tr>
    		<tr>
    			<td >邮箱：</td>
    			<td><input type="text"  name="email" /></td>
    		</tr>
    		<tr>
    			<td colspan="2" > <input type="submit" value=" 注 册" />
    			<input type="reset" value=" 重 置" />
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2"  align="center"><a href="index.jsp">返回首页</a></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
