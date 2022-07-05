<%@page import="excepciones.UsuarioNoLoggeadoException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="entidad.Turno"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Turnos</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
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
	} %>
	<jsp:include page="Menu.jsp"></jsp:include>
	<%
		List<Turno> listaT = new ArrayList<Turno>();
		if (request.getAttribute("listaTurno") != null) {
			listaT = (List<Turno> ) request.getAttribute("listaTurno");
		}
	%>
	<div class="table-title">
	<h3>Turnos</h3>
	</div>
	<table class="table-fill">
	<thead>
	<tr>
	<th class="text-left">ID</th>
	<th class="text-left">Paciente</th>
	<th class="text-left">Médico Asignado</th>
	<th class="text-left">Especialidad</th>
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
				<td><%=a.getDNI_medico().getApellido() +", "+ a.getDNI_medico().getNombre()%></td>
				<td><%=a.getID_especialidad().getDescripcion()%></td>
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