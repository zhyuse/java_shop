<%@ page import="java.util.List" %>
<%@ page import="ssm.Entity.Ad" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>    <!--c:foreach标签要导入两个包 !-->
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-3-3
  Time: 下午 3:09
  To change this template use File | Settings | File Templates.
--%>
<!--   通过frame来实现定时更新主页商品   !-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min-2.2.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <title>主页</title>
    <style type="text/css">
	a:hover { color:orangered; }
	</style>
</head>
<body >
<!--  head  !-->
<%@include file="head.jsp"%>
<!-- 横幅广告 -->

<!--     left     !-->
<div style="position: absolute; left: 12px; top: 240px; width: 206px; height: 740px; border: 1px"  id="fenlei">
    <div  id="fenlei1" class="list">
      <a href="#"><img src="${pageContext.request.contextPath}/img/sucai/guanggao.jpg" width="171" height="219" style="width:150px; height:200px;margin-left:40px;"></a>
      <ul  >
        <li style="border: 0"><a href="${pageContext.request.contextPath}/product/findByFenlei?fenlei=日用" class="a">日用</a></li>
        <li style="border: 0"><a href="${pageContext.request.contextPath}/product/findByFenlei?fenlei=食用" class="a">食用</a></li>
        <li style="border: 0"><a href="${pageContext.request.contextPath}/product/findByFenlei?fenlei=手机" class="a">手机</a></li>
        <li style="border: 0"><a href="${pageContext.request.contextPath}/product/findByFenlei?fenlei=书" class="a">书</a></li>
      </ul>
    </div>    
</div>
<!--     right      !-->
<div style="position: absolute; left: 1070px; top: 238px; width: 400px; height: 400px;">
    <div id="myCarousel" class="carousel slide">
	<!-- 轮播（Carousel）指标 -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>   
	<!-- 轮播（Carousel）项目 -->
	<div class="carousel-inner">
		<div class="item active">
			<img src="${pageContext.request.contextPath}/img/guanggao/shangcheng/1.jpg" style="text-align:center;width: 400px; height: 300px" alt="First slide">
		</div>
		<div class="item">
			<img src="${pageContext.request.contextPath}/<%=((List<Ad>)session.getAttribute("list_ad")).get(1).getImage()%>" style="text-align:center;width: 400px; height: 300px" alt="Second slide">
		</div>
		<div class="item">
			<img src="${pageContext.request.contextPath}/<%=((List<Ad>)session.getAttribute("list_ad")).get(2).getImage()%>" style="text-align:center;width: 400px; height: 300px" alt="Third slide">
		</div>
	</div>
	<!-- 轮播（Carousel）导航 -->
	<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		<span class="sr-only">Previous</span>
	</a>
	<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		<span class="sr-only">Next</span>
	</a>
    </div>
</div>

<!--     product   !-->
<div class="list" style="position: absolute; height: 502px; width: 802px; left: 236px; top: 238px;">
    <ul >
        <c:forEach var="product" items="${list_product}">
            <li style="text-align:center; width:160px; height:200px" >
                <a href="${pageContext.request.contextPath}/product/one?productid=${product.getId()}" class="a" style="color: green">
                    <img style="text-align:center;width: 100px;height: 100px" src="${pageContext.request.contextPath}/${product.getImage()}">
                </a>
                <p>
                    <a href="${pageContext.request.contextPath}/product/one?productid=${product.getId()}" class="a" style="color: green">${product.getName()}</a>
                </p>
                <p>
                    <font color="#ff0000">商城价：¥${product.getPrice()}</font>
                </p>
            </li>
        </c:forEach>
    </ul>
</div>

</body>
</html>
