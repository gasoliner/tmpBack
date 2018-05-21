<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<div style="text-align: center;font-family: 微软雅黑;font-size: 25px;" >
    <%--<div align="right" style="width: auto;display: inline">旅游管理平台</div>--%>
    TMP_旅游管理平台_后台
    <c:if test="${user != null}">
        <span style="float: left;width: auto">
            TMP欢迎您，${user.name}&nbsp;&nbsp;
            <a class="easyui-linkbutton" iconCls="icon-ok" style="width: auto;height: 32px;" onclick="logout()">退出</a>
        </span>
    </c:if>
</div>
</body>
</html>
