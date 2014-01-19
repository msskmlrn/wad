<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat</title>
    </head>
    <body>
        <strong>Chat</strong><br />
        
        <form:form commandName="kommentti" action="${pageContext.request.contextPath}/Chat" method="POST">
            <form:input path="viesti"/><form:errors path="viesti" /><br/>
            <input type="submit" value="Lähetä" />
        </form:form>
            
        <br /><strong>Viestit</strong><br />
        <c:forEach var="viesti" items="${viestit}">
            ${viesti.tunnus}: ${viesti.viesti} <br />
        </c:forEach>
        <br /><a href="Logout"> kirjaudu ulos</a>
        
    </body>
</html>