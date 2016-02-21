<%@page import="org.bookmgr.entity.Book"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	Book book = (Book) request.getAttribute("book"); /* 得到object类型 必须强转 */
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
td {
	padding: 10px;
	border-bottom: 1px solid #666
}
;
</style>
</head>

<body>
	<table width="400" align="center">
		<tr>
			<td><a href="bool?method=list">返回首页：</a>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2">图书详情</td>
		</tr>
		<tr>
			<td>书名：</td>
			<td><%=book.getName()%></td>
		</tr>
		<tr>
			<td>作者：</td>
			<td><%=book.getAuthor()%></td>
		</tr>
		<tr>
			<td>价格：</td>
			<td><%=book.getPrice()%></td>
		</tr>
		<tr>
			<td>出版时间：</td>
			<td><%=book.getPublishDate()%></td>
		</tr>
		<tr>
			<td>出版社：</td>
			<td><%=book.getPublisher()%></td>
		</tr>
	</table>
</body>
</html>
