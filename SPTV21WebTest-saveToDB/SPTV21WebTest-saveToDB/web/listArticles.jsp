<%-- 
    Document   : index
    Created on : Feb 8, 2023, 3:22:29 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SPTV21WebTest</title>
    </head>
    <body>
        <h1>Статьи:</h1>
        <ol>
            <c:forEach var="article" items="${listArticles}">
                <li><a href="article?articleId=${article.id}">${article.title}</a></li>
            </c:forEach>
            
        </ol>
        <br>
        <a href="newArticle">Добавить новую статью</a><br>
        <a href="newAuthor">Добавить нового автора</a>
    </body>
</html>
