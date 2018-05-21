<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>attraction_region</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="未确认订单管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/orders/not_list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="oid" width="50">订单编号</th>
            <th field="name" width="50">订单名称</th>
            <th field="time" width="50">订单创建时间</th>
            <th field="state" width="50">订单状态</th>
            <th field="sum" width="50">订单金额(元)</th>
            <th field="var" width="50">订单备注</th>
            <th field="voAction" width="50">操作</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newOrders()">新建</a>--%>
    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editOrders()">编辑</a>--%>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyOrders()">删除</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="showOrders()">查看详细信息</a>
</div>


<div id="showOrdersDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#showOrdersDialog-buttons">
    <h5>订单编号：</h5>
    <div id="oid_content"></div>
    <h5>订单名称：</h5>
    <div id="name_content"></div>
    <h5>订单创建时间：</h5>
    <div id="time_content"></div>
    <h5>订单状态：</h5>
    <div id="state_content"></div>
    <h5>订单金额(元)：</h5>
    <div id="sum_content"></div>
    <h5>订单备注：</h5>
    <div id="var_content"></div>
</div>

<div id="showOrdersDialog-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#showOrdersDialog').dialog('close')">好的</a>
</div>



<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
