<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='es'>
    <head>
        <title>Pagina de inicio</title>
        <%@ include file = "includes/header.jsp" %>
    <body>
        <nav>
            <div>
                <a href="./login.jsp">Iniciar sesion</a>
            </div>
            <div>
                <a href="./login.jsp">Crear usuario</a>
            </div>
            <p><b>Pro</b><b>ces</b><b>ado</b<b>res</b><b>DB</b><b></p>
        </nav>
        <div id="content">
            <div id="inicio_sesion">
                <h1>Inicio de sesion</h1>
                <form method ="get" action="acceptuser.jsp">
                    Usuario : <input type="text" name="usuario"><br/><br/>
                    Contraseña : <input type="password" name ="password"><br/><br/>
                        <input type ="submit" value="SUBMIT" class="boton">    
                </form>
            </div>
        </div>
        <footer>
        <%@ include file = "includes/footer.jsp" %>
    </body>
</html>