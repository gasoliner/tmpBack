<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
  <meta charset="UTF-8" /> 
  <title>用户登录</title>
  <link rel="stylesheet" href="/ui/login/css/reset.css" />
  <link rel="stylesheet" href="/ui/login/css/style.css" media="screen" type="text/css" />
 </head>
 <body> 
  <div id="window" style="">
   <div class="page page-front">
    <div class="page-content">
     <form method="post" action="/login/login">
     <div class="input-row">
      <label class="label fadeIn">账号</label>
      <input id="name" name="name" type="text" class="input fadeIn" />
     </div> 
     <div class="input-row"> 
      <label class="label fadeIn">密码</label>
      <input id="password" name="password" type="password"  class="input fadeIn" />
     </div> 
     <div class="input-row perspective"> 
      <button id="submit" type="submit" class="button "> <span class="default"><i class="ion-arrow-right-b"></i>登录</span>
       <div class="load-state">
        <div class="ball"></div>
        <div class="ball"></div>
        <div class="ball"></div>
       </div>
      </button>
      <div style="color: #f9fffe;margin: 10px">${login_error_info}</div>
     </div>
      <%
       request.getSession().removeAttribute("login_error_info");
      %>
     </form>
    </div> 
   </div> 
   <div class="page page-back"> 
    <div class="page-content"> 
     <img src="/ui/login/avatar.jpg" class="avatar" />
     <div class="perspective">
     </div>
    </div> 
   </div> 
  </div> 
  <script type="text/javascript" src="/ui/login/js/jquery.js"></script>
  <script type="text/javascript" src="/ui/login/js/fyll.js"></script>
  <script type="text/javascript" src="/ui/custom.js"></script>
 </body>
</html>