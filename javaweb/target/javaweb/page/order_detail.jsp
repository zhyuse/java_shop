
<%@ page import="java.util.List" %>
<%@ page import="ssm.Entity.Address" %>
<%@ page import="ssm.Entity.Order_detail" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-4-2
  Time: 下午 4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min-2.2.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <title>Title</title>
</head>
<body style="overflow-x: hidden">
<div style="display: inline">
    <div style="position: relative; left: 20px; top: 0px; width: auto; height: auto;">
        <ul>
            <li style="list-style:none">收货人： <%=((Address)session.getAttribute("address_order")).getReceiver()%></li>
            <li style="list-style:none; ">联系电话： <%=((Address)session.getAttribute("address_order")).getPhone()%></li>
            <li style="list-style:none">收货地址： <%=((Address)session.getAttribute("address_order")).getAddress()%></li>
            <li style="list-style:none">订单号：  <%=((List<Order_detail>)session.getAttribute("order_detail")).get(0).getId()%></li>
        </ul>
    </div>
    <!--  购物车!-->
    <div  style="position: relative; left: 0px; top:0px; width: 1240px; height: 480px;">
        <c:if test="${requestScope.msg_cart!=null}">
            <p style="color: red">${requestScope.msg_cart}</p>
        </c:if>
        <c:if test="${requestScope.msg_cart==null}">
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
                    <c:if test="${sessionScope.order_detail.get(0).getStatus()==1}"><li style="margin-top:0px; margin-left:820px; list-style:none"><a href="cart?jiesuan=all" ><input type="button" class="btn-danger" value="去支付"></a> </li></c:if>
                    <c:if test="${sessionScope.order_detail.get(0).getStatus()==3}"><li style="margin-top:0px; margin-left:820px; list-style:none"><a href="#" ><input type="button" class="btn-danger" value="确认收货"></a> </li></c:if>
                </div>
        </c:if>
    </div>
</div>
</body>
</html>
