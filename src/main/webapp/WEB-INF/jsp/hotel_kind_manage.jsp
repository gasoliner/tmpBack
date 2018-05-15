<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>hotel_kind_manage.jsp</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="酒店房型管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/house/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="voHid" width="50">所属酒店</th>
            <th field="name" width="50">房型名称</th>
            <th field="price" width="50">价格</th>
            <th field="bedcount" width="50">床位数</th>
            <th field="star" width="50">星级</th>
            <th field="iswifi" width="50">是否有wifi</th>
            <th field="info" width="50">房型简介</th>
            <th field="voImg" width="50">房间图片</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newHouse()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editHouse()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyHouse()">删除</a>
    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="showAttraction()">查看详细信息</a>--%>
    <%--<label>按年度查询</label>--%>
    <%--<input id="Book_searchInput"--%>
    <%--name="year"--%>
    <%--class="easyui-combobox"--%>
    <%--data-options="--%>
    <%--valueField:'ddlcode',--%>
    <%--textField:'ddlname',--%>
    <%--width:300,--%>
    <%--url:'${pageContext.request.contextPath}/systemddl/list/year'" />--%>
</div>
<div id="HouseDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#House-buttons">
    <div class="ftitle">景区信息填写</div>
    <form id="fm" method="post" enctype="multipart/form-data">
        <div class="fitem">
            <label>所属酒店&nbsp;&nbsp;&nbsp;</label><div>&nbsp;</div>
            <input name="hid"
                   class="easyui-combobox"
                   data-options="
                           valueField:'hid',
                           textField:'name',
                           width:300,
                           url:'${pageContext.request.contextPath}/hotel/ddllist'" />
        </div>
        <div class="fitem">
            <label>房型名称</label><div>&nbsp;</div>
            <input type="text" name="name" placeholder="50字以内" class="plainText">
        </div>
        <div class="fitem">
            <label>价格</label><div>&nbsp;</div>
            <input type="text" name="price" class="plainText">
        </div>
        <div class="fitem">
            <label>床位数</label><div>&nbsp;</div>
            <input type="text" name="bedcount" class="plainText">
        </div>
        <div class="fitem">
            <label>星级</label><div>&nbsp;</div>
            <input type="text" name="star" class="plainText">
        </div>
        <div class="fitem">
            <label>是否有wifi</label><div>&nbsp;</div>
            <input type="text" name="iswifi" class="plainText">
        </div>
        <div class="fitem">
            <label>房间图片</label><div>&nbsp;</div>
            <input type="file" name="img_file" class="plainText">
        </div>
        <div class="fitem">
            <label>房型简介</label><div>&nbsp;</div>
            <textarea name="info" class="textareaComment" placeholder="500字以内"></textarea>
        </div>
    </form>
</div>
<div id="House-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveHouse()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#HouseDialog').dialog('close')">取消</a>
</div>

<div id="showHouseDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#showHouseDialog-buttons">
    <img id="att_img"/>
</div>

<div id="showHouseDialog-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#showHouseDialog').dialog('close')">好的</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
