<%@page import="excepciones.UsuarioSinPermisoException"%>
<%@page import="entidad.Usuario"%>
<%@page import="excepciones.UsuarioNoLoggeadoException"%>
<%@page import="entidad.Paciente" %>
<%@page import="datosImpl.PacienteDaoImpl" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
	 
	 
	 List<Paciente> listaM = new ArrayList<Paciente>();
		if (request.getAttribute("listaPac") != null) {
			listaM = (List<Paciente>)request.getAttribute("listaPac");
		}
		
	
	Paciente p = new Paciente();
	if(request.getAttribute("dniPaciente")!=null){
		p = (Paciente)request.getAttribute("dniPac");
	}
	 
	%>
	<jsp:include page="Menu.jsp"></jsp:include>
	<h1 class="h1 mb-5" >Editar paciente</h1>
	  <div class="row">
	    <div class="col-6">
	     <form method="post" action="ServletPacientes?Param=editar&dni=<%p.getDni();%>">
	      
	        <div class="form-group">
	          <label>Nombre: </label>
	          <input type="text" class="form-control" name="txtNombre" value="<%p.getNombre();%>">
	        </div>
	        <div class="form-group">
	          <label>Apellido: </label>
	          <input type="text" class="form-control" name="txtApellido" value="<%p.getApellido();%>">
	        </div>
	        <div class="form-group">
	          <label>DNI: </label>
	          <input type="text" disabled="disabled" class="form-control" name="txtDNI" value="<%p.getDni();%>">
	        </div>
	        <div class="form-group">
	          <label>Correo electrónico: </label>
	          <input type="email" class="form-control" name="txtCorreo" value="<%p.getCorreo();%>">
	        </div>
	        
	        
	        
	        <div class="form-group">
	          <label>Teléfono: </label>
	          <input type="phone" class="form-control" name="txtTelefono" value="">
	        </div>
	        
	         <div class="form-group">
	          <label>Celular: </label>
	          <input type="phone" class="form-control" name="txtCelular" value="">
	        </div>
	        
	        <div class="form-group">
	          <label>Fecha de nacimiento: </label>
	          <input type="date" class="form-control col-8" name="txtFechaNac" value="">
	        </div>
	        <div class="form-group">
	          <label>Nacionalidad: </label>
	          <input type="text" class="form-control" name="txtNacionalidad" value="">
	        </div>
	       <div class="form-group">
	          <label>Localidad: </label>
	          <input type="text" class="form-control" name="txtLocalidad" value="">
	        </div>
	      
	        <div class="form-group">
	          <label>Provincia: </label>
	          <input type="text" class="form-control" name="txtProvincia" value="">
	        </div>
	        
	        <div class="form-group">
	          <label>Dirección:</label>
	          <input type="text" class="form-control" name="txtDireccion" value="">
	        </div>
	        
	        <div class="form-group">
	          <label>Sexo: </label>
	          <select class="form-control col-8" name="comboSexo" >
	          	<!-- Esto debería leerlo desde una DB -->
	            <option value="1">Masculino</option>
	            <option value="2">Femenino</option>
	            <option value="3">Otro</option>
	          </select>
	        </div>
	        <div class="col-12">
	        	<input type="submit" class="btn btn-success" value="Guardar" name="btnGuardar">
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