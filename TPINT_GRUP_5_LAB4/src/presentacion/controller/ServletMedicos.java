package presentacion.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Especialidad;
import entidad.Medico;

import negocio.EspecialidadNeg;

import negocio.MedicoNeg;
import negocioImpl.EspecialidadNegImpl;
import negocioImpl.MedicoNegImpl;


@WebServlet("/ServletMedicos")
public class ServletMedicos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EspecialidadNeg negCat = new EspecialidadNegImpl(); 
	MedicoNeg negMed = new MedicoNegImpl();
    public ServletMedicos() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!=null)
		{
			String opcion = request.getParameter("Param").toString();
			
			switch (opcion) {
			case "previoInsert":
			{

				/*//Se quiere insertar entonces cargo la lista de categorias
				request.setAttribute("listaCat", negCat.obtenerTodos());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/FormularioMedico.jsp");
				dispatcher.forward(request, response);*/

				//Se quiere insertar entonces cargo la lista de categorias
				request.setAttribute("listaCat", negCat.listarEspecialidades());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/InsertarMedico.jsp");
				dispatcher.forward(request, response);

				break;
			}
			case "list":
			{
				request.setAttribute("listaMed", negMed.listarMedicos());	
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarMedicos.jsp");
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
		    	Medico x = new Medico();
		    		    	
			
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
					x.setSexo("Masculino");	
					
					Especialidad especialidad = new Especialidad();
					especialidad.setID(Integer.parseInt(request.getParameter("txtEspecialidad")));
					x.setID_especialidad(especialidad);
					
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
					estado = negMed.insertar(x);
					request.setAttribute("estadoMedico", estado);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/FormularioMedico.jsp");
					dispatcher.forward(request, response);
					
								    	
		    	
		    }
	}

}
