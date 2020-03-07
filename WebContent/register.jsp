<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script language="javascript">
function check1(){
	if(register.uname.value==""){
		window.alert("用户名不能为空");
		return false;
	}

	if(register.pwd1.value==""){
		window.alert("密码不能为空");
		return false;
	}
	
	if(register.pwd2.value==""){
		window.alert("确认密码不能为空");
		return false;
	}
	
	if(register.pwd1.value != register.pwd2.value){
		window.alert("两次密码输入不相同");
		return false;
	}
}
</script>
</head>
<body>
<center style="margin-top:50px">
	<font size=8>注册界面</font>
</center>
<center style="opacity: 0.6;">
<form name="register" style="margin:20px;font-size:6px;background-color:#cfe5fc;width:40%"
			 method="post" action="/QuestionSystem/RegisterServlet">
	<p>
		<input style="margin-top:50px;width=250px;height:30px;font-size:20px;
					  border-radius:5px;box-shadow: 10px 10px 5px #746767;"
			   name="uname" type="text" id="username" placeholder="用户名" />
	</p>
	<br>
	<p>
		<input style="margin-top:-10px;width=250px;height:30px;font-size:20px;
					  border-radius:5px;box-shadow: 10px 10px 5px #746767;"
			   name="pwd" type="password" id="pwd1" placeholder="密码"/>
	</p>
	<br>
	<p>
		<input style="margin-top:-10px;width=250px;height:30px;font-size:20px;
					  border-radius:5px;box-shadow: 10px 10px 5px #746767;"
			   name="pwd2" type="password" id="pwd2" placeholder="确认密码"/>
	</p>
	<br>
	<input style="width:250px;height:35px;background-color:#08bf37;font-size:20px;
				  border-radius:5px;box-shadow: 10px 10px 5px #746767;"
		   type="submit" value="注册" onCLick="return check1();"/>
		   
</form>


</center>
</body>
</html>