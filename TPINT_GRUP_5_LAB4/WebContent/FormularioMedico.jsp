<%@page import="excepciones.UsuarioSinPermisoException"%>
<%@page import="entidad.Usuario"%>
<%@page import="excepciones.UsuarioNoLoggeadoException"%>
<%@page import="entidad.Especialidad"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingresar M�dico</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<style type="text/css">
	<jsp:include page="css\StyleSheetMain.css"></jsp:include>
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
	
	<%
		List<Especialidad> listaE = new ArrayList<Especialidad>();
		if (request.getAttribute("listaEsp") != null) {
			listaE = (List<Especialidad>)request.getAttribute("listaEsp");
		}
	%>
	
	
	<jsp:include page="Menu.jsp"></jsp:include>
	<h1 class="h1 mb-5" >Ingresar Nuevo M�dico</h1>
	  <div class="row">
	    <div class="col-6">
	    
	      <form onSubmit="confirmarEditar(event)" method="post" action="ServletMedicos">
	      
	        <div class="form-group">
	          <label>Nombre: </label>
	          <input type="text" class="form-control" name="txtNombre" required>
	        </div>
	        <div class="form-group">
	          <label>Apellido: </label>
	          <input type="text" class="form-control" name="txtApellido" required>
	        </div>
	        <div class="form-group">
	          <label>DNI: </label>
	          <input type="text" class="form-control" name="txtDNI" required>
	        </div>
	        <div class="form-group">
	          <label>Correo electr�nico: </label>
	          <input type="email" class="form-control" name="txtCorreo" required>
	        </div>
	        
	        <!-- ESTO TIENE QUE SER UN COMBOBOX!!! -->
	        <div class="form-group">
	          <label>Especialidad: </label>
	          <select class="form-control col-8" name="comboEspecialidad" >
	          	<!-- Esto deber�a leerlo desde una DB -->
	            		<%
							for (Especialidad e : listaE) {
						%>
						<option value="<%=e.getID()%>"><%=e.getDescripcion()%></option>
						<%
							}
						%>
	          </select>
	        </div>
	        
	        
	         <!-- PARA DISPONIBILIDAD POR MEDICO  -->
	        <div class="form-group">
	          <label>Disponibilidad:</label>
	          <br>
	          <input type="checkbox" id="lunes" name="dia" value="1">
 			 <label for="vehicle1"> Lunes </label><br>
 			 
 			 <input type="checkbox" id="martes" name="dia" value="2">
 			 <label for="martes"> Martes </label><br>
 			 
 			<input type="checkbox" id="miercoles" name="dia" value="3">
 			 <label for="miercoles"> Miercoles </label><br>
 			 
 			 <input type="checkbox" id="jueves" name="dia" value="4">
 			 <label for="jueves"> Jueves </label><br>
 			 
 			 <input type="checkbox" id="viernes" name="dia" value="5">
 			 <label for="viernes"> Viernes </label><br>
 			 
 			 <input type="checkbox" id="miercoles" name="dia" value="6">
 			 <label for="miercoles"> Sabado </label><br>
 			 
 			 <input type="checkbox" id="domingo" name="dia" value="0">
 			 <label for="domingo"> Domingo </label><br>
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
	          <select class="form-control col-8" name="comboSexo"  >
	          	<!-- Esto deber�a leerlo desde una DB -->
	            <option value="1">Masculino</option>
	            <option value="2">Femenino</option>
	            <option value="3">Otro</option>
	          </select>
	        </div>
	        <div class="col-12">
	        	<input  type="submit" class="btn btn-success" value="Aceptar" name="btnAceptar">
	        	<button  type="submit" class="btn btn-outline-info">Limpiar campos</button>
	        </div>
	      </form>
	      
		 <%
		if (request.getAttribute("estadoMedico") != null) {
		%>
		<%=request.getAttribute("estadoMedico")%>
		<%
			}
		%>
	    </div>
	  </div>
		
		<script>
		
			function confirmarEditar(event){
				
				var result = confirm("Esta seguro que desea editar este Medico?");
				
						if (result === false) {
						    event.preventDefault();
						    
						  }
				
			}
		
		
		
		</script>

</body>
</html>