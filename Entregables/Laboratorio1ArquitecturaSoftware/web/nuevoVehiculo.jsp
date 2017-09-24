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
        <script type="text/javascript" src="./codigo.js"></script>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="container well">
            <form action="Lab2Servlet?action=newCar" method="post">

                <table>
                    <tr>
                        <th>  <label><b>Modelo:</b></label> </th>
                        <th> 
                            <input type="text" placeholder="Ingrese Modelo" class="form-control" name="modelo" required=""/>
                        </th>
                    </tr>
                    <tr>
                        <th> <label><b>Marca:</b></label></th>
                        <th><input type="text" placeholder="Ingrese Marca" class="form-control" name="marca" 
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Matricula:</b></label></th>
                        <th><input type="text" placeholder="Ingrese Matricula" class="form-control" name="matricula"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Placa:</b></label></th>
                        <th><input type="text" placeholder="Ingrese placa" class="form-control" name="placa"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Seleccione imagen del vehiculo</b></label></th>
                        <th><input type="file" class="form-control" onchange="cargarImagen(this)" accept="image/*"  name="image"
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
