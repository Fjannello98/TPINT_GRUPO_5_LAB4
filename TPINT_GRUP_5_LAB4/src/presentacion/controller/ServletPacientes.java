package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;
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
				
				x.setCorreo(request.getParameter("txtCorreo"));
				x.setDireccion(request.getParameter("txtDireccion"));
				x.setNacionalidad(request.getParameter("txtNacionalidad"));
				x.setLocalidad(request.getParameter("txtLocalidad"));
				x.setProvincia(request.getParameter("txtProvincia"));					
				x.setSexo("Masculino");	
				
				
				
				/*try {
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					Date fecha;
					fecha = formato.parse("05/08/1994");
					x.setFechaNac(fecha);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				
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
			
	}

}
