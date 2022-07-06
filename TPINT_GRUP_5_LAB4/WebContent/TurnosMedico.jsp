<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Turno"%>
<%@page import="java.util.List"%>
<%@page import="excepciones.UsuarioSinPermisoException"%>
<%@page import="entidad.Usuario"%>
<%@page import="excepciones.UsuarioNoLoggeadoException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Turnos asociados</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style type="text/css">
	<jsp:include page="css\StyleSheetHome.css"></jsp:include>
</style>
<style type="text/css">
	<jsp:include page="css\StyleSheetListarPacientes.css"></jsp:include>
</style>
</head>
<body>
	<% if (request.getSession().getAttribute("usuario") == null) { 
		request.getRequestDispatcher("Login.jsp").forward(request, response);
		throw new UsuarioNoLoggeadoException();
	} 
	 Usuario user = (Usuario)request.getSession().getAttribute("usuario");
	 if (user.getTipo_usuario().getID() != 2) { 
			request.getRequestDispatcher("Home.jsp").forward(request, response);
			throw new UsuarioSinPermisoException();
	}
	 List<Turno> listaT = new ArrayList<Turno>();
	 if (request.getParameter("buscarLista") == null) {
	 	request.getRequestDispatcher("ServletTurnosMedico?buscarLista").forward(request, response);
	 }
	 else {
     	listaT = (List<Turno>) request.getAttribute("listaTurnosMedico");
	 }
	%>
	<jsp:include page="Menu.jsp"></jsp:include>
		<div class="table-title">
	<h3>Tus turnos asignados</h3>
	</div>
	<table class="table-fill">
	<thead>
	<tr>
	<th class="text-left">ID</th>
	<th class="text-left">Paciente</th>
	<th class="text-left">Fecha</th>
	<th class="text-left">Horario</th>
	<th class="text-left">Estado</th>
	<th class="text-left">Observación</th>
	

	</tr>
	</thead>
	<tbody class="table-hover">
	
	<tr>
				<%
			for (Turno a : listaT) {
		%>
			
			<tr>
				<td><%= a.getId() %></td>
				<td><%= a.getDNI_paciente().getApellido()+", "+ a.getDNI_paciente().getNombre() %></td>
				<td><%=a.getFecha() %></td>
				<td><%=a.getHora() %></td>
				<td><%=a.getID_estado().getDescripcion()%></td>
				<td><%=a.getObservacion()%></td>
			</tr>

			<%
			}
		%>
	</tbody>
	</table>
	<br>
	<div align="center">
		<button type="button" style="background-color: #f44336;">
		  <i class="glyphicon glyphicon-trash"></i> Datos del Paciente
		</button>
		<button type="button" style="background-color: #008CBA;">
		  <i class="glyphicon glyphicon-trash"></i> Agregar Observación
		</button>
	</div>
	
</body>
</html>