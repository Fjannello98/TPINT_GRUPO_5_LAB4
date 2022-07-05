<%@page import="excepciones.UsuarioSinPermisoException"%>
<%@page import="entidad.Usuario"%>
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
	<jsp:include page="Menu.jsp"></jsp:include>

	<h1 class="h1 mb-5">Ingresar nuevo Turno</h1>
	  <div class="row">
	    <div class="col-6">
	      <form>
			<div class="form-group">

	          <label>Especialidad:</label>
	          <select class="form-control col-8">
	          	<!-- Esto debería leerlo desde una DB -->
	            <option>Traumatologia</option>
	            <option>Clinico</option>
	          </select>
	        </div>
	        <div class="form-group">
	          <label>Medico:</label>
	          <select class="form-control col-8">
	          	<!-- Esto debería leerlo desde una DB -->
	            <option>Ramirez ,Pedro</option>
	            <option>Lopez ,Maximiliano</option>
	            <option>Garcia ,Mirtha</option>
	            <option>Farinelli ,Lucia</option>
	          </select>
	        </div>
	        <p> Fecha: <input type="date" name="Fecha"></input></p>
	        <p>  Hora: <input type="number" name="Numero"></input>
	        <div class="form-group">
	          <label>Paciente:</label>
	          <select class="form-control col-8">
	          	<!-- Esto debería leerlo desde una DB -->
	            <option>Rodriguez, Juana</option>
	            <option>Pirez, Mario</option>
	            <option>Gutierrez ,Lucia</option>
	          </select>
	           <p>
	       <div class="col-12">
	        	<button type="submit" class="btn btn-success">Alta turno</button>
	        	<button type="submit" class="btn btn-outline-info">Limpiar campos</button>
	        </div></p>
	      </form>
	    </div>
	  </div>
	</div>

</body>
</html>