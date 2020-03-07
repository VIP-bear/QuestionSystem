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

<form action="create.jsp">

Test Title:
<input type="text" name="testtitle" />
<br/>

Question Number:
<input type="text" name="quenumber" />
<br/>

Dateline  :
<input type="text" name="dateline" placeholder="xxxx-xx-xx xx:xx:xx" />
<br/>

<input type="submit" value="submit" />

</form>

</body>
</html>