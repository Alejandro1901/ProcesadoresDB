<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "showError.jsp" %>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Pagina de verificacion de usuario</title>
    </head>
    <body>
        <h1>Verificacion Usuario</h1>

        <jsp:useBean id="validarUsuario" class="es.iespuertodelacruz.procesadores.controlador.ValidarUsuario"/>
        
        <jsp:setProperty name="validarUsuario" property="usuario"/>
        <jsp:setProperty name="validarUsuario" property="password"/>
          
        
        Información del usuario<br/>
        <p>Usuario : <jsp:getProperty name="validarUsuario" property="usuario"/></p>
        <p>Contraseña : <jsp:getProperty name="validarUsuario" property="password"/></p>
          
        <% validarUsuario.validate(); %> 

        <h3>Que accion desea realizar:</h3>

        <button>Insertar</button>
        <br>
        <button>Modificar</button>
        <br>
        <button>Eliminar</button>
        <br>
        <button>Buscar</button>
        <br>
        <button>Listar</button>
    </body>
</html>

