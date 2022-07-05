<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingresar paciente</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<style type="text/css">
	<jsp:include page="css\StyleSheetHome.css"></jsp:include>
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
                <li><a href="ServletPacientes?Param=previoInsert"">Alta</a></li>
                <li><a href="ServletPacientes?Param=list">Listar/Modificar/Eliminar</a></li>
            </ul>        
            </li>
            <li><a href="#">Médicos</a>
            <!-- First Tier Drop Down -->
             <ul>
                <li><a href="ServletMedicos?Param=previoInsert">Alta</a></li>
                <li><a href="ServletMedicos?Param=list">Listar/Modificar/Eliminar</a></li>
            </ul>     
            </li>
            <li><a href="ListarTurnos.jsp">Turnos</a>
            
             <ul>
                <li><a href="Turnos.jsp">Asignar Turno</a></li>
                <li><a href="ServletTurnos?Param=list">Listar/Modificar/Eliminar</a></li>
            </ul>     
            
            </li>
            
            <li1><a href="Login.jsp">Usuario(Admin)</a></li>

        </ul>
    </nav>
  
</div>

	<h1 class="h1 mb-5" >Ingresar nuevo paciente</h1>
	  <div class="row">
	    <div class="col-6">
	      <form>
	        <div class="form-group">
	          <label>Nombre: </label>
	          <input type="text" class="form-control">
	        </div>
	        <div class="form-group">
	          <label>Apellido: </label>
	          <input type="text" class="form-control">
	        </div>
	        <div class="form-group">
	          <label>DNI: </label>
	          <input type="text" class="form-control">
	        </div>
	        <div class="form-group">
	          <label>Correo electrónico: </label>
	          <input type="email" class="form-control">
	        </div>
	        <div class="form-group">
	          <label>Teléfono: </label>
	          <input type="phone" class="form-control">
	        </div>
	        <div class="form-group">
	          <label>Fecha de nacimiento: </label>
	          <input type="date" class="form-control col-8">
	        </div>
	        <div class="form-group">
	          <label>Nacionalidad:</label>
	          <select class="form-control col-8">
	          	<!-- Esto debería leerlo desde una DB -->
	            <option>Argentina</option>
	            <option>Brasil</option>
	          </select>
	        </div>
	        <div class="form-group">
	          <label>Localidad:</label>
	          <select class="form-control col-8">
	          	<!-- Esto debería leerlo desde una DB -->
	            <option>CABA</option>
	            <option>Tigre</option>
	          </select>
	        </div>
	        <div class="form-group">
	          <label>Provincia:</label>
	          <select class="form-control col-8">
	          	<!-- Esto debería leerlo desde una DB -->
	            <option>CABA</option>
	            <option>Provincia de Bs As</option>
	          </select>
	        </div>
	        <div class="form-group">
	          <label>Dirección:</label>
	          <input type="text" class="form-control">
	        </div>
	        <div class="form-group">
	        	<label class="col-12">Sexo: </label>
		        <div class="form-group custom-control custom-control-inline custom-radio">
		          <input type="radio" id="radio-masculino" name="sexo" class="custom-control-input">
		          <label for="radio-masculino" class="custom-control-label">Masculino</label>
		        </div>
		        <div class="custom-control custom-control-inline custom-radio">
		          <input type="radio" id="radio-femenino" name="sexo" class="custom-control-input">
		          <label for="radio-femenino" class="custom-control-label">Femenino</label>
		        </div>
		        <div class="custom-control custom-control-inline custom-radio">
		          <input type="radio" id="radio-otro" name="sexo" class="custom-control-input">
		          <label for="radio-otro" class="custom-control-label">Otro</label>
		        </div>
	        </div>
	        <div class="col-12">
	        	<button type="submit" class="btn btn-success">Crear</button>
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