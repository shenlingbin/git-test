<%--
  Created by IntelliJ IDEA.
  User: 沈玲彬
  Date: 2022/10/15
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加客户</title>
</head>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
<style type="text/css">


    .container input {
        width: 50%;
    }

    .form-group, h2 {
        margin-left: 30%;
        margin-top: 20px;
    }

    #row {
        width: 500px;
        margin-left: 30%;
    }

    #btn1 {
        margin-top: 30px;
        margin-left: 50%;
    }

    #btn2 {
        margin-top: 30px;
        margin-left: 50%;
    }

    .form-group label {
        margin-top: 20px;
        margin-bottom: 20px;
    }

    #errorMsg {
        display: inline-block;
        margin-top: 20px;
        color: red;
    }
    .form-group span {
        display: inline-block;
        width: 120px;
    }
</style>
<script type="text/javascript">
    window.onload = function () {
        var from1obj = document.getElementById("form1");
        from1obj.onsubmit = function () {
            var usernameobj = document.getElementById("userName");
            var usernametext = usernameobj.value;
            var ageobj = document.getElementById("age");
            var agetext = ageobj.value;
            var ageInt = Number(agetext);
            var phoneobj = document.getElementById("phone");
            var phonetext = phoneobj.value;
            var usernamePatt = /^\w{5,12}$/;
            var erroMsgobj = document.getElementById("errorMsg");
            if (!usernamePatt.test(usernametext)) {
                erroMsgobj.innerHTML = "用户名不合法,请重新输入";
                return false;
            } else if(ageInt > 120){
                erroMsgobj.innerHTML = "年龄不合法,请重新输入";
                return false;
            }else if (phonetext.length > 11) {
                erroMsgobj.innerHTML = "手机号至多包含11位有效数字最少11位";
                return false;
            }
            erroMsgobj.innerHTML = "";
        }
    }
</script>
<body>
<div class="container">
    <h2>添加客户</h2>
    <form action="AddCustomer.do" method="post" id="form1">
        <div class="form-group">
            <label for="name">姓名</label>
            <input type="text" class="form-control" placeholder="请输入姓名" name="name" id="name">
        </div>
        <div class="form-group">
            <label for="userName">用户名</label>
            <input type="text" class="form-control" placeholder="请输入账号" name="userName" id="userName">
        </div>
        <div class="form-group">
            <label>性别</label>
            <span><input type="radio" value="1"  name="gender">男</span>
            <span><input type="radio" value="2" name="gender">女</span>
        </div>
        <div class="form-group">
            <label for="ordersNumber">订单数</label>
            <input type="text" class="form-control" placeholder="请输入订单数" name="ordersNumber" id="ordersNumber">
        </div>
        <div class="form-group">
            <label for="phone">手机号</label>
            <input type="text" class="form-control" placeholder="请输入手机号" name="phone" id="phone">
        </div>
        <div class="form-group">
            <label>地址</label>
            <input type="text" class="form-control" placeholder="请输入收货地址" name="address">
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
