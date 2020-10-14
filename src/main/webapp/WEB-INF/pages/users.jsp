<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UsersCRUD</title>
</head>
<body>
<h2>Users</h2>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Character</th>
        <th>Iq</th>
    </tr>
    <c:forEach var = "user" items = "${usersList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.character}</td>
            <td>${user.IQ}</td>
            <td>
                <a href="/edit/${user.id}">edit</a>
                <a href="/delete/${user.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<h2>Add</h2>
</body>
</html>