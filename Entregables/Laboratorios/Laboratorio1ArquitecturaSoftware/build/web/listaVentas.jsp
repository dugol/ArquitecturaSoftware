<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Ventas</title>
    </head>
    <body>
         <jsp:include page="menu.jsp"></jsp:include>
        <table border="1" align="center"  class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Valor</th>
                    <th>Matricula auto vendido</th>
                    <th>cliente</th>
                </tr>
            </thead>
        <c:forEach var="a" items="${ventas}">
        <tr>
            <td>${a.idVenta}</td>
            <td>${a.valor}</td>
            <td>${a.matricula.getCodigoMatricula()}</td>
            <td>${a.cliente.getDocumento()}</td>
        </tr>         

        <hr/>
    </c:forEach>        
    </table>     
    </body>
</html>
