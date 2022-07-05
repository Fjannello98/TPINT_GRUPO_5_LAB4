<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>
<body>
<div class="containerMenu">
    <nav>
        <ul>
            <li><a href="Home.jsp">Home</a></li>
            <li><a href="#">Pacientes</a>
            <!-- First Tier Drop Down -->
            <ul>
                <li><a href="ServletPacientes?Param=previoInsert"">Alta</a></li>
                <li><a href="ServletPacientes?Param=list">Listar/Modificar/Eliminar</a></li>
            </ul>        
            </li>
            <li><a href="#">M�dicos</a>
            <!-- First Tier Drop Down -->
              <ul>
                <li><a href="ServletMedicos?Param=previoInsert">Alta</a></li>
                <li><a href="ServletMedicos?Param=list">Listar/Modificar/Eliminar</a></li>
            </ul>   
            </li>
            <li><a href="#">Turnos</a>
            
             <ul>
                <li><a href="Turnos.jsp">Asignar Turno</a></li>
                <li><a href="ServletTurnos?Param=list">Listar/Modificar/Eliminar</a></li>
            </ul>     
            
            </li>
            
            <li><a href="Login.jsp">Usuario(Admin)</a></li>

        </ul>
    </nav>
 </div>    
</body>
</html>