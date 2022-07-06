<%@page import="excepciones.UsuarioSinPermisoException"%>
<%@page import="entidad.Usuario"%>
<%@page import="entidad.Especialidad"%>
<%@page import="entidad.Medico"%>
<%@page import="entidad.Paciente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="excepciones.UsuarioNoLoggeadoException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingresar Turno</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style type="text/css">
	<jsp:include page="css\StyleSheetHome.css"></jsp:include>
</style>

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
	
	<%
		List<Medico> listaM = new ArrayList<Medico>();
		if (request.getAttribute("listaMed") != null) {
			listaM = (List<Medico>)request.getAttribute("listaMed");
		}
	%>
	
	<%
		List<Paciente> listaP = new ArrayList<Paciente>();
		if (request.getAttribute("listaPac") != null) {
			listaP = (List<Paciente>)request.getAttribute("listaPac");
		}
	%>
	
	
	
	<jsp:include page="Menu.jsp"></jsp:include>

 		<form method="post" action="ServletTurnos">
	 		<!-- ESPECIALIDAD  -->
	        <div class="form-group">
	          <label>Seleccione una Especialidad: </label>
	          <select class="form-control col-8" name="comboEspecialidad" >
	          	<!-- Esto deber�a leerlo desde una DB -->
	            		<%
							for (Especialidad e : listaE) {
						%>
						<option value="<%=e.getID()%>"><%=e.getDescripcion() %></option>
						<%
							}
						%>
	          </select>
	        </div>
	        
	        <!-- MEDICOS  -->
	        <div class="form-group">
	          <label>Seleccione un M�dico: </label>
	          <select class="form-control col-8" name="comboMedico" >
	          	<!-- Esto deber�a leerlo desde una DB -->
	            		<%
							for (Medico m : listaM) {
						%>
						<option value="<%=m.getDni()%>"><%=m.getApellido() + ", " + m.getNombre() %></option>
						<%
							}
						%>
	          </select>
	        </div>
	        
	         <!-- PACIENTES  -->
	        <div class="form-group">
	          <label>Seleccione un Paciente: </label>
	          <select class="form-control col-8" name="comboPaciente" >
	      
	            		<%
							for (Paciente p : listaP) {
						%>
						<option value="<%=p.getDni()%>"><%=p.getApellido() + ", " + p.getNombre() %></option>
						<%
							}
						%>
	          </select>
	        </div>
	        
	        
	         <!-- FECHA  -->
	         <div class="form-group">
	          <label>Fecha: </label>
	          <input type="date" class="form-control col-8" name="txtFecha">
	        </div>
	        
	        <!-- HORA  -->
	         <div class="form-group">
	          <label>Hora: </label>
	          <input type="time" class="form-control col-8" name="txtHora">
	        </div>
	        	        	        
	        
	         <!-- OBSERVACIONES  -->
	         <div class="form-group">
	          <label>Observaciones: </label>
	          <input type="text" style="WIDTH: 228px; HEIGHT: 98px" class="form-control" name="txtObservacion">
	        </div>
	           
	       <div class="col-12">
	        	<input type="submit" class="btn btn-success" value="Aceptar" name="btnAceptar">
	        	<button type="submit" class="btn btn-outline-info">Limpiar campos</button>
	        </div></p>
	      </form>
	      
	      
	          <%
		if (request.getAttribute("estadoTurno") != null) {
	%>
	Turno agregado con exito
	<%
		}
	%>
	  

</body>
</html>