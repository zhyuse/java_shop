<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-4-2
  Time: 上午 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <!-- 引入bootstrap样式 -->
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <!-- 引入bootstrap-table样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap-table.min-1.11.1.css" rel="stylesheet">

    <!-- jquery -->
    <script src="${pageContext.request.contextPath}/js/jquery.min-2.2.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

    <!-- bootstrap-table.min.js -->
    <script src="${pageContext.request.contextPath}/js/bootstrap-table.min-1.11.1.js"></script>
    <!-- 引入中文语言包 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.min.js"></script>
    <title>订单</title>
    <script type="text/javascript">
        var test;
        $(function () {
            table()
        });
        function table() {
            //先销毁表格
            $('#mytab').bootstrapTable({
                //表格高度
                //height: getHeight(),
                url: '${pageContext.request.contextPath}/domain/ajax',
                method:'post',
                dataType: "json",
                queryParams: "queryParams",
                toolbar: "#toolbar",
                sidePagination: "true",
                search: true, //显示搜索框
                striped: true, // 是否显示行间隔色
                undefinedText: "空",//当数据为 undefined 时显示的字符
                showToggle: "true",//是否显示 切换试图（table/card）按钮
                showColumns: "true",//是否显示 内容列下拉框
                //search : "true",
                uniqueId: "id",
                pageSize: "8",
                pagination: true, // 是否分页
                pageNumber: 1,//如果设置了分页，首页页码
                pageSize: 5,//如果设置了分页，页面数据条数
                pageList: [5, 10,15],	//如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录
                sortable: true, // 是否启用排序
                data_local: "zh-US",//表格汉化
                //请求服务器数据
                queryParams: function queryParams(params){
                    var param = {
                        pageNumber: params.pageNumber,
                        pageSize: params.pageSize,
                        sortName: params.sortName,
                        sortOrder: params.sortOrder
                    };
                    return param;
                },
                //加载成功时执行
                onLoadSuccess: function(data){
                    if(data!=null||data.length!==0){
                        for(var i=0;i<data.length;i++){
                            switch (data[i].status) {
                                case 1:
                                    data[i].status="待付款";
                                    break;
                                case 2:
                                    data[i].status="待发货";
                                    break;
                                case 3:
                                    data[i].status="待收货";
                                    break;
                                default:
                            }
                        }
                    }
                    $('#mytab').bootstrapTable('load',data)  //重新加载数据
                },
                columns: [
                    {
                        field: 'id',
                        title: '订单编号'
                    },
                    {
                        field: 'time',
                        title: '下单时间'
                    },
                    {
                        field: 'userid',
                        title: '用户id'
                    },
                    {
                        field: 'productname',
                        title: '商品'
                    },
                    {
                        field: 'price',
                        title: '金额'
                    },
                    {
                        field: 'status',
                        title: '状态'
                    },
                    {
                        field: 'id',
                        title: '操作',
                        width: 120,
                        align: 'center',
                        valign: 'middle',
                        formatter: actionFormatter,
                    },
                ]
            });
            //操作栏的格式化
            function actionFormatter(value, row, index) {
                var id = value;
                var result = "";
                result += "<a href='${pageContext.request.contextPath}/domain/oneorder?productid="+id+"' class='btn btn-xs green'  title='查看'><span class='glyphicon glyphicon-search'></span></a>";
                result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"EditViewById('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
                result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"DeleteByIds('" + id + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
                return result;
            }
            //获取table的高度
            function getHeight() {
                return $(window).height() ;
            }
        }
    </script>
</head>
<body style="overflow-x: hidden;overflow-y: hidden">
<div style="width: 1250px;height: 600px;">
    <div  style="position: relative; left: 0px; top:0px; width: 1240px; height: 480px;">
        <c:if test="${requestScope.msg_order!=null}">
            <p style="color: red;margin-top: 100px">${requestScope.msg_order}</p>
        </c:if>
        <c:if test="${requestScope.msg_order==null}">
            <div class="container">
                <div class="row">
                    <div id="toolbar"></div>
                    <table id="mytab" class="table table-hover"></table>
                </div>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>
