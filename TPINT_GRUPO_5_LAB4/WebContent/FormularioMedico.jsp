<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingresar nuevo médico</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.6/dist/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
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
                <li><a href="FormularioPaciente.jsp">Alta</a></li>
                <li><a href="ListarPacientes.jsp">Listar/Modificar/Eliminar</a></li>
            </ul>        
            </li>
            <li><a href="#">Médicos</a>
            <!-- First Tier Drop Down -->
             <ul>
                <li><a href="FormularioMedico.jsp">Alta</a></li>
                <li><a href="#">Listar/Modificar/Eliminar</a></li>
            </ul>     
            </li>
            <li><a href="ListarTurnos.jsp">Turnos</a>
            
             <ul>
                <li><a href="Turnos.jsp">Asignar Turno</a></li>
                <li><a href="ListarPacientes.jsp">Listar/Modificar/Eliminar</a></li>
            </ul>     
            
            </li>
            
            <li1><a href="Login.jsp">Usuario(Admin)</a></li>

        </ul>
    </nav>
  
</div>
	<div class="container">
    
	<h1 class="h1 mb-5">Ingresar nuevo médico</h1>
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
	          <label>Especialidad médica:</label>
	          <select class="form-control col-8">
	          	<!-- Esto debería leerlo desde una DB -->
	            <option>Cirugía general</option>
	            <option>Traumatología</option>
	          </select>
	        </div>
	        <div class="form-group">
	          <label>Días y horarios de atención:</label>
	          <div class="d-flex">
	          		<input type="time" class="form-control col-3" value="09:00">
	          		<input type="time" class="form-control col-3" value="17:00">         
	          </div>
			  <div class="col-12 col-md-3">
				<div class="form-check form-check-inline">
					<input type="checkbox"  id="lunes">
					<label for="lunes" class="mb-0 ml-1">Lunes</label>
				</div>
			    <div class="form-check form-check-inline">
					<input type="checkbox"  id="martes">
					<label for="martes" class="mb-0 ml-1">Martes</label>
				</div>
				<div class="form-check form-check-inline">
					<input type="checkbox"  id="miercoles">
					<label for="miercoles" class="mb-0 ml-1">Miércoles</label>
				</div>
				<div class="form-check form-check-inline">
					<input type="checkbox"  id="jueves">
					<label for="jueves" class="mb-0 ml-1">Jueves</label>
				</div>
				<div class="form-check form-check-inline">
					<input type="checkbox"  id="viernes">
					<label for="viernes" class="mb-0 ml-1">Viernes</label>
				</div>
				<div class="form-check form-check-inline">
					<input type="checkbox"  id="sabados">
					<label for="sabados" class="mb-0 ml-1">Sábados</label>
				</div>
				<div class="form-check form-check-inline">
					<input type="checkbox"  id="domingos">
					<label for="domingos" class="mb-0 ml-1">Domingos</label>
				</div>
	        	</div>
	        </div>	
	        <div class="form-group">
	          <label>Teléfonos: </label>
	          <div class="dynamic-wrap">
		          <div class="telefonos-form">
		            <div class="entry input-group">
		              <input class="form-control" name="fields[]" type="text" placeholder="Teléfono" />
		              <span class="input-group-btn">
		                <button class="btn btn-success btn-add" type="button">
		                        <span>+</span>
		                </button>
		              </span>
		            </div>
		          </div>
		       </div>
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
	    </div>
	  </div>
	  </div>
	 
   
   
   <script type="text/javascript">
	   $(function() {
		   $(document).on('click', '.btn-add', function(e) {
		     e.preventDefault();
	
		     var dynaForm = $('.dynamic-wrap .telefonos-form:first'),
		       currentEntry = $(this).parents('.entry:first'),
		       newEntry = $(currentEntry.clone()).appendTo(dynaForm);
	
		     newEntry.find('input').val('');
		     dynaForm.find('.entry:not(:last) .btn-add')
		       .removeClass('btn-add').addClass('btn-remove')
		       .removeClass('btn-success').addClass('btn-danger')
		       .html('<span> - </span>');
		   }).on('click', '.btn-remove', function(e) {
		     $(this).parents('.entry:first').remove();
	
		     e.preventDefault();
		     return false;
		   });
		 });
   </script>
</body>
</html>