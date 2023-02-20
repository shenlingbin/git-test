<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>物流管理系统</title>
</head>
<link rel="stylesheet" type="text/css" href="../css/index.css"/>
<style type="text/css">
    label {
        width: 60px;
        display: inline-block;
        text-align: right;
    }
    #sel1 {
        width: 175px;
        height: 30px;
        border: 1px solid rgba(0,0,0,0.3);
        padding: 2px 2px 2px 32px;
        border-radius: 5px;
        color: black;
        outline: none;
    }
</style>
<body>
<form action="login.do" method="post">

    <span class="wz"><h2>用户登录</h2></span>
    <p>
        <span>账号:</span>
        <input type="text" name="username" placeholder="请输入账号" class="name"  maxlength="11" autofocus="autofocus" autocomplete="off" >

    </p>
    <p>
        <span>密码:</span>
        <input type="password" name="password" placeholder="请输入密码"  class="paw" maxlength="11" >
    </p>
    <p>
        <label>身份:</label>
        <select class="form-control" id="sel1"  name="shengfeng">
            <option>请选择身份</option>
            <option>管理员</option>
            <option>司机</option>
            <option>客户</option>
        </select>
    </p>
    <p class="p">
        <input type="submit"  value="登录" class="enter">
    </p>

</form>
</body>
</html>