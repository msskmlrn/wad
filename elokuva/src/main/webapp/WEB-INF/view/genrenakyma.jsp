<%-- 
    Document   : genrenakyma
    Created on : Feb 5, 2012, 9:28:14 PM
    Author     : miika
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Elokuva</title>
    </head>
    <body>
        <h1>${genre.nimi}</h1>
        <h2>Elokuvat: </h2>
        <ul>
            <c:forEach var="elokuva" items="${elokuvat}">
                <li>${elokuva.nimi}</li>
             </c:forEach>
        </ul>
    </body>
</html>
