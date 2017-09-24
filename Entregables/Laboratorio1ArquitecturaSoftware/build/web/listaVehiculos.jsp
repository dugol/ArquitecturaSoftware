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
        
        <form action="Lab2Servlet?action=filter" method="post">
            <table>
                <tr>
                        <th>  <label><b>Vehiculo por matricula</b></label> </th>
                        <th> 
                            <input type="text" placeholder="Ingrese matricula" class="form-control" name="filter" required=""/>
                        </th>
                        <th>
                            <input class="btn btn-info btn-lg" type="submit" name="action" value="Buscar">
                        </th>
                </tr>
            </table>
            
        </form>
        <jsp:include page="menu.jsp"></jsp:include>
        <c:forEach var="a" items="${vehiculos}">
           |${a.id}| |${a.modelo}| |${a.marca}| |${a.matricula.getCodigoMatricula()}| 
           <hr/>
        </c:forEach>        
        
    </body>
</html>
