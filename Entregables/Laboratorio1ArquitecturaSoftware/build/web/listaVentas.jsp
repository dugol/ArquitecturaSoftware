<%-- 
    Document   : listAccount
    Created on : 11/01/2017, 09:02:32 PM
    Author     : Usuario
--%>

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
        <c:forEach var="a" items="${ventas}">
           |${a.idVenta}| |${a.valor}| |${a.matricula.getCodigoMatricula()}| |${a.cliente.getDocumento()}| 
           <hr/>
        </c:forEach>        
        
    </body>
</html>
