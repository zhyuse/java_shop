<%@ page import="ssm.Entity.Order_detail" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-4-11
  Time: 上午 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min-2.2.3.js" ></script>
    <title>Title</title>
    <script>
        function update() {

        }
    </script>
</head>
<body style="overflow-x: hidden">
<div style="margin-left: 20px;margin-top: 40px;">
    <div style="display: inline">
        <form action="${pageContext.request.contextPath}/domain/save" onsubmit="javascript:return confirm('确认修改？') ">
            <div style="position: relative; left: 0px; top: 0px; width: auto; height: auto;">
                <input type="text" style="display: none" name="id" value="<%=((List<Order_detail>)session.getAttribute("order_detail")).get(0).getId()%>">
                <ul>
                    <li style="list-style:none">订单号：  <%=((List<Order_detail>)session.getAttribute("order_detail")).get(0).getId()%></li>
                    <li style="list-style:none">用户id：  <%=((List<Order_detail>)session.getAttribute("order_detail")).get(0).getUserid()%></li>
                    <li style="list-style:none">收货人： <input type="text" name="receiver" value="<%=((List<Order_detail>)session.getAttribute("order_detail")).get(0).getReceiver()%>"></li>
                    <li style="list-style:none; ">联系电话： <input type="text" name="phone" value="<%=((List<Order_detail>)session.getAttribute("order_detail")).get(0).getPhone()%>"></li>
                    <li style="list-style:none">收货地址：<input type="text" name="address" value="<%=((List<Order_detail>)session.getAttribute("order_detail")).get(0).getAddress()%>"></li>
                </ul>
                <input  type="submit" value="确认修改" class="btn-info" style="margin-left: 40px">
            </div>
        </form>
        <!--商品详情 -->
        <div  style="position: relative; left: 0px; top:0px; width: 1240px; height: 480px;">
                <div  style="position: relative; left: 20px; top: 0px; width: auto; height: 539px;">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>商品图片</th>
                            <th>商品名称</th>
                            <th>数量</th>
                            <th>单价</th>
                            <th>金额</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${order_detail}" var="order">
                            <tr>
                                <td style="width: 150px;">
                                    <a href="${pageContext.request.contextPath}/product/one?productid=${order.getProductid()}" class="a" style="color: green">
                                        <img style="text-align:center;width: 100px;height: 100px" src="${pageContext.request.contextPath}/${order.getImage()}">
                                    </a>
                                </td>
                                <td>
                                    <label style=" text-align:center;margin-top: 40px"><a href="${pageContext.request.contextPath}/product/one?productid=${order.getProductid()}" class="a" style="color: green;text-decoration: none">${order.getProductname()}</a>
                                    </label>
                                </td>
                                <td>
                                    <label  style="margin-top: 40px" >${order.getNum()}</label>
                                </td>
                                <td>
                                    <label style="margin-top: 40px">${order.getDanjia()}</label>
                                </td>
                                <td>
                                    <label style="margin-top: 40px">${order.getPrice()}</label>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <li style="margin-top:50px; margin-left:820px;list-style:none;">总额：</li>
                    <li style="margin-top:0px; margin-left:820px;list-style:none;">¥<%=session.getAttribute("total")%></li>
                </div>
        </div>
    </div>
</div>
</body>
</html>
