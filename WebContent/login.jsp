<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UFT-8">
<title>Login Page</title>
<script language="javascript">
function check(){
	if(login.uname.value==""){
		window.alert("用户名不能为空");
		return false;
	}
	
	if(login.pwd.value==""){
		window.alert("密码不能为空");
		return false;
	}	
}
</script>

</head>
<body style="background-size:cover;"
	background="https://cdn.dribbble.com/users/68180/screenshots/1104190/iceberg.jpg">
<center style="margin-top:50px">
	<font size=8>登陆界面</font>
</center>
<center style="opacity: 0.6;">
<form name="login" style="margin:20px;font-size:6px;background-color:#cfe5fc;width:40%"
			 role="form" method="post" action="/QuestionSystem/LoginServlet">
	<p>
		<input style="margin-top:50px;width=250px;height:30px;font-size:20px;
					  border-radius:5px;box-shadow: 10px 10px 5px #746767;"
			   name="uname" type="text" id="username" placeholder="用户名" />
	</p>
	<br>
	<p>
		<input style="margin-top:-10px;width=250px;height:30px;font-size:20px;
					  border-radius:5px;box-shadow: 10px 10px 5px #746767;"
			   name="pwd" type="password" id="password" placeholder="密码"/>
	</p>
	<br>
	<input style="width:150px;height:35px;background-color:#08bf37;font-size:20px;
				  border-radius:5px;box-shadow: 10px 10px 5px #746767;"
		   type="submit" value="登陆" onClick="return check();"/>
	<input style="width:100px;height:35px;font-size:20px;background-color:#F8F8FF;
				  border-radius:5px;box-shadow: 10px 10px 5px #746767;margin-bottom:50px;"
		   type="button" onclick="window.open('register.jsp')" value="注册" />
	<br>
	登陆用户：
	<select style="width:80px;height:25px" name="Type">
			<option value=普通用户>普通用户</option>
			<option value=管理员>管理员</option>
	</select> 
	
	
</form>

</center>
</body>
</html>