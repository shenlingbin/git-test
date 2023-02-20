<%@ page import="com.github.pagehelper.PageInfo" %>
<%@ page import="com.example.logistics_system.pojo.DriverDto" %>
<%@ page import="com.example.logistics_system.pojo.CustomerDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
<html>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    ul {
        list-style: none;
    }
    a {
        text-decoration: none;
    }
    h1 {
        /* display: inline-block; */
        text-align: center;
        margin-top: 50px;
    }
    .main-wrapper {
        padding-left: 300px;
    }
    .aside-nav {
        position: fixed;
        top: 0;
        bottom: 0;
        width: 300px;
        background-color: #333;
        color: #fff;
    }
    /* 导航标题 */
    .aside-nav .nav-title {
        height: 70px;
        line-height: 70px;
        text-align: center;
        font-size: 24px;
        border-bottom: 1px solid #222;
    }
    /* 导航列表 */
    /* 父导航 */
    .aside-nav .nav-list .parentNav {
        height: 70px;
        line-height: 70px;
        padding: 0 16px;
        font-size: 20px;
    }
    .aside-nav .nav-list .parentNav:hover{
        background-color: #222;
    }
    /* 子导航 */
    .aside-nav .nav-list .item.active .subNav{
        display: block;
    }

    .aside-nav .nav-list .subNav li a {
        color: #fff;
        display: inline-block;
        width: 100%;
        box-sizing: border-box;
        height: 60px;
        line-height: 60px;
        font-size: 15px;
        padding-left: 60px;
    }
    .aside-nav .nav-list .subNav li a:hover,
    .aside-nav .nav-list .item.active .parentNav{
        background-color: #222;
    }
    .aside-nav .nav-list .subNav{
        display: none;
    }
    .zx {
        float: right;
        width: 100px;
        height: 100px;
    }
    .title{
        width :800px;
        height: 200px;
        margin: auto auto;
    }
    .iconfont1{
        margin-right: 20px;
    }
    td{
        display: inline-block;
        width:150px;
        height: 80px;
        line-height: 80px;
        border: none;
    }
    td:nth-child(1) {
        text-align: right;
    }

    td:nth-child(3) {
        text-align: left;
    }
    table {
        display: inline-block;
        padding-left: 300px;

    }
</style>
<head>
    <title>首页</title>
</head>
<body>
<!-- 左侧导航栏 -->
<div class="aside-nav">
    <!-- 导航标题 -->
    <div class="nav-title">
        管理系统 v1.0
    </div>
    <% CustomerDto personal = (CustomerDto) request.getAttribute("personal");%>
    <!-- 导航列表 -->
    <ul class="nav-list">
        <li class="item">
            <!-- 父导航 -->
            <div class="parentNav">
                <i class="iconfont1"><img src="../img/应用.png" ></i>
                <span>个人信息管理</span>
            </div>
            <!-- 子导航 -->
            <ul class="subNav">
                <li>
                    <a href="cgrxx.do?userName=${userInfo.userName}">个人信息</a>
                </li>
                <li>
                    <a href="CustomerUpdate.do?userName=${userInfo.userName}">修改信息</a>
                </li>
                <li>
                    <a href="UpdateCustomerPassword.do?userName=${userInfo.userName}">修改密码</a>
                </li>
            </ul>
        </li>
    </ul>
    <ul class="nav-list">
        <li class="item">
            <!-- 父导航 -->
            <div class="parentNav">
                <i class="iconfont1"><img src="../img/应用.png" ></i>
                <span>订单管理</span>
            </div>
            <!-- 子导航 -->
            <ul class="subNav">
                <li>
                    <a href="cddxx.do?userName=${userInfo.userName}">个人订单</a>
                </li>
                <li>
                    <a href="AddOrder.do">添加订单</a>
                </li>
            </ul>
        </li>
    </ul>
</div>
<!-- 主体部分 -->
<div class="main-wrapper">
    <div class="zx">
        <span><h3><a href="index.do"><img src="../img/注销.png" ></a></h3></span>
    </div>
    <div class="title">
        <span><h1>欢迎<%= personal.getUserName()%>登陆</h1></span>
    </div>
    <div class="container">
        <h2>个人信息</h2>
        <table class="table table-hover">
            <thead>
            <tr>
                <td>姓名：</th>
                <td></td>
                <td><%=personal.getName() %></td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>用户名：</td>
                <td></td>
                <td><%=personal.getUserName() %></td>

            </tr>
            <tr>
                <td>性别：</td>
                <td></td>
                <% int gender= personal.getGender();
                    if(gender==2){%>
                <td>女</td>
                <%}else if(gender==1){ %>
                <td>男</td>
                <%} %>
            </tr>
            <tr>
                <td>订单数：</td>
                <td></td>
                <td><%=personal.getOrdersNumber() %></td>
            </tr>
            <tr>
                <td>电话号码：</td>
                <td></td>
                <td><%=personal.getPhone() %></td>
            </tr>
            <tr>
                <td>地址：</td>
                <td></td>
                <td><%=personal.getAddress() %></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<script>
    var that;
    class AsideNav{
        constructor(className) {
            this.main = document.querySelector(className);

            this.lis = this.main.querySelectorAll(".nav-list .item");

            this.parentNavs = this.main.querySelectorAll(".nav-list .item .parentNav");
            that = this;

            this.init();
        }
        init(){
            for(var i =0;i<this.lis.length;i++){
                this.parentNavs[i].onclick = this.toggleNav
            }
        }

        clearClass(){
            for(var i =0;i<this.lis.length;i++){
                this.lis[i].className = "item"
            }
        }
        toggleNav(){
            var li =this.parentNode;
            if(li.classList.contains("active")){
                li.classList.remove("active")
            }else{
                that.clearClass();
                li.classList.add("active");
            }
        }
    }
    var asideNav = new AsideNav(".aside-nav");
</script>
</body>
</body>
</html>
