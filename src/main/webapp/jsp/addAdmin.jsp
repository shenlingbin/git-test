<%--
  Created by IntelliJ IDEA.
  User: 沈玲彬
  Date: 2022/10/12
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
<html>
<head>
    <title>添加管理员</title>
</head>
<style type="text/css">
    #container {
        margin-top:250px ;
    }
    .container input{
        width: 50%;
    }
    .form-group ,h2 {
        margin-left: 30%;
        margin-top: 20px;
    }
    #row{
        width: 500px;
        margin-left: 30%;
    }
    #btn1{
        margin-top: 30px;
        margin-left: 50%;
    }
    #btn2{
        margin-top: 30px;
        margin-left: 50%;
    }
    .form-group label{
        margin-top: 20px;
        margin-bottom: 20px;
    }
    #errorMsg{
        display: inline-block;
        margin-top: 20px;
        color: red;
    }
</style>
<script type="text/javascript">
    window.onload = function(){
        var from1obj =document.getElementById("form1");
        from1obj.onsubmit =function(){
            var  usernameobj=document.getElementById("userName");
            var usernametext = usernameobj.value;
            var pawobj =document.getElementById("password");
            var pawtext = pawobj.value;
            var usernamePatt =/^\w{5,12}$/;
            var  erroMsgobj = document.getElementById("errorMsg");
            if(!usernamePatt.test(usernametext)){
                erroMsgobj.innerHTML ="用户名不合法,请重新输入";
                return false;
            }else if(pawtext.length < 8){
                erroMsgobj.innerHTML ="密码至少包含8位有效数字";
                return false;
            }
            erroMsgobj.innerHTML = "";

        }
    }
</script>
    <body>
<div class="container" id="container">
    <h2>管理员注册</h2>
    <form action="AddAdmin.do" id="form1">
        <div class="form-group">
            <label for="userName">注册用户名</label>
            <input type="text" class="form-control" placeholder="必须由字母，数字，下划线组成。并且长度是5到12位" name="userName" id="userName">
        </div>
        <div class="form-group">
            <label for="password">注册密码</label>
            <input type="password" class="form-control" placeholder="请输入密码" name="password" id="password">
        </div>
        <div id="row" class="row">

            <div class="col-sm-8">
                <button type="submit" class="btn btn-primary btn2" id="btn2">提交</button>
            </div>
            <span id="errorMsg"></span>
        </div>
    </form>
</div>

</body>
</html>
