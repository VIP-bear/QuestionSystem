<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test List</title>
</head>
<body>


<form action="/QuestionSystem/PostTestServlet" method="get" name="postform">
<table border=1 cellpadding="10" cellspacing="0">
<tr>
	<td>title</td>
	<td>datetime</td>
	<td>deadline</td>
	<td>see test</td>
	<td>see result</td>
</tr>
<c:forEach items="${list}" var="i">
	<tr>
		<td>${i.testtitle}</td>
		<td>${i.datetime}</td>
		<td>${i.deadline}</td>
		<td onclick="location.href='/QuestionSystem/PostQuestionServlet?testId=${i.testid}'"
				style="color:red">see test</td>
		<td onclick="location.href='/QuestionSystem/GetResultServlet?testId=${i.testid}'"
				style="color:red">see result</td>
	</tr>

</c:forEach>
</table>
</form>

</body>
</html>