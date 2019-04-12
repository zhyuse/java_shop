<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-4-2
  Time: 下午 4:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min-2.2.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <title>Title</title>
</head>
<body style="overflow-x: hidden">
<div style="width: 1250px;height: 600px;">
    <div  style="position: relative; left: 0px; top:0px; width: 1240px; height: 480px;">
        <c:if test="${requestScope.msg_order!=null}">
            <p style="color: red">${requestScope.msg_order}</p>
        </c:if>
        <c:if test="${requestScope.msg_order==null}">
                <div  style="position: relative; left: 20px; top: 0px; width: auto; height: 539px;">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>订单编号</th>
                            <th>商品</th>
                            <th>金额</th>
                            <th>地址</th>
                            <th>收货人</th>
                            <th>下单时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list_order}" var="order">
                            <tr>
                                <td style="width: 150px;">
                                    <label>${order.getId()}</label>
                                </td>
                                <td>
                                    <label >${order.getProductname()}</label>
                                </td>
                                <td>
                                    <label  style="" >${order.getPrice()}</label>
                                </td>
                                <td>
                                    <label style="">${order.getAddress()}</label>
                                </td>
                                <td>
                                    <label>${order.getReceiver()}</label>
                                </td>
                                <td>
                                    <label>${order.getTime()}</label>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/order_detail/one?id=${order.getId()}"><input type="button"  class="btn-info" style="color: black;" value="详情"></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
        </c:if>
    </div>
</div>
</body>
</html>
