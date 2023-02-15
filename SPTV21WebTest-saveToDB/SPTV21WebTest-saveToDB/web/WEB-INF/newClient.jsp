<%-- 
    Document   : newClient
    Created on : 15.02.2023, 7:11:50
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Создание нового client</h1>
        <form action="createClient" method="POST">
            Имя: <input type="text" name="firstname"><br>
            Фамилия: <input type="text" name="lastname"><br>
            <input type="submit" value="Создать client">
        </form>
    </body>
</html>
