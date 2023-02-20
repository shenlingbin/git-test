<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.github.pagehelper.PageInfo" %>
<%@ page import="com.example.logistics_system.pojo.UserDto" %>
<%@ page import="com.example.logistics_system.pojo.DriverDto" %>
<%@ page import="com.example.logistics_system.pojo.Customers" %>
<%@ page import="com.example.logistics_system.pojo.Orders" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
<html>
<style type="text/css">
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
        padding-left: 150px;
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
    .bg {
        height: 100px;
    }
    .bg ul{
        margin-left: 550px;
    }
    .bg ul a {
        height: 40px;
    }
    .iconfont1{
        margin-right: 20px;
    }
    .container h2 {
        padding-bottom: 30px;
    }
    tr{
        line-height: 55px;
    }
    .container span{
        display: inline-block;
        width:600px;
    }

    form.example input[type=text] {
        padding: 10px;
        font-size: 17px;
        border: 1px solid grey;
        border-right: none;
        float: left;
        width: 80%;
        background: #f1f1f1;
        outline: none;
        box-shadow: 0px 5px 0px 0px #f1f1f1 ;
    }

    form.example button {
        float: left;
        width: 20%;
        height: 47.5px;
        padding: 3px;
        background: #888d7e;
        color: white;
        font-size: 17px;
        border: 2px solid grey;
        border-top: 3px solid gray;
        border-left: none;
        cursor: pointer;
        box-shadow: 0px 5px 5px 1px #f1f1f1 ;
    }

    form.example button:hover {
        background: #a3a3a3;
    }

    form.example::after {
        content: "";
        clear: both;
        display: table;
    }
    .fa-search{
        display: inline-block;
        width: 38px;
        height: 38px;
        margin-bottom: 20px;
        background-image: url(../img/搜索.png);
    }
    td a{
        text-decoration: none;
        display: inline-block;
        width: 90px;
        margin-top: 13px;
    }
    button.btn.btn-outline-danger {
        width: 80px;
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
                    <a href="sjgrxx.do?userName=${userInfo.userName}">个人信息</a>
                </li>
                <li>
                    <a href="DriverUpdate.do?userName=${userInfo.userName}">修改信息</a>
                </li>
                <li>
                    <a href="UpdateDriverPassword.do?userName=${userInfo.userName}">修改密码</a>
                </li>
            </ul>
        </li>
    </ul>
    <ul class="nav-list">
        <li class="item">
            <!-- 父导航 -->
            <div class="parentNav">
                <i class="iconfont1"><img src="../img/应用.png" ></i>
                <span>客户管理</span>
            </div>
            <!-- 子导航 -->
            <ul class="subNav">
                <li>
                    <a href="dkhxx.do">客户信息</a>
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
                    <a href="dddxx.do">订单信息</a>
                </li>
            </ul>
        </li>
    </ul>
</div>
<!-- 主体部分 -->
<div class="main-wrapper">
    <div class="zx">
        <span><h4><a href="index.do"><img src="img/注销.png" ></a></h4></span>
    </div>
    <div class="title">
        <span><h1>欢迎${userInfo.userName}登陆</h1></span>
    </div>
        <% PageInfo pi=(PageInfo)request.getAttribute("searchOrders"); %>
        <% List<Orders> list=pi.getList(); %>
    <div class="main-wrapper">
        <div class="container">
            <span><h2>订单信息</h2></span>
            <span>
		    <form class="example" action="driverSearchOrders.do" style="margin:auto;max-width:300px">
		      <input type="text" placeholder="搜索.." name="search">
		      <button type="submit"><i class="fa fa-search"></i></button>
            </form>
	     </span>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>id</th>
                    <th>产品名称</th>
                    <th>产品数量</th>
                    <th>单位</th>
                    <th>所属用户</th>
                    <th>配送司机</th>
                </tr>
                </thead>
                <tbody>
                <% for(int i=0;i<list.size();i++){ %>
                <tr>
                    <td><%=list.get(i).getId() %></td>
                    <td><%=list.get(i).getProductName() %></td>
                    <td><%=list.get(i).getProductNumber() %></td>
                    <td><%=list.get(i).getProductUnit() %></td>
                    <td><%=list.get(i).getOrderUser() %></td>
                    <td><%=list.get(i).getDeliverman() %></td>
                </tr>
                <%} %>
                </tbody>
            </table>
            <!-- 分页页码导航栏 -->
            <br>
            <div align="center" class="bg container">
                <ul class="pagination">
                    <!-- 判断当前页是否存在上一页，不存在则不显示上一页的按钮 -->
                    <%if(pi.getPrePage()>0){ %>
                    <li class = "page-item"><a href="dddxx.do?ym=<%=pi.getPrePage()%>" class="page-link" aria-lable="Previous">&laquo;</a></li>
                    <%} %>
                    <% for(int i:pi.getNavigatepageNums()){ %>
                    <li class = "page-item"><a href="dddxx.do?ym=<%=i%>" class="page-link">&nbsp;<%=i %>&nbsp;</a></li>
                    <%} %>
                    <!-- 判断当前页是否存在下一页，不存在则不显示下一页的按钮 -->
                    <% if(pi.getPageNum()<pi.getLastPage()){ %>
                    <li class="page-item"><a href="dddxx.do?ym=<%=pi.getNextPage()%>" class="page-link" aria-lable="Next" >&raquo;</a></li>
                    <%} %>
                </ul>
            </div>
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
</html>
