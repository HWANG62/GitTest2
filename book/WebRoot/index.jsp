<%@page import="org.bookmgr.entity.Book"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	List<Book> books=(List)request.getAttribute("books"); /* 要接收books */
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<style type="text/css">
  		td{padding:10px;border-bottom:1px solid #666};
  	</style>
  
  </head>
  
  <body>
    <table width="600" height="178" align="center" cellspacing=0>
    	<tr>
    		<td colspan="5" align="center">图书列表</td> 
    	</tr>
    	<tr>
    		<td>编号</td>
    		<td>书名</td>
    		<td>作者</td>
    		<td>出版日期</td>
    		<td>&nbsp;</td>
    	</tr>
    	<%
    		for(Book book:books){
    		%>
    		<tr>
    			<td><%=book.getId() %></td>
    			<td><%=book.getName() %></td>
    			<td><%=book.getAuthor() %></td>
    			<td><%=book.getPublishDate() %></td>
    			<td><a href="bool?method=details&id=<%=book.getId()%>">查看详情</a></td>
    		</tr>
    		<%
    		}
    	 %>
    </table>
  </body>
</html>
