<!DOCTYPE html>
<html>
<head>
    <title>小鱼儿的博客2</title>
    <link href="${rc.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${rc.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#nav-target">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${rc.contextPath}/index">小鱼儿的博客</a>
        </div>
        <div id="nav-target" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">学海无涯</a></li>
                <li><a href="#">生活点滴</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${rc.contextPath}/account/register"><span class="glyphicon glyphicon-user"></span> 注册</a>
                </li>
                <li><a href="${rc.contextPath}/account/login"><span class="glyphicon glyphicon-log-in"></span> 登录</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#"class="dropdown-toggle" data-toggle="dropdown">
                        欢迎，小明
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="${rc.contextPath}/account">账户设置</a></li>
                        <li><a href="${rc.contextPath}/account/logout">退出</a> </li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-right">
                <div class="input-group">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                        <button class="btn btn-default">搜一下</button>
                    </span>
                </div>
            </form>
        </div>
    </div>
</nav>
</body>
<script src="${rc.contextPath}/js/jquery.min.js"></script>
<script src="${rc.contextPath}/js/bootstrap.min.js"></script>

</html>