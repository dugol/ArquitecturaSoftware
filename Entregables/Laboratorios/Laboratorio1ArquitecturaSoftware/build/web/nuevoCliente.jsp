<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="container well">
            <form action="Lab2Servlet?action=newClient" method="post">

                <table>
                    <tr>
                        <th>  <label><b>Nombre:</b></label> </th>
                        <th> 
                            <input type="text" placeholder="Ingrese Nombre" class="form-control" name="name" required=""/>
                        </th>
                    </tr>
                    <tr>
                        <th> <label><b>Documento:</b></label></th>
                        <th><input type="number" placeholder="Ingrese Documento" class="form-control" name="document"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Direccion:</b></label></th>
                        <th><input type="text" placeholder="Ingrese Direccion" class="form-control" name="address"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Telefono:</b></label></th>
                        <th><input type="number" placeholder="Ingrese Telefono" class="form-control" name="phone"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Correo:</b></label></th>
                        <th><input type="email" placeholder="Ingrese Correo" class="form-control" name="email"
                                   required=""/> </th>
                    </tr>

                    <div class="break"></div>                        
                    </div>
                    <tr>
                        <td colspan="2">
                            <input class="btn icon-btn btn-success" type="submit" name="action" value="Insertar">
                            <span class="glyphicon glyphicon-ok-sign"></span>

                            <!--            <span class="glyphicons glyphicons-user-add img-circle text-success"></span>-->
                            <input class="btn btn-info btn-lg" type="reset" name="action" value="Reset">
                            <span class="glyphicon glyphicon-remove"></span>
                        </td>
                    </tr>
                </table>
            </form>   
            <br>
        </div>
    </body>
</html>

