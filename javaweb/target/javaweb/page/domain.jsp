<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-4-2
  Time: 上午 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min-2.2.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body style="overflow-x: hidden">
<!-- head -->
<div style="width: 100%;height: 100px;background-color: #101010">

</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2" style="margin-top: 50px">
            <ul id="main-nav" class="nav nav-tabs nav-stacked" style="">
                <li class="active">
                    <a href="#">
                        <i class="glyphicon glyphicon-th-large"></i>
                        管理中心
                    </a>
                </li>
                <li>
                    <a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
                        <i class="glyphicon glyphicon-cog"></i>
                        订单管理
                        <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                    </a>
                    <ul id="systemSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">
                        <li><a href="${pageContext.request.contextPath}/domain/allorder_list" target="iframe1"><i class="glyphicon glyphicon-circle-arrow-right"></i>全部订单</a></li>
                        <li><a href="${pageContext.request.contextPath}/domain/order_pay_list" target="iframe1"><i class="glyphicon glyphicon-circle-arrow-right"></i>待付款订单</a></li>
                        <li><a href="${pageContext.request.contextPath}/domain/order_deliver_list" target="iframe1"><i class="glyphicon glyphicon-circle-arrow-right"></i>待发货订单</a></li>
                        <li><a href="${pageContext.request.contextPath}/domain/order_receiver_list" target="iframe1"><i class="glyphicon glyphicon-circle-arrow-right"></i>待收货订单</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="glyphicon glyphicon-comment"></i>
                        售后处理
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="glyphicon glyphicon-user"></i>
                        用户管理
                        <span class="label label-warning pull-right">new5</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="col-md-10">
            <iframe src="${pageContext.request.contextPath}/domain/order_deliver_list" style="width: 1250px;height: 600px;border: 0px" name="iframe1"></iframe>
        </div>
    </div>
</div>
</body>
</html>
