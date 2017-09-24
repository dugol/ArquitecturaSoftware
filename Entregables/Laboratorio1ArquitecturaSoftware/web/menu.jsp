<%@taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty login}">
    |<a href="login.jsp">Login</a>
    <!--|<a href="newAccount.jsp">Register</a>-->
</c:if>
    
<c:if test="${not empty login}">
    |<a href="Lab2Servlet?action=logout">Salir</a>
    |<a href="Lab2Servlet?action=listCar">Lista Vehiculos</a>
    |<a href="Lab2Servlet?action=listClient">Lista Clientes</a>
    |<a href="Lab2Servlet?action=listSale">Lista Ventas</a>
    |<a href="Lab2Servlet?action=toAddCar">Añadir Vehiculo</a>
    |<a href="Lab2Servlet?action=toAddVenta">Registrar Venta</a>
    |<a href="Lab2Servlet?action=toAddCliente">Registrar Cliente</a>
</c:if>
    <hr/>