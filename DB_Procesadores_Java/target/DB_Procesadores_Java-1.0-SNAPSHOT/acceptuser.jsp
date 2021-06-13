<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "showError.jsp" %>
<!DOCTYPE html>
<html>
    <head>
       <title>Pagina de verificacion de usuario</title>
       <%@ include file = "includes/header.jsp" %>
    <body>
        <h1>Verificacion Usuario</h1>

        <jsp:useBean id="validarUsuario" class="es.iespuertodelacruz.procesadores.controlador.ValidarUsuario"/>
        
        <jsp:setProperty name="validarUsuario" property="usuario"/>
        <jsp:setProperty name="validarUsuario" property="password"/>
          
        
        Información del usuario<br/>
        <p><b>Usuario :</b> <jsp:getProperty name="validarUsuario" property="usuario"/></p>
        <p><b>Contraseña :</b> <jsp:getProperty name="validarUsuario" property="password"/></p>
          
        <% validarUsuario.validate(); %> 

        <h3>Que accion desea realizar:</h3>

		<ul class="none">
			<li>Arquitectura
				<ul class="square">
				  <li><form method="GET" action="insertarArquitectura.jsp"><button>Insertar</button></form></li>
				  <li><form method="GET" action="insertarArquitectura.jsp"><button>Modificar</button></form></li>
				  <li><form method="GET" action="insertarArquitectura.jsp"><button>Eliminar</button></form></li>
				  <li><form method="GET" action="insertarArquitectura.jsp"><button>Buscar</button></form></li>
				  <li><form method="GET" action="insertarArquitectura.jsp"><button>Listar</button></form></li>
				</ul>
			</li>
            <li>Fabricante
				<ul class="square">
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Insertar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Modificar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Eliminar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Buscar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Listar</button></form></li>
				</ul>
			</li>
            <li>Grafica Integrada
				<ul class="square">
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Insertar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Modificar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Eliminar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Buscar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Listar</button></form></li>
				</ul>
			</li>
            <li>Nombre Procesador
				<ul class="square">
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Insertar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Modificar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Eliminar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Buscar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Listar</button></form></li>
				</ul>
			</li>
            <li>PlacaBase
				<ul class="square">
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Insertar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Modificar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Eliminar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Buscar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Listar</button></form></li>
				</ul>
			</li>
            <li>Procesador - Grafica Integrada
				<ul class="square">
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Insertar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Modificar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Eliminar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Buscar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Listar</button></form></li>
				</ul>
			</li>
            <li>Procesador
				<ul class="square">
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Insertar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Modificar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Eliminar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Buscar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Listar</button></form></li>
				</ul>
			</li>
            <li>Zocalo
				<ul class="square">
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Insertar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Modificar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Eliminar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Buscar</button></form></li>
					<li><form method="GET" action="insertarArquitectura.jsp"><button>Listar</button></form></li>
				</ul>
			</li>
		</ul>
    </body>
    <footer>
        <%@ include file = "includes/footer.jsp" %>
</html>

