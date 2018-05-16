<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>hotel_kind_manage.jsp</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="特产管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/special/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="voAid" width="50">绑定景点</th>
            <th field="name" width="50">特产名称</th>
            <th field="price" width="50">价格</th>
            <th field="info" width="50">特产信息</th>
            <th field="voImg" width="50">查看图片</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newSpecial()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editSpecial()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroySpecial()">删除</a>
</div>
<div id="SpecialDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#Special-buttons">
    <div class="ftitle">特产信息填写</div>
    <form id="fm" method="post" enctype="multipart/form-data">
        <div class="fitem">
            <label>绑定景点&nbsp;&nbsp;&nbsp;</label><div>&nbsp;</div>
            <input name="aid"
                   class="easyui-combobox"
                   data-options="
                           valueField:'aid',
                           textField:'name',
                           width:300,
                           url:'${pageContext.request.contextPath}/attraction/ddllist'" />
        </div>
        <div class="fitem">
            <label>特产名称</label><div>&nbsp;</div>
            <input type="text" name="name" placeholder="50字以内" class="plainText">
        </div>
        <div class="fitem">
            <label>价格</label><div>&nbsp;</div>
            <input type="text" name="price" class="plainText">
        </div>
        <div class="fitem">
            <label>特产图片</label><div>&nbsp;</div>
            <input type="file" name="img_file" class="plainText">
        </div>
        <div class="fitem">
            <label>特产信息</label><div>&nbsp;</div>
            <textarea name="info" class="textareaComment" placeholder="500字以内"></textarea>
        </div>
    </form>
</div>
<div id="Special-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveSpecial()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#SpecialDialog').dialog('close')">取消</a>
</div>

<div id="showSpecialDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#showSpecialDialog-buttons">
    <img id="att_img"/>
</div>

<div id="showSpecialDialog-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#showSpecialDialog').dialog('close')">好的</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
