<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Pacientes</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<style type="text/css">
	<jsp:include page="css\StyleSheetHome.css"></jsp:include>
</style>
<style type="text/css">
	<jsp:include page="css\StyleSheetListarPacientes.css"></jsp:include>
</style>
</head>
<body>
<div class="containerMenu">
    <nav>
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">Pacientes</a>
            <!-- First Tier Drop Down -->
            <ul>
                <li><a href="FormularioPaciente.jsp">Alta</a></li>
                <li><a href="ListarPacientes.jsp">Listar/Modificar/Eliminar</a></li>
            </ul>        
            </li>
            <li><a href="#">Médicos</a>
            <!-- First Tier Drop Down -->
             <ul>
                <li><a href="FormularioMedico.jsp">Alta</a></li>
                <li><a href="ListarPacientes.jsp">Listar/Modificar/Eliminar</a></li>
            </ul>     
            </li>
            <li><a href="#">Turnos</a>
            
             <ul>
                <li><a href="Turnos.jsp">Asignar Turno</a></li>
                <li><a href="ListarTurnos.jsp">Listar/Modificar/Eliminar</a></li>
            </ul>     
            
            </li>
            
            <li1><a href="Login.jsp">Usuario(Admin)</a></li>

        </ul>
    </nav>
  
</div>
	<div class="table-title">
	<h3>Tabla Pacientes</h3>
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
	</tr>
	</thead>
	<tbody class="table-hover">
	
	<tr>
	<td class="text-left">Alejandro</td>
	<td class="text-left">Devia</td>
	<td class="text-left">21089380</td>
	<td class="text-left">Masculino</td>
	<td class="text-left">Cazón 1514</td>
	<td class="text-left">05/08/1993</td>
	<td class="text-left">ale.devia@alumnos.frgp.utn.edu.ar</td>
	<td class="text-left">1163088654</td>
	<td class="text-left">Argentino</td>
	</tr>
	</tbody>
	</table>
	<br>
	<div align="center">
		<button type="button" style="background-color: #f44336;">
		  <i class="glyphicon glyphicon-trash"></i> Eliminar
		</button>
		<button type="button" style="background-color: #008CBA;">
		  <i class="glyphicon glyphicon-trash"></i> Modificar
		</button>
	</div>

</body>
</html>