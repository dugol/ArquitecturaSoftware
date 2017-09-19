<%@taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty login}">
    |<a href="login.jsp">Login</a>
    |<a href="login.jsp">Login</a>
    |<a href="login.jsp">Login</a>
    <!--|<a href="newAccount.jsp">Register</a>-->
</c:if>
    
<c:if test="${not empty login}">
    |<a href="CuentaServlet?action=logout">Salir</a>
    |<a href="CuentaServlet?action=list">ListaVehiculos</a>
    |<a href="CuentaServlet?action=new">AñadirVehiculo</a>
</c:if>
    <hr/>