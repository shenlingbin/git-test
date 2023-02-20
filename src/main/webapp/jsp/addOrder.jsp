<%@ page import="com.example.logistics_system.pojo.UserDto" %>
<%@ page import="com.example.logistics_system.pojo.Drivers" %>
<%@ page import="com.example.logistics_system.pojo.Orders" %><%--
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
            var ageobj = document.getElementById("age");
            var agetext = ageobj.value;
            var ageInt = Number(agetext);
            var erroMsgobj = document.getElementById("errorMsg");
             if(ageInt > 120){
                erroMsgobj.innerHTML = "年龄不合法,请重新输入";
                return false;
            }
            erroMsgobj.innerHTML = "";
        }
    }
</script>
<body>
<div class="container">
    <h2>订单</h2>
    <form action="addOrder.do" id="form1">
        <div class="form-group">
            <label for="productName">订单名称</label>
            <input type="text" class="form-control"  name="productName" id="productName">
            <input type="hidden" class="form-control" value="${userInfo.userName}" name="orderUser" id="orderUser">
        </div>
        <div class="form-group">
            <label for="productNumber">产品数</label>
            <input type="text" class="form-control" name="productNumber" id="productNumber">
        </div>
        <div class="form-group">
            <label for="productUnit">单位</label>
            <input type="text" class="form-control" name="productUnit" id="productUnit">
        </div>
        <div class="form-group">
            <label>配送司机</label>
            <input type="text" class="form-control" name="deliverman">
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
