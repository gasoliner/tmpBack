<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>attraction_region</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="地区管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/region/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="rid" width="50">地区编号</th>
            <th field="name" width="50">地区名称</th>
            <th field="var" width="50">备注</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newRegion()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editRegion()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyRegion()">删除</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="showRegion()">查看详细信息</a>
</div>
<div id="RegionDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#Region-buttons">
    <div class="ftitle">地区信息填写</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>地区名</label><div>&nbsp;</div>
            <input type="text" name="name" placeholder="50字以内" class="plainText">
        </div>
        <div class="fitem">
            <label>备注</label><div>&nbsp;</div>
            <textarea name="var" class="textareaComment" placeholder="500字以内"></textarea>
        </div>
    </form>
</div>
<div id="Region-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveRegion()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#RegionDialog').dialog('close')">取消</a>
</div>

<div id="showRegionDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#showRegionDialog-buttons">
    <h5>地区名：</h5>
    <div id="name_content"></div>
    <h5>备注信息：</h5>
    <div id="var_content"></div>
</div>

<div id="showRegionDialog-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#showRegionDialog').dialog('close')">好的</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
