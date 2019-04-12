<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-3-3
  Time: 下午 4:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>找回密码</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min-2.2.3.js"></script>
    <script type="text/javascript">
        function account()
        {
            var id=document.form1.id.value;
            if(id=="")
            {
                alert("请输入用户名");
                return false;
            }
            else { return true;}
        }
        function yzm()
        {
            var yanzhengma=document.form2.yzm.value;
            if(yanzhengma=="")
            {
                alert("请输入验证码");
                return false;
            }
            else { return true;}
        }
        function jiance()
        {
            var pd=document.form3.pd.value;
            var pda=document.form3.pda.value;
            if(pd!=pda)
            {
                alert("请输入验证码");
                return false;
            }
            if(pd==""||pda=="")
            {
                alert("请输入密码");
                return false;
            }
            else { return true;}
        }
    </script>
</head>
<body class="text-center">
<c:if test="${requestScope.step==null}">
    <form style="position: absolute; left: 595px; width: 421px; top: 195px;" class="form-signin" action="${pageContext.request.contextPath}/findpassowrd/step1" onSubmit="return account()" name="form1" method="post">
        <h1 class="h3 mb-3 font-weight-normal" >步骤一:输入要找回的用户名</h1>
        <!-- 标签判断是否出现 -->
        <!--   https://www.cnblogs.com/wanggd/archive/2013/05/14/3077086.html  传值取值知识点-->
        <c:if test="${requestScope.msg!=null}">
            <p  style="color: red" ><%=request.getAttribute("msg")%></p>
        </c:if>
        <label class="sr-only">用户名</label>
        <input type="text" name="id" class="form-control" placeholder="用户名" required autofocus>
        <div class="checkbox mb-3">
            <label>
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">下一步</button>
    </form>
</c:if>
<c:if test="${requestScope.step==2}">
    <form style="position: absolute; left: 595px; width: 421px; top: 195px;" class="form-signin" action="${pageContext.request.contextPath}/findpassowrd/step2" onSubmit="return yzm()" name="form2" method="post">
        <h1 class="h3 mb-3 font-weight-normal" >步骤二:输入邮箱验证码</h1>
        <c:if test="${requestScope.msg!=null}">
            <p  style="color: red" ><%=request.getAttribute("msg")%></p>
        </c:if>
        <label class="sr-only">验证码</label>
        <input type="text" name="yzm" class="form-control" placeholder="验证码" required autofocus>
        <div class="checkbox mb-3">
            <label>
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">下一步</button>
    </form>
</c:if>
<c:if test="${requestScope.step==3}">
    <form style="position: absolute; left: 595px; width: 421px; top: 195px;" class="form-signin" action="${pageContext.request.contextPath}/findpassowrd/step3" onSubmit="return jiance()" name="form3" method="post">
        <h1 class="h3 mb-3 font-weight-normal" >步骤三:修改新密码</h1>
        <label class="sr-only">新密码</label>
        <input type="password" name="pd" class="form-control" placeholder="新密码" required autofocus>
        <label class="sr-only">重复输入</label>
        <input type="password" name="pda" class="form-control" placeholder="重复输入" required autofocus>
        <div class="checkbox mb-3">
            <label>
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">完成修改</button>
    </form>
</c:if>
</body>
</html>
