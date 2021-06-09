<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='es'>
    <head>
        <title>Pagina de inicio</title>
        <%@ include file = "includes/header.jsp" %>
    <body>
        <h1>Inicio de sesion</h1>
        <form method ="get" action="acceptuser.jsp">
            Usuario : <input type="text" name="usuario"><br/><br/>
            Contraseña : <input type="password" name ="password"><br/><br/>
                <input type ="submit" value="SUBMIT">    
        </form>
        <footer>
        <%@ include file = "includes/footer.jsp" %>
    </body>
</html>