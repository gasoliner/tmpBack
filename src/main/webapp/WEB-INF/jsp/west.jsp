<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<style type="text/css">
    .menu-last{
        margin-bottom: 5px;
    }
</style>
<body>
<div class="easyui-accordion" style="width:auto;height: 350px;border: 0px;">
    <shiro:hasAnyRoles name="1,3">
        <div title="景点相关管理" iconCls="icon-man" style="overflow: auto;padding: 10px;">
            <div class="menu-last">
                <a href="#" class="easyui-linkbutton" onclick="addTab('景点管理','attraction_manage')">景点管理</a>
            </div>
            <div class="menu-last">
                <a href="#" class="easyui-linkbutton" onclick="addTab('地区管理','attraction_region')">地区管理</a>
            </div>
            <div class="menu-last">
                <a href="#" class="easyui-linkbutton" onclick="addTab('路线管理','attraction_route')">路线管理</a>
            </div>
        </div>
    </shiro:hasAnyRoles>
    <shiro:hasAnyRoles name="1,2">
        <div title="酒店相关管理" iconCls="icon-man" style="overflow: auto;padding: 10px;">
            <div class="menu-last">
                <a href="#" class="easyui-linkbutton" onclick="addTab('酒店管理','hotel_manage')">酒店管理</a>
            </div>
            <div class="menu-last">
                <a href="#" class="easyui-linkbutton" onclick="addTab('房型管理','hotel_kind_manage')">房型管理</a>
            </div>
        </div>
    </shiro:hasAnyRoles>
    <shiro:hasAnyRoles name="1,3">
        <div title="特产相关管理" iconCls="icon-man" style="overflow: auto;padding: 10px;">
            <div class="menu-last">
                <a href="#" class="easyui-linkbutton" onclick="addTab('特产管理','special_manage')">特产管理</a>
            </div>
        </div>
    </shiro:hasAnyRoles>
    <shiro:hasRole name="1">
        <div title="订单相关管理" iconCls="icon-man" style="overflow: auto;padding: 10px;">
            <div class="menu-last">
                <a href="#" class="easyui-linkbutton" onclick="addTab('订单管理','order_manage')">订单管理</a>
            </div>
            <div class="menu-last">
                <a href="#" class="easyui-linkbutton" onclick="addTab('未确认订单','order_not_manage')">未确认订单管理</a>
            </div>
        </div>
        <div title="人员管理" iconCls="icon-man" style="overflow: auto;padding: 10px;">
            <div class="menu-last">
                <a href="#" class="easyui-linkbutton" onclick="addTab('客户管理','consumer_manage')">客户管理</a>
            </div>
            <div class="menu-last">
                <a href="#" class="easyui-linkbutton" onclick="addTab('后台用户管理','admin_manage')">后台用户管理</a>
            </div>
        </div>
    </shiro:hasRole>
    <div title="个人信息管理" iconCls="icon-mini-edit" selected="true" style="padding:10px;">
        <%--<div class="menu-last">--%>
            <%--<a href="#" class="easyui-linkbutton" onclick="addTab('个人信息','personalManageUI/personalInfo')">个人信息</a>--%>
        <%--</div>--%>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('密码修改','personalPass')">密码修改</a>
        </div>
    </div>
</div>
</body>
