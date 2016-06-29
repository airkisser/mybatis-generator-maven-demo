<%--
  Created by IntelliJ IDEA.
  User: AIR
  Date: 2016/6/29
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body{
            font-size: 16px;
        }
        .input-box label{
            display: inline-block;
            width: 100px;
            height: 40px;
            line-height: 40px;
        }

        .input-box input{
            display: inline-block;
            height: 40px;
            width: 300px;
            line-height: 40px;
            border-color: #ddd;
        }

        .input-box input:focus{
            border-color: #e99a67;
        }

        .input-box button{
            display: inline-block;
            width: 100px;
            height: 40px;
            line-height: 40px;
            margin-left: 300px;
            color: white;
            background: #658bff;
        }

        .input-box button:hover{
            background: #4787ff;
        }

        .error{
            color: red;
            display: inline-block;
            margin-left: 30px;
            font-size: 20px;
            text-align: right;
        }


    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <h2>用户登录<span class="error">${error}</span></h2>
    <div class="input-box">
        <label for="name">用户名</label>
        <input type="text" id="name" name="name" placeholder="用户名：admin  密码：123">
    </div>
    <div class="input-box">
        <label for="password">密码</label>
        <input type="password" id="password" name="password">
    </div>
    <div class="input-box">
        <button type="submit">登录</button>
    </div>
</form>
</body>
</html>
