<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <c:forEach var="a" items="${clientes}">
           |${a.nombre}| |${a.documento}| |${a.direccion}| |${a.telefono}| |${a.correo}|
           <hr/>
        </c:forEach>        
        
    </body>
</html>
