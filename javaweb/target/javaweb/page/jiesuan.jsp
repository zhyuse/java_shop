<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min-2.2.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <meta charset="utf-8">
    <title>结算页面</title>
<script  language="javascript" type="text/javascript">
        var mark=location.search;
        var adrs=document.getElementsByName("address");
		function pdaddress(){
            for(var i=0;i<adrs.length;i++)
            {
                if(adrs[i].checked==true)
                    break;
                if(i==adrs.length-1)
                {
                    alert("请选择收货地址");
                    return false;
                }
            }
            return true;
		}
	</script>
     <style type="text/css">
	a:hover { color:orangered; }
	</style>
<body>
<!--  地址设置  !-->
<form  action="${pageContext.request.contextPath}/order_detail/submit">
<div style="margin-top: 0px">
    <input type="text" name="status" value="1" style="display: none">
    <input type="text" name="change" value="y" style="display: none">
    <div style="position: absolute; left: 0px; top: 10px; width: 960px; height: auto">
        <p style="margin-left: 20px;margin-top: 10px;color: red">选择收货地址</p>
        <form role="form">
            <div class="form-group" style="margin-left: 150px;margin-top: -30px">
                <select class="form-control" name="address" style="width: auto">
                    <c:forEach items="${list_address}" var="address">
                        <option value="${address.getAddress()}">${address.getAddress()}</option><br>
                    </c:forEach>
                </select>
            </div>
        </form>
        <br>
    </ul>
    </div>
<!-- 货物详情 !-->
   <div  style="position: relative; left: 20px; top: 70px; width: 1046px; height: 539px;">
   <table class="table">
   <thead>
       <tr>
            <td class="text-center">商品图片</td>
            <td class="text-center">商品名称</td>
            <td class="text-center">数量</td>
            <td class="text-center">单价</td>
            <td class="text-center">金额</td>
       </tr>
   </thead>
   <tbody>
       <c:forEach items="${list_cart}" var="cart">
            <tr>  
                 <td class="text-center" style="vertical-align: middle"><a href="${pageContext.request.contextPath}/product/one?productid=${cart.getProductid()}" class="a" style="color: green">
                      <img style="text-align:center;width: 100px;height: 100px" src="${pageContext.request.contextPath}/${cart.getImage()}">
                  </a></td>
                  <td class="text-center" style="vertical-align: middle"> <a href="${pageContext.request.contextPath}/product/one?productid=${cart.getProductid()}" class="a" style="color: green;text-decoration: none">
                      ${cart.getProductname()}
                  </a></td>
                  <td class="text-center" style="vertical-align: middle">${cart.getNum()}</td>
                  <td class="text-center" style="vertical-align: middle">${cart.getDanjia()}</td>
                  <td class="text-center" style="vertical-align: middle">${cart.getPrice()}</td>
            </tr>
       </c:forEach>
   </tbody>
   </table>
     <ul>
     
      <li style="margin-top:50px; margin-left:880px;list-style:none;">总额：</li>
      <li style="margin-top:0px; margin-left:880px;list-style:none;">¥<%=session.getAttribute("total")%></li>
      <li style="margin-top:0px; margin-left:880px; list-style:none"><input type="submit" onclick="address()"  class="btn-danger" value="提交订单"></li>
      </ul>
   </div>
</div>
</form>
</body>
</html>