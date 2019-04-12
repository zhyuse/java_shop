<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-3-3
  Time: 下午 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<script>

</script>
<head>
    <title>登录</title>
</head>
	<body class="text-center">
		<form style="position: absolute; left: 595px; width: 421px; top: 195px;" class="form-signin" action="${pageContext.request.contextPath}/account/login" onSubmit="return panduan()" name="form1" method="post">
			<h1 class="h3 mb-3 font-weight-normal" >请登录</h1>
            <!-- 标签判断是否出现 -->
			<!--   https://www.cnblogs.com/wanggd/archive/2013/05/14/3077086.html  传值取值知识点-->
			<c:if test="${requestScope.msg_login!=null}">
				<p  style="color: red" ><%=request.getAttribute("msg_login")%></p>
			</c:if>
			<label class="sr-only">用户名</label>
			<input type="text" name="id" class="form-control" placeholder="用户名" required autofocus>
			<label class="sr-only" >密码</label>
			<input type="password" name="password" class="form-control" placeholder="密码" required>
			<div class="checkbox">
				<input  type="checkbox" name="autologin" value="true">自动登录
			</div>
			<div class="checkbox mb-3">
				<a href="${pageContext.request.contextPath}/page/register.jsp">新用户注册</a>
				<a href="${pageContext.request.contextPath}/page/findpassword.jsp">忘记密码</a>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>

	</body>
</html>
