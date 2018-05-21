<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>attraction_manage</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="后台用户管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/user/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="uid" width="50">用户编号</th>
            <th field="name" width="50">用户名</th>
            <th field="voRole" width="50">用户角色</th>
            <th field="voPassword" width="50">密码操作</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
</div>
<div id="UserDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#User-buttons">
    <div class="ftitle">后台管理用户信息填写</div>
    <form id="fm" method="post" >
        <div class="fitem">
            <label>用户角色&nbsp;&nbsp;&nbsp;</label><div>&nbsp;</div>
            <input name="rid"
                   class="easyui-combobox"
                   data-options="
                           valueField:'rid',
                           textField:'role',
                           width:300,
                           url:'${pageContext.request.contextPath}/role/ddllist'" />
        </div>
        <div class="fitem">
            <label>用户名</label><div>&nbsp;</div>
            <input type="text" name="name" placeholder="50字以内" class="plainText">
        </div>
        <div class="fitem">
            <label>用户密码</label><div>&nbsp;</div>
            <input placeholder="不填则为默认密码" type="password" name="password" class="plainText">
        </div>
    </form>
</div>
<div id="User-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#UserDialog').dialog('close')">取消</a>
</div>


</body>
</html>
