<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-3-3
  Time: 下午 4:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/>
<html>
<head>
    <title>新用户注册</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min-2.2.3.js"></script>
   <!-- <script src="${pageContext.request.contextPath}/js/jq.js"></script>  -->
    <script type="text/javascript">
        var contextPath = "${contextPath}";
        $(function () {

            //为输入框绑定事件
            $("#userid").blur(function () {
                var userid = $(this).val();
                if (userid == "") {
                    $("#useridinfo").css("display", "none")
                    return;
                }
                //ajax
                $.ajax({
                    url: "${contextPath}/register/ajax",
                    async: true,
                    type: "POST",
                    data: {"userid": userid},
                    success: function (data) {
                        var exist_id = data;
                        var useridinfo = "";
                        if (exist_id == "n") {
                            useridinfo = "用户名已存在~~";
                            $("#useridinfo").css("color", "red");
                            $("#submit").attr("disabled", true);
                        } else {
                            useridinfo = "用户名可以使用";
                            $("#useridinfo").css("color", "green");
                            $("#submit").attr("disabled", false);
                        }
                        $("#useridinfo").css("display", "block")
                        $("#useridinfo").html(useridinfo);
                    },
                    error: function () {
                        alert("请求失败");
                    }
                });
            });
            $("#usermail").blur(function () {
                var mail = $(this).val();
                var geshi = /^\w+@[a-z0]+(\.[a-z]+){1,3}$/;
                if (mail == "") {
                    $("#usermailinfo").css("display", "none")
                    return;
                }
                if (!geshi.test(mail)) {
                    $("#usermailinfo").css("display", "block");
                    $("#submit").attr("disabled", true);
                } else {
                    $("#usermailinfo").css("display", "none");
                    $("#submit").attr("disabled", false);
                }
            })
        });
        function panduan()
        {
            var p1=document.form1.userpd.value;
            var p2=document.form1.userpda.value;
            if(p1!=p2)
            {
                $("#userpdinfo").css("display","block");
                return false;
            }
            else { return true;}
        }
    </script>
</head>
<body class="text-center">
<c:if test="${requestScope.step!=2}">
    <form style="position: absolute; left: 595px; width: 421px; top: 195px;" class="form-signin" action="${pageContext.request.contextPath}/register/step1" onSubmit="return panduan()" name="form1" method="post">
        <h1 class="h3 mb-3 font-weight-normal" >步骤一：输入用户信息</h1>
        <label class="sr-only">用户名</label>
        <input type="text" id="userid" name="userid" class="form-control" placeholder="用户名" required autofocus>
        <p id="useridinfo" style="display: none;" ></p>
        <label class="sr-only"></label>
        <input type="text" id="username" name="username" class="form-control" placeholder="姓名" required autofocus>
        <label class="sr-only">登录密码</label>
        <input type="password" id="userpd" name="userpd" class="form-control" placeholder="密码" required autofocus>
        <label class="sr-only"></label>
        <input type="password" id="userpda" name="userpda" class="form-control" placeholder="再次输入密码" required autofocus>
        <P id="userpdinfo" style="color: red;display: none">密码输入不一致</P>
        <label class="sr-only"></label>
        <input type="text" id="usermail" name="usermail" class="form-control" placeholder="邮箱" required autofocus>
        <p id="usermailinfo" style="display: none;color: red">邮箱格式有误</p>
        <div class="checkbox mb-3">
        </div>
        <button id="submit" class="btn btn-lg btn-primary btn-block" type="submit">下一步</button>
    </form>
</c:if>
<c:if test="${requestScope.step==2}">
    <form style="position: absolute; left: 595px; width: 421px; top: 195px;" class="form-signin" action="${contextPath}/register/step2" name="form2" method="post">
        <h1 class="h3 mb-3 font-weight-normal" >步骤二:输入邮箱验证码</h1>
        <c:if test="${requestScope.msg_register!=null}">
            <p  style="color: red" ><%=request.getAttribute("msg_register")%></p>
        </c:if>
        <label class="sr-only">验证码</label>
        <input type="text" id="yzm" name="yzm" class="form-control" placeholder="验证码" required autofocus>
        <div class="checkbox mb-3">
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">完成注册</button>
    </form>
</c:if>
</body>
</html>
