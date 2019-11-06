<%--
  Created by IntelliJ IDEA.
  User: z-one
  Date: 11/6/19
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="/translate">
    <p>Input:&nbsp;<input type="text" name="searchWord" value="${searchWord}"></p>
    <p><button type="submit">Translate</button></p>
  </form>
  <p>Result:&nbsp;<input type="text" value="${result}" disabled></p>
  </body>
</html>
