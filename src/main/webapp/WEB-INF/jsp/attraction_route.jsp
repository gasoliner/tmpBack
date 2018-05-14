<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>路线管理</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="路线管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/route/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="rid" width="50">路线编号</th>
            <th field="name" width="50">路线名称</th>
            <th field="voRid" width="50">地区</th>
            <th field="voAids" width="50">路线内容</th>
            <th field="var" width="50">备注</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newRoute()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editRoute()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyRoute()">删除</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="showRoute()">查看详细信息</a>
</div>
<div id="RouteDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#Route-buttons">
    <div class="ftitle">路线信息填写</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>所属地区&nbsp;&nbsp;&nbsp;</label><div>&nbsp;</div>
            <input id="region_Input_Combox" name="rid"
                   class="easyui-combobox"
                   data-options="
                           valueField:'rid',
                           textField:'name',
                           width:300,
                           url:'${pageContext.request.contextPath}/region/ddllist'" />
        </div>
        <div class="fitem">
            <label>路线名称</label><div>&nbsp;</div>
            <input type="text" name="name" placeholder="50字以内" class="plainText">
        </div>
        <div class="fitem">
            <label>景点</label><div>&nbsp;</div>
            <div>请选择以下景点：</div>
            <div id="attraction_option"></div>
            <input type="text" name="aids" readonly="readonly" class="plainText">
        </div>
        <div class="fitem">
            <label>备注</label><div>&nbsp;</div>
            <textarea name="var" class="textareaComment" placeholder="500字以内"></textarea>
        </div>
    </form>
</div>
<div id="Route-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveRoute()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#RouteDialog').dialog('close')">取消</a>
</div>

<%--<div id="showBookDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"--%>
     <%--closed="true" buttons="#showBookDialog-buttons">--%>
    <%--<h5>书名：</h5>--%>
    <%--<div id="bookname_content"></div>--%>
    <%--<h5>作者：</h5>--%>
    <%--<div id="author_content"></div>--%>
    <%--<h5>出版日期：</h5>--%>
    <%--<div id="publishyear_content"></div>--%>
    <%--<h5>页数：</h5>--%>
    <%--<div id="pages_content"></div>--%>
    <%--<h5>价格：</h5>--%>
    <%--<div id="price_content"></div>--%>
    <%--<h5>豆瓣评分：</h5>--%>
    <%--<div id="score_content"></div>--%>
    <%--<h5>内容简介：</h5>--%>
    <%--<div id="content_content"></div>--%>
    <%--<h5>作者简介：</h5>--%>
    <%--<div id="author_info_content"></div>--%>
<%--</div>--%>

<%--<div id="showBookDialog-buttons">--%>
    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#showBookDialog').dialog('close')">好的</a>--%>
<%--</div>--%>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
<script type="text/javascript">
    $(function () {
        $('#region_Input_Combox').combobox({
            onChange: function(){
                $.get("/attraction/attr_option/" + $("#region_Input_Combox").combobox("getValue"),null,function (data) {
                    $("#attraction_option").html(data);
                })
            }
        });
    });
</script>
