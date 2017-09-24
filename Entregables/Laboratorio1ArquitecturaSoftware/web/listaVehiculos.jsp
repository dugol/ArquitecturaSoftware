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
        <title>Lista Vehiculos</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <c:forEach var="a" items="${vehiculos}">
           |${a.id}| |${a.modelo}| |${a.marca}| |${a.matricula.getMatricula()}| 
           <hr/>
        </c:forEach>        
        
    </body>
</html>
