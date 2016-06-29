<%--
  Created by IntelliJ IDEA.
  User: AIR
  Date: 2016/6/29
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" pageEncoding="UTF-8" %>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
    <style>
        .error-tip{
            color: red;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <h2>出错了</h2>
    <p class="error-tip">${message}</p>
</body>
</html>
