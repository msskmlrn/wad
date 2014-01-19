<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Henkilot</title>
    </head>
    <body>
        <h2>Lisää henkilö</h2>
        <form action="lisaaHenkilo" method="POST">
            Henkilön nimi: <input type="text" name="nimi"><br/>
            Henkilön osoite: <input type="text" name="osoite"><br/>
            Henkilön puhelinnumero: <input type="text" name="puhelinnumero"><br/>
            <input type="submit" value="Lisää">            
        </form>
        <h2>Henkilöt</h2>
        <ul>
            <c:forEach var="henkilo" items="${henkilot}">
                <li><a href="naytaHenkilo/${henkilo.nimi}/">${henkilo.nimi}</a>, osoite: ${henkilo.osoite}, puhelinnumero: ${henkilo.puhelinnumero} <a href="poistaHenkilo/${henkilo.nimi}">poista</a></li>
            </c:forEach>
        </ul>
    </body>
</html>