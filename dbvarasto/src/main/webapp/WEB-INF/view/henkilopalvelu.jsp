<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Henkilöpalvelu</title>
    </head>
    <body>
        <h1>Henkilöpalvelu</h1>

        <h2>Lisää henkilö</h2>
        <form action="lisaa" method="POST">
            Henkilön nimi: <input type="text" name="nimi"><br/>
            Henkilön osoite: <input type="text" name="osoite"><br/>
            Henkilön puhelinnumero: <input type="text" name="puhelinnumero"><br/>
            <input type="submit" value="Lisää">            
        </form>

        <h2>Henkilöt</h2>
        <ul>
            <c:forEach var="henkilo" items="${henkilot}">
                <li>${henkilo.id}, nimi ${henkilo.nimi}, osoite ${henkilo.osoite}, puhelinnumero ${henkilo.puhelinnumero} <a href="/dbvarasto/henkilopalvelu/poista/${henkilo.id}">poista</a></li>
            </c:forEach>
        </ul>
    </body>
</html>
