<%@page import="entidad.Usuario"%>
<%@page import="excepciones.UsuarioSinPermisoException"%>
<%@page import="excepciones.UsuarioNoLoggeadoException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidad.Medico"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Medicos</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
	integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
	crossorigin="anonymous">
<style type="text/css">
	<jsp:include page="css\StyleSheetMain.css"></jsp:include>
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
	 if (user.getTipo_usuario().getID() != 1) { 
			request.getRequestDispatcher("Home.jsp").forward(request, response);
			throw new UsuarioSinPermisoException();
	} 
	%>
	<jsp:include page="Menu.jsp"></jsp:include>
	<%
	 	if (request.getParameter("buscarLista") == null) {
		 	request.getRequestDispatcher("ServletMedicos?Param=list").forward(request, response);
		 }
		List<Medico> listaM = new ArrayList<Medico>();
		if (request.getAttribute("listaMed") != null) {
			listaM = (List<Medico>) request.getAttribute("listaMed");
		}
	%>
	<div class="table-title">
		<h3>Tabla Medicos</h3>
	</div>
	

	       
	        
	<table class="table-fill">
		<thead>
			<tr>
				<th class="text-left">Nombre</th>
				<th class="text-left">Apellido</th>
				<th class="text-left">DNI</th>
				<th class="text-left">Sexo</th>
				<th class="text-left">Direccion</th>
				<th class="text-left">Fecha de Nacimiento</th>
				<th class="text-left">Email</th>
				<th class="text-left">Telefono</th>
				<th class="text-left">Nacionalidad</th>
				<th class="text-left">Especialidad</th>
				<th></th>
			</tr>
		</thead>
		<tbody class="table-hover">

			<tr>
				<%
			for (Medico a : listaM) {
		%>
			
			<tr>
				<form action="ServletMedicos" method="post">
				<td><%=a.getNombre()%></td>
				<td><%=a.getApellido()%></td>
				<td><%=a.getDni()%><input type="hidden" name="dniMedico" value="<%=a.getDni()%>"></td>
				<td><%=a.getSexo()%></td>
				<td><%=a.getDireccion()%></td>
				<td><%=a.getFechaNac()%></td>
				<td><%=a.getCorreo()%></td>
				<td><%=a.getTelefono()%></td>
				<td><%=a.getNacionalidad()%></td>
				<th><%=a.getID_especialidad().getDescripcion() %></th>
				<td> <input type="submit" name="btnEliminar" value="Eliminar" class="btn btn-danger"></td>
				<td> <input type="submit" name="btnEditar" value="Editar" class="btn btn-warning"></td>
				</form>
			</tr>

			<%
			}
		%>

		</tbody>
	</table>
	<br>

</body>
</html>