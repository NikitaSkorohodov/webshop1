
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Новая статья</title>
    </head>
    <body>
        <h1>Клиенты</h1>
        <form action="createArticle" method="POST">
            <select name="clientId">
                <c:forEach var="client" items="${listClients}">
                    <option value="${client.id}">${client.firstname} ${client.lastname}</option>
                </c:forEach>
            </select><br>
                    </form>
    </body>
</html>
