<%--
  Created by IntelliJ IDEA.
  User: www12
  Date: 2020/7/23
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<script src="jquery-3.5.1.js" type="text/javascript"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="bean.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>英雄列表</title>
</head>
<body>
    <table align="center" border="1px" cellpadding="0">
        <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>hp</th>
                <th>damage</th>
                <th>edit</th>
                <th>delete</th>
            </tr>
        </thead>
        <c:forEach items="${heros}" var="hero" varStatus="st">
            <tr>
                <td>${hero.id}</td>
                <td><c:out value="${hero.name}"/></td>
                <td>${hero.hp}</td>
                <td>${hero.damage}</td>
                <td><a href="editHero?id=${hero.id}">edit</a></td>
                <td><a href="deleteHero?id=${hero.id}">delete</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td align="center" colspan="6">
                <a href="?start=0">首页</a>
                <a href="?start=${pre}">上一页</a>
                <a href="?start=${next}">下一页</a>
                <a href="?start=${last}">尾页</a>
            </td>
        </tr>
    </table>

</body>
</html>
