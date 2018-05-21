<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>attraction_manage</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="客户管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/consumer/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="cid" width="50">客户账号</th>
            <th field="name" width="50">用户名</th>
            <th field="phone" width="50">联系方式</th>
            <th field="email" width="50">电子邮箱</th>
            <th field="var" width="50">备注</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newConsumer()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editConsumer()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyConsumer()">删除</a>
</div>
<div id="ConsumerDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#Consumer-buttons">
    <div class="ftitle">客户信息填写</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>用户名</label><div>&nbsp;</div>
            <input type="text" name="name" class="plainText">
        </div>
        <div class="fitem">
            <label>联系方式</label><div>&nbsp;</div>
            <input type="text" name="phone" class="plainText">
        </div>
        <div class="fitem">
            <label>电子邮箱</label><div>&nbsp;</div>
            <input type="text" name="email" class="plainText">
        </div>
        <div class="fitem">
            <label>备注</label><div>&nbsp;</div>
            <textarea name="var" class="textareaComment" placeholder="500字以内"></textarea>
        </div>
    </form>
</div>
<div id="Consumer-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveConsumer()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#ConsumerDialog').dialog('close')">取消</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
