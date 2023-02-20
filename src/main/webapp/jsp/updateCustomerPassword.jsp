<%@ page import="com.example.logistics_system.pojo.UserDto" %>
<%@ page import="com.example.logistics_system.pojo.DriverDto" %>
<%@ page import="com.example.logistics_system.pojo.CustomerDto" %><%--
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
    <title>Title</title>
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
            var pawobj =document.getElementById("password1");
            var pawtext1 = pawobj.value;
            var pawobj =document.getElementById("password2");
            var pawtext2 = pawobj.value;
            var  erroMsgobj = document.getElementById("errorMsg");
             if(pawtext1 < 8){
                erroMsgobj.innerHTML ="密码至少包含8位有效数字";
                return false;
            }else if(pawtext1 != pawtext2){
                erroMsgobj.innerHTML ="密码与确认密码不一致";
                return false;
            }
            erroMsgobj.innerHTML = "";
        }
    }
</script>
<body>
<div class="container" id="container">
    <h2>修改密码</h2>
    <%CustomerDto customer = (CustomerDto) request.getAttribute("customer"); %>
    <form action="updateCustomerPassword.do" id="form1">
        <div class="form-group">
            <input type="hidden" name="id" value="<%=customer.getId() %>">
            <label for="password1">密码</label>
            <input type="password" class="form-control" placeholder="请输入密码，至少8位有效数字" name="password" id="password1">
        </div>
        <div class="form-group">
            <label for="password2">确认密码</label>
            <input type="password" class="form-control" placeholder="请确认密码" name="password1" id="password2">
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
