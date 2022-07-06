<<<<<<< HEAD
package presentacion.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datosImpl.PacienteDaoImpl;
import entidad.Especialidad;
import entidad.Medico;
import entidad.Paciente;
import negocio.PacienteNeg;
import negocioImpl.PacienteNegImpl;


@WebServlet("/ServletPacientes")
public class ServletPacientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PacienteNeg negPac = new PacienteNegImpl();
  
    
    public ServletPacientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("Param")!=null)
		{
			String opcion = request.getParameter("Param").toString();
			
			switch (opcion) {
			case "previoInsert":
			{
				
				break;
			}
			case "list":
			{
				request.setAttribute("listaPac", negPac.listarPacientes());	
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarPacientes.jsp");
				dispatcher.forward(request, response);
				break;
			}
			default:
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(request.getParameter("btnAceptar")!=null)
		    {
		    	Paciente x = new Paciente();
		    		    	
			
					x.setNombre(request.getParameter("txtNombre"));
					x.setApellido(request.getParameter("txtApellido"));
					x.setDni(request.getParameter("txtDNI"));
					x.setTelefono(request.getParameter("txtTelefono"));
					x.setCelular(request.getParameter("txtCelular"));
					x.setCorreo(request.getParameter("txtCorreo"));
					x.setDireccion(request.getParameter("txtDireccion"));
					x.setNacionalidad(request.getParameter("txtNacionalidad"));
					x.setLocalidad(request.getParameter("txtLocalidad"));
					x.setProvincia(request.getParameter("txtProvincia"));
					
					int sexo = Integer.parseInt(request.getParameter("comboSexo"));
					switch (sexo) {
					case 1:
						x.setSexo("Masculino");	
						break;
					case 2:
						x.setSexo("Femenino");	
						break;
					case 3:
						x.setSexo("Otro");	
						break;
					default:
						break;
					}
					
				
					
					//IMPORTANTISIMO PARA FECHA					
					SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
					Date fecha;
					try {
						fecha = formato.parse(request.getParameter("txtFechaNac"));
						x.setFechaNac(fecha);						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
					
				
					
					x.setEstado(1);
					boolean estado=true;
					estado = negPac.insertar(x);
					request.setAttribute("estadoPaciente", estado);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/FormularioPaciente.jsp");
					dispatcher.forward(request, response);
					
		    }
		
		if(request.getParameter("btnEliminar")!=null) 
		{
			String dni = request.getParameter("dniPaciente");
			
			if(negPac.borrar(dni)) {
			ArrayList<Paciente> lista = negPac.listarPacientes();
			request.setAttribute("listaPac", lista);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarPacientes.jsp");
			dispatcher.forward(request, response);
			}
		}
		
		//BUSQUEDA DINAMICA
		 if(request.getParameter("btnBuscar")!=null)
		 {
		    	String parametro = request.getParameter("txtBuscar");	    				
		    	request.setAttribute("listaPac", negPac.obtenerBusqueda(parametro));	
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarPacientes.jsp");
				dispatcher.forward(request, response);
					
		 }
			
	}

}
=======
package presentacion.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datosImpl.PacienteDaoImpl;
import entidad.Especialidad;
import entidad.Medico;
import entidad.Paciente;
import negocio.PacienteNeg;
import negocioImpl.PacienteNegImpl;


@WebServlet("/ServletPacientes")
public class ServletPacientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PacienteNeg negPac = new PacienteNegImpl();
  
    
    public ServletPacientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("Param")!=null)
		{
			String opcion = request.getParameter("Param").toString();
			
			switch (opcion) {
			case "previoInsert":
			{
				
				break;
			}
			case "list":
			{
				request.setAttribute("listaPac", negPac.listarPacientes());	
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarPacientes.jsp?buscarLista=1");
				dispatcher.forward(request, response);
				break;
			}
			case "editar":
			{
				request.setAttribute("dniPac", request.getParameter("dni"));	
				RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarPaciente.jsp");
				dispatcher.forward(request, response);
				break;
			}
			default:
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(request.getParameter("btnAceptar")!=null)
		    {
		    	Paciente x = new Paciente();
		    		    	
			
					x.setNombre(request.getParameter("txtNombre"));
					x.setApellido(request.getParameter("txtApellido"));
					x.setDni(request.getParameter("txtDNI"));
					x.setTelefono(request.getParameter("txtTelefono"));
					x.setCelular(request.getParameter("txtCelular"));
					x.setCorreo(request.getParameter("txtCorreo"));
					x.setDireccion(request.getParameter("txtDireccion"));
					x.setNacionalidad(request.getParameter("txtNacionalidad"));
					x.setLocalidad(request.getParameter("txtLocalidad"));
					x.setProvincia(request.getParameter("txtProvincia"));
					
					int sexo = Integer.parseInt(request.getParameter("comboSexo"));
					switch (sexo) {
					case 1:
						x.setSexo("Masculino");	
						break;
					case 2:
						x.setSexo("Femenino");	
						break;
					case 3:
						x.setSexo("Otro");	
						break;
					default:
						break;
					}
					
				
					
					//IMPORTANTISIMO PARA FECHA					
					SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
					Date fecha;
					try {
						fecha = formato.parse(request.getParameter("txtFechaNac"));
						x.setFechaNac(fecha);						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
					
				
					
					x.setEstado(1);
					boolean estado=true;
					estado = negPac.insertar(x);
					request.setAttribute("estadoPaciente", estado);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/FormularioPaciente.jsp");
					dispatcher.forward(request, response);
					
		    }
		 
		 
		 
		 if(request.getParameter("btnGuardar")!=null)
		    {
		    	Paciente x = new Paciente();
		    		    	
			
					x.setNombre(request.getParameter("txtNombre"));
					x.setApellido(request.getParameter("txtApellido"));
					x.setDni(request.getParameter("txtDNI"));
					x.setTelefono(request.getParameter("txtTelefono"));
					x.setCelular(request.getParameter("txtCelular"));
					x.setCorreo(request.getParameter("txtCorreo"));
					x.setDireccion(request.getParameter("txtDireccion"));
					x.setNacionalidad(request.getParameter("txtNacionalidad"));
					x.setLocalidad(request.getParameter("txtLocalidad"));
					x.setProvincia(request.getParameter("txtProvincia"));
					
					int sexo = Integer.parseInt(request.getParameter("comboSexo"));
					switch (sexo) {
					case 1:
						x.setSexo("Masculino");	
						break;
					case 2:
						x.setSexo("Femenino");	
						break;
					case 3:
						x.setSexo("Otro");	
						break;
					default:
						break;
					}
					
				
					
					//IMPORTANTISIMO PARA FECHA					
					SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
					Date fecha;
					try {
						fecha = formato.parse(request.getParameter("txtFechaNac"));
						x.setFechaNac(fecha);						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
					
				
					
					x.setEstado(1);
					boolean estado=true;
					estado = negPac.insertar(x);
					request.setAttribute("estadoPaciente", estado);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarPaciente.jsp");
					dispatcher.forward(request, response);
					
		    }
		
		if(request.getParameter("btnEliminar")!=null) 
		{
			String dni = request.getParameter("dniPaciente");
			
			if(negPac.borrar(dni)) {
			ArrayList<Paciente> lista = negPac.listarPacientes();
			request.setAttribute("listaPac", lista);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarPacientes.jsp");
			dispatcher.forward(request, response);
			}
		}
		
		
		
			
	}
	
}



>>>>>>> 7382c7aac73e247fa2e98fc2b9104b9739cd3c88
