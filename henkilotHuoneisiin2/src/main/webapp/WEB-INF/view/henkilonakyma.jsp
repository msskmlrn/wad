<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Henkilonäkymä</title>
    </head>
    <body>
        <h1>Henkilö</h1>
        nimi: ${henkilo.nimi} <br /> 
        osoite: ${henkilo.osoite} <br />
        puhelinnumero: ${henkilo.puhelinnumero} <br />
        <br />
        huone: ${huone.id} <br />
        kerros: ${huone.kerros}  <br />
        kapasiteetti: ${huone.kapasiteetti}
    </body>
</html>