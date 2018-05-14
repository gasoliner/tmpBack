<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>attraction_manage</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="景点管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/attraction/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="name" width="50">景点名称</th>
            <th field="voRid" width="50">所属地区</th>
            <th field="addr" width="50">景点地址</th>
            <th field="opentime" width="50">开放须知</th>
            <th field="price" width="50">门票价格</th>
            <th field="level" width="50">景区等级</th>
            <th field="score" width="50">景区评分</th>
            <th field="info" width="50">景点简介</th>
            <th field="voImg" width="50">景区图片</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newAttraction()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editAttraction()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyAttraction()">删除</a>
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
<div id="AttractionDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#Attraction-buttons">
    <div class="ftitle">景区信息填写</div>
    <form id="fm" method="post" enctype="multipart/form-data">
        <div class="fitem">
            <label>所属地区&nbsp;&nbsp;&nbsp;</label><div>&nbsp;</div>
            <input name="rid"
                   class="easyui-combobox"
                   data-options="
                           valueField:'rid',
                           textField:'name',
                           width:300,
                           url:'${pageContext.request.contextPath}/region/ddllist'" />
        </div>
        <div class="fitem">
            <label>景点名称</label><div>&nbsp;</div>
            <input type="text" name="name" placeholder="50字以内" class="plainText">
        </div>
        <div class="fitem">
            <label>景点地址</label><div>&nbsp;</div>
            <input type="text" name="addr" class="plainText">
        </div>
        <div class="fitem">
            <label>开放须知</label><div>&nbsp;</div>
            <input type="text" name="opentime" class="plainText">
        </div>
        <div class="fitem">
            <label>门票价格</label><div>&nbsp;</div>
            <input type="text" name="price" class="plainText">
        </div>
        <div class="fitem">
            <label>景区等级</label><div>&nbsp;</div>
            <input type="text" name="level" class="plainText">
        </div>
        <div class="fitem">
            <label>景区评分</label><div>&nbsp;</div>
            <input type="text" name="score" class="plainText">
        </div>
        <div class="fitem">
            <label>景点图片</label><div>&nbsp;</div>
            <input type="file" name="img_file" class="plainText">
        </div>
        <div class="fitem">
            <label>景点简介</label><div>&nbsp;</div>
            <textarea name="info" class="textareaComment" placeholder="500字以内"></textarea>
        </div>
    </form>
</div>
<div id="Attraction-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveAttraction()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#AttractionDialog').dialog('close')">取消</a>
</div>

<div id="showAttractionDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#showAttractionDialog-buttons">
    <img id="att_img"/>
</div>

<div id="showAttractionDialog-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#showAttractionDialog').dialog('close')">好的</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
