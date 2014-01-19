<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat</title>
    </head>
    <body>
        <strong>Chat</strong><br />

        <form method="post" action="kommentti">
            <input type="text" name="viesti" />
            <input type="submit" value="Lähetä" />
        </form>
        
        <br /><strong>Viestit</strong><br />
        <c:forEach var="viesti" items="${viestit}">
            ${viesti.tunnus}: ${viesti.viesti} <br />
        </c:forEach>
        <br /><a href="Logout"> kirjaudu ulos</a>
        
    </body>
</html>
