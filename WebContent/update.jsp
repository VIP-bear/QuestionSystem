<%@page import="com.domain.Question"%>
<%@page import="java.util.List"%>
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

<form action="/QuestionSystem/UpdateServlet" method="post" name="postform">
<c:forEach items="${questionlist}" var="i">
	<input type="text" name="${i.getQueid()}" value="${i.getQuetitle()}" />
	<br/>
	<c:forEach items="${i.optionList}" var="j">
		<input type="radio" name="${j.questionid}" value="${j.getOptionorder()}" />${j}
	</c:forEach>
	<br/>
</c:forEach>
<input type="submit" value="update"/>
</form>

</body>
</html>