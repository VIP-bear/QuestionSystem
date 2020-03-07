<%@page import="com.domain.Question"%>
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
	int queNum = Integer.parseInt(request.getParameter("quenumber"));
	String testTitle =  request.getParameter("testtitle");
	String dateLine = request.getParameter("dateline");
	session.setAttribute("queNum", queNum);
	session.setAttribute("testTitle", testTitle);
	session.setAttribute("dateLine", dateLine);
%>

<form action="/QuestionSystem/SaveTestServlet" method="post" name="postform">
<c:forEach begin="1" end="<%=queNum%>" var="i">
	题目"${i}":
	<textarea rows="10" cols="100" name="${i}" id="${i}" ></textarea>
	<br/>
	<br/>
</c:forEach>
<input type="submit" value="submit" />
</form>

</body>
</html>