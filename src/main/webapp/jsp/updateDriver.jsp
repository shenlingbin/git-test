<%@ page import="com.example.logistics_system.pojo.UserDto" %>
<%@ page import="com.example.logistics_system.pojo.Drivers" %><%--
  Created by IntelliJ IDEA.
  User: 沈玲彬
  Date: 2022/10/15
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>
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
    <h2>司机修改</h2>
    <% Drivers driver = (Drivers) request.getAttribute("driver"); %>
    <form action="updateDriver.do" id="form1">
        <div class="form-group">
            <input type="hidden" name="id" value="<%=driver.getId() %>">
            <label for="name">姓名</label>
            <input type="text" class="form-control" name="name" id="name" value="<%=driver.getName() %>">
        </div>
        <div class="form-group">
            <label for="userName">用户名</label>
            <input type="text" class="form-control"  name="userName" id="userName" value="<%=driver.getUserName() %>">
            <input type="hidden" name = "password" value="<%=driver.getPassword() %>">
        </div>
        <div class="form-group">
            <label>性别</label>
            <% int gender=driver.getGender(); %>
            <% if(gender==1){ %>
            <span><input type="radio" value="1"  name="gender" checked="checked">男</span>
            <span><input type="radio" value="2" name="gender">女</span>
            <%}else if(gender==2){ %>
            <span><input type="radio" value="1"  name="gender" >男</span>
            <span><input type="radio" value="2" name="gender" checked="checked">女</span>
            <%} %>
        </div>
        <div class="form-group">
            <label for="age">年龄</label>
            <input type="text" class="form-control" value="<%= driver.getAge()%>" name="age" id="age">
        </div>
        <div class="form-group">
            <label for="phone">手机号</label>
            <input type="text" class="form-control" value="<%=driver.getPhone()%>" name="phone" id="phone">
        </div>
        <div class="form-group">
            <label>车型</label>
            <input type="text" class="form-control" value="<%=driver.getCarType() %>" name="carType">
        </div>
        <div class="form-group">
            <label>路线</label>
            <input type="text" class="form-control" value="<%=driver.getPath() %>" name="path">
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
