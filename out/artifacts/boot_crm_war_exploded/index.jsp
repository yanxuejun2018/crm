<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/4/004
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
<h1>点击进入</h1>
<form action="${pageContext.request.contextPath }/customer/list.action" method="get">
  <p>账号: <input type="text" name="fname" /></p>
  <p>密码: <input type="text" name="lname" /></p>
  <input type="submit" value="点击登录" />
</form>
  </body>
</html>
