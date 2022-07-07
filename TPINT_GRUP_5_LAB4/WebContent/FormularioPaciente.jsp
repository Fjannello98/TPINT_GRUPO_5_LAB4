<%@page import="excepciones.UsuarioSinPermisoException"%>
<%@page import="entidad.Usuario"%>
<%@page import="excepciones.UsuarioNoLoggeadoException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingresar paciente</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<style type="text/css">
	<jsp:include page="css\StyleSheetHome.css"></jsp:include>
</style>
<script src="https://kit.fontawesome.com/dc241c5998.js" crossorigin="anonymous"></script>
</head>
<body>

	<% if (request.getSession().getAttribute("usuario") == null) { 
		request.getRequestDispatcher("Login.jsp").forward(request, response);
		throw new UsuarioNoLoggeadoException();
	} 
	 Usuario user = (Usuario)request.getSession().getAttribute("usuario");
	 if (user.getTipo_usuario().getID() != 1) { 
			request.getRequestDispatcher("Home.jsp").forward(request, response);
			throw new UsuarioSinPermisoException();
	} 
	%>
	<jsp:include page="Menu.jsp"></jsp:include>
	<h1 class="h1 mb-5" >Ingresar nuevo paciente</h1>
	  <div class="row">
	    <div class="col-6">
	     <form method="post" action="ServletPacientes">
	      
	        <div class="form-group">
	          <label>Nombre: </label>
	          <input type="text" class="form-control" name="txtNombre" title="Ingrese su nombre" required />
	        </div>
	        <div class="form-group">
	          <label>Apellido: </label>
	          <input type="text" class="form-control" name="txtApellido" required>
	        </div>
	        <div class="form-group">
	          <label>DNI: </label>
	          <input type="number" class="form-control" name="txtDNI" required>
	        </div>
	        <div class="form-group">
	          <label>Correo electr�nico: </label>
	          <input type="email" class="form-control" name="txtCorreo" required>
	        </div>
	        
	        
	        
	        <div class="form-group">
	          <label>Tel�fono: </label>
	          <input type="phone" class="form-control" name="txtTelefono" required>
	        </div>
	        
	         <div class="form-group">
	          <label>Celular: </label>
	          <input type="phone" class="form-control" name="txtCelular" required>
	        </div>
	        
	        <div class="form-group">
	          <label>Fecha de nacimiento: </label>
	          <input type="date" class="form-control col-8" name="txtFechaNac" required>
	        </div>
	        <div class="form-group">
	          <label>Nacionalidad: </label>
	          <input type="text" class="form-control" name="txtNacionalidad" required>
	        </div>
	       <div class="form-group">
	          <label>Localidad: </label>
	          <input type="text" class="form-control" name="txtLocalidad" required>
	        </div>
	      
	        <div class="form-group">
	          <label>Provincia: </label>
	          <input type="text" class="form-control" name="txtProvincia" required>
	        </div>
	        
	        <div class="form-group">
	          <label>Direcci�n:</label>
	          <input type="text" class="form-control" name="txtDireccion" required>
	        </div>
	        
	        <div class="form-group">
	          <label>Sexo: </label>
	          <select class="form-control col-8" name="comboSexo" >
	          	<!-- Esto deber�a leerlo desde una DB -->
	            <option value="1">Masculino</option>
	            <option value="2">Femenino</option>
	            <option value="3">Otro</option>
	          </select>
	        </div>
	        
	        <div class="col-12">
	        	<input type="submit" class="btn btn-success" value="Aceptar" name="btnAceptar">
	        	<button type="submit" class="btn btn-outline-info">Limpiar campos</button>
	        </div>
	      </form>
	       <%
		if (request.getAttribute("estadoPaciente") != null) {
	%>
	Paciente agregado con exito
	<%
		}
	%>
	    </div>
	  </div>
	</div>

</body>
</html>