<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UFT-8">
<title>Insert title here</title>
</head>
<body>

<%
	String userName = (String)session.getAttribute("userName");
	String testId = (String)session.getAttribute("testIdForAsw");
%>

<h3>USER:<%=userName %></h3>
<h3>TESTID:<%=testId %></h3>		

<table border=1 cellpadding="10" cellspacing="0">
<c:forEach items="${resultlist}" var="answer" varStatus="i">
	<tr>
		<td>${i.count}</td>
		<td>${answer.answerContent}</td>
	</tr>
</c:forEach>
</table>

</body>
</html>