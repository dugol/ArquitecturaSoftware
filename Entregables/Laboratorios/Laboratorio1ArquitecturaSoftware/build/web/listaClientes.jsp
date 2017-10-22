<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
         <jsp:include page="menu.jsp"></jsp:include>
        <table border="1" align="center"  class="table table-hover">
                <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Documento</th>
                    <th>Direccion</th>
                    <th>Telefono</th>
                    <th>Correo</th>
                </tr>
            </thead>
        <c:forEach var="a" items="${clientes}">
        <tr>
            <td>${a.nombre}</td>
            <td>${a.documento}</td>
            <td>${a.direccion}</td>
            <td>${a.telefono}</td>
            <td>${a.correo}</td>
        </tr>         

        <hr/>
    </c:forEach>        
    </table>
    </body>
</html>
