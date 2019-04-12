<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-3-8
  Time: 下午 4:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/mycss.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta charset="utf-8">
    <title>我的信息</title>
    <style type="text/css">
	   a:hover { color:orangered; }
	</style>
    <script>
        function getorder() {
            var url = document.location.toString();
            var arrObj = url.split("?");
            var order;
            if (arrObj.length > 1) {
                var arrPara = arrObj[1].split("&");
                var arr;

                for (var i = 0; i < arrPara.length; i++) {
                    arr = arrPara[i].split("=");

                    if (arr != null && arr[0] =="order") {
                        order=arr[1];
                    }
                }
            }
            if (order!="jiesuan"){
                document.getElementsByName("iframe1").src='jiesuan.jsp'
            }
        }
    </script>
</head>
<body style="overflow-x: hidden">
<!--  head  !-->
<%@include file="head.jsp"%>
<div style="display: inline">
    <!--left!-->
    <div style="position: relative; left: 58px; top: 20px; width: 180px; height: 628px; border: 1px;display: inline">
        <ul class="list-group" style="width: 180px">
            <li class="list-group-item"><font style="color: orangered">全部功能</font></li>
            <li class="list-group-item"><a  href="${pageContext.request.contextPath}/cart/list" target="iframe1" style="text-decoration:none;" >我的购物车</a></li>
            <li class="list-group-item"><a  href="#" style="text-decoration:none;" >我的收货地址</a></li>
            <li class="list-group-item"><a  href="${pageContext.request.contextPath}/order_list/pay" target="iframe1" style="text-decoration:none;" >待付款订单</a></li>
            <li class="list-group-item"><a  href="${pageContext.request.contextPath}/order_list/deliver" target="iframe1" style="text-decoration:none;" >待发货订单</a></li>
            <li class="list-group-item"><a  href="${pageContext.request.contextPath}/order_list/all" target="iframe1" style="text-decoration:none;" >全部订单</a></li>
        </ul>
    </div>
    <!--info!-->
        <iframe name="iframe1" src="${pageContext.request.contextPath}/${sessionScope.myinfo_page}"  style="position: relative; left: 250px; top: -250px; width: 1250px;height: 500px;border: 0px"/>
</div>
</body>
</html>
