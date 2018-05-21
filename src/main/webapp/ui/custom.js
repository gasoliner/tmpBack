function newUser() {
    $("#fm").form("clear");
    $("#UserDialog").dialog("open").dialog("setTitle","新建");
    url = "/user/addition";
}
function editUser() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#UserDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/user/updates/"+row.uid;
    }
}
function destroyUser() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/user/deletion/"+row.uid,
                    success: function (res) {
                        alert(res);
                        $("#UserDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveUser() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#UserDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function resetUserPassword(id) {
    $.post("/user/resetPassword/" + id,null,function (backresult) {
        alert(backresult);
        $('#dg').datagrid("reload");
    })
}
function subNewUser() {
    $.post("/user/add",{
        number:$("#number").val(),
        username:$("#username").val(),
        sex:$("input[name='sex']:checked").val(),
        classs:$("#classs").val(),
        signature:$("#signature").val(),
        email:$("#email").val(),
        phone:$("#phone").val(),
    },function (backresult) {
        alert(backresult);
    })
}

function perInf1() {
    $.post("/manager/updates/" + $("#mid").val(),
        {
            mid:$("#mid").val(),
            name:$("#name").val(),
            username:$("#username").val(),
            sex:$("input[name='sex']:checked").val(),
            phone:$("#phone").val(),
            email:$("#email").val()
        },
        function (data) {
            alert(data);
        });
}
function perPas1() {
    $.post("/user/password",
        {
            uid:$("#uid").val(),
            oldpassword:$("#oldpass").val(),
            newpassword1:$("#newpass").val(),
            newpassword2:$("#newpass_check").val()
        },
        function (data) {
            alert(data);
        });
}

function showAttractionPic(id) {
    $("#showAttractionDialog").dialog({
        title:"查看",
        width: 550,
        height: 550,
        closed: false,
        cache: false,
        modal: true
    });
    $("#att_img").attr("src","/attraction/img/"+id);

}

function showHousePic(id) {
    $("#showHouseDialog").dialog({
        title:"查看",
        width: 550,
        height: 550,
        closed: false,
        cache: false,
        modal: true
    });
    $("#att_img").attr("src","/house/img/"+id);

}

function showHotelPic(id) {
    $("#showHotelDialog").dialog({
        title:"查看",
        width: 550,
        height: 550,
        closed: false,
        cache: false,
        modal: true
    });
    $("#att_img").attr("src","/hotel/img/"+id);

}

function showSpecialPic(id) {
    $("#showSpecialDialog").dialog({
        title:"查看",
        width: 550,
        height: 550,
        closed: false,
        cache: false,
        modal: true
    });
    $("#att_img").attr("src","/special/img/"+id);

}

function newRegion() {
    $("#fm").form("clear");
    $("#RegionDialog").dialog("open").dialog("setTitle","新建");
    url = "/region/addition";
}
function editRegion() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#RegionDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/region/updates/"+row.rid;
    }
}
function destroyRegion() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/region/deletion/"+row.rid,
                    success: function (res) {
                        alert(res);
                        $("#RegionDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveRegion() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#RegionDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newAttraction() {
    $("#fm").form("clear");
    $("#AttractionDialog").dialog("open").dialog("setTitle","新建");
    url = "/attraction/addition";
}
function editAttraction() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#AttractionDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/attraction/updates/"+row.aid;
    }
}
function destroyAttraction() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/attraction/deletion/"+row.aid,
                    success: function (res) {
                        alert(res);
                        $("#AttractionDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveAttraction() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#AttractionDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newRoute() {
    $("#fm").form("clear");
    $("#RouteDialog").dialog("open").dialog("setTitle","新建");
    url = "/route/addition";
}
function editRoute() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#RouteDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/route/updates/"+row.rtid;
    }
}
function destroyRoute() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/route/deletion/"+row.rtid,
                    success: function (res) {
                        alert(res);
                        $("#RouteDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveRoute() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#RouteDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function showRoute() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#showRouteDialog").dialog("open").dialog("setTitle",row.title);
        $("#rid_content").html(row.rid);
        $("#name_content").html(row.name);
        $("#voRid_content").html(row.voRid);
        $("#voAids_content").html(row.voAids);
        $("#var_content").html(row.var);
    }
}

function newHotel() {
    $("#fm").form("clear");
    $("#HotelDialog").dialog("open").dialog("setTitle","新建");
    url = "/hotel/addition";
}
function editHotel() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#HotelDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/hotel/updates/"+row.hid;
    }
}
function destroyHotel() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/hotel/deletion/"+row.hid,
                    success: function (res) {
                        alert(res);
                        $("#HotelDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveHotel() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#HotelDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newHouse() {
    $("#fm").form("clear");
    $("#HouseDialog").dialog("open").dialog("setTitle","新建");
    url = "/house/addition";
}
function editHouse() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#HouseDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/house/updates/"+row.hoid;
    }
}
function destroyHouse() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/house/deletion/"+row.hoid,
                    success: function (res) {
                        alert(res);
                        $("#HouseDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveHouse() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#HouseDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newSpecial() {
    $("#fm").form("clear");
    $("#SpecialDialog").dialog("open").dialog("setTitle","新建");
    url = "/special/addition";
}
function editSpecial() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#SpecialDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/special/updates/"+row.sid;
    }
}
function destroySpecial() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/special/deletion/"+row.sid,
                    success: function (res) {
                        alert(res);
                        $("#SpecialDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveSpecial() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#SpecialDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}


function newOrders() {
    $("#fm").form("clear");
    $("#OrdersDialog").dialog("open").dialog("setTitle","新建");
    url = "/orders/addition";
}
function editOrders() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#OrdersDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/orders/updates/"+row.oid;
    }
}
function destroyOrders() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/orders/deletion/"+row.oid,
                    success: function (res) {
                        alert(res);
                        $("#OrdersDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveOrders() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#OrdersDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function confirmOrder(id) {
    $.post("/orders/confirm/" + id,
        null,
        function (data) {
            alert(data);
            $('#dg').datagrid("reload");
        });
}
function showOrders() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#showOrdersDialog").dialog("open").dialog("setTitle",row.title);
        $("#name_content").html(row.name);
        $("#time_content").html(row.time);
        $("#state_content").html(row.state);
        $("#sum_content").html(row.sum);
        $("#var_content").html(row.var);
    }
}

function login() {
    $("#fm").form("submit",{
        url:"/login/login",
        success:function (res) {
            window.location.href = res;
        }
    })

    $("#fm").submit();
}
function logout() {
    $.get("/login/logout",null,function (res) {
        window.location.href = "/login_ui";
    })
}


function newConsumer() {
    $("#fm").form("clear");
    $("#ConsumerDialog").dialog("open").dialog("setTitle","新建");
    url = "/consumer/addition";
}
function editConsumer() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#ConsumerDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/consumer/updates/"+row.cid;
    }
}
function destroyConsumer() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/consumer/deletion/"+row.cid,
                    success: function (res) {
                        alert(res);
                        $("#ConsumerDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}