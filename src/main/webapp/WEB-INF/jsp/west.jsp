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
    <div title="人员管理" iconCls="icon-man" style="overflow: auto;padding: 10px;">
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('用户列表','userManageUI/userList')">用户列表</a>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('用户添加','userManageUI/userAdd')">用户添加</a>
        </div>
    </div>
    <div title="系统管理" iconCls="icon-cog" style="overflow: auto;padding: 10px;">
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('流程管理','system/processManage')">流程管理</a><br/>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('字典管理','system/dictionaryManage')">字典管理</a><br/>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('角色管理','system/roleManage')">角色管理</a><br/>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('通知管理','system/noticeManage')">通知管理</a><br/>
        </div>
    </div>
    <div title="个人信息管理" iconCls="icon-mini-edit" selected="true" style="padding:10px;">
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('个人信息','personalManageUI/personalInfo')">个人信息</a>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('密码修改','')">密码修改</a>
        </div>
    </div>
</div>
</body>
