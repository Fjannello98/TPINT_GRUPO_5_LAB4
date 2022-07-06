package presentacion.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Especialidad;
import entidad.Medico;
import entidad.Paciente;
import entidad.Turno;
import entidad.Estado;

import negocio.TurnoNeg;
import negocioImpl.TurnoNegImpl;
import negocio.PacienteNeg;
import negocioImpl.PacienteNegImpl;
import negocio.EspecialidadNeg;
import negocio.MedicoNeg;
import negocioImpl.EspecialidadNegImpl;
import negocioImpl.MedicoNegImpl;

/**
 * Servlet implementation class ServletTurnos
 */
@WebServlet("/ServletTurnos")
public class ServletTurnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private static final TurnoNeg negTur = new TurnoNegImpl();
	private static final EspecialidadNeg negEsp = new EspecialidadNegImpl(); 
    private static final MedicoNeg negMed = new MedicoNegImpl();
    private static final PacienteNeg negPac = new PacienteNegImpl();

    public ServletTurnos() {
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
				request.setAttribute("listaEsp", negEsp.listarEspecialidades());
				request.setAttribute("listaMed", negMed.listarMedicos());
				request.setAttribute("listaPac", negPac.listarPacientes());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Turnos.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "list":
			{
				request.setAttribute("listaTurno", negTur.listarTurnos());	
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarTurnos.jsp");
				dispatcher.forward(request, response);
				break;
			}
			default:
				break;
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(request.getParameter("btnAceptar")!=null)
		    {
		    		Turno x = new Turno();
		    		    	
			
		    		Estado estado = new Estado();
		    		estado.setID(2); //CORRESPONDE A "OCUPADO"
		    		x.setID_estado(estado);
		    		
		    		Especialidad especialidad = new Especialidad();
					especialidad.setID(Integer.parseInt(request.getParameter("comboEspecialidad")));
					x.setID_especialidad(especialidad);
					
					Medico medico = new Medico();
					medico.setDni(request.getParameter("comboMedico"));
					x.setDNI_medico(medico);
					
					Paciente paciente = new Paciente();
					paciente.setDni(request.getParameter("comboPaciente"));
					x.setDNI_paciente(paciente);
					
					x.setObservacion(request.getParameter("txtObservacion"));
		    															
					//IMPORTANTISIMO PARA FECHA					
					SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
					Date fecha;
					try {
						fecha = formato.parse(request.getParameter("txtFecha"));
						x.setFecha(fecha);						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
					
					//IMPORTANTISIMO PARA HORA	
					SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm"); 
					Date hora;
					try {
						hora = formatoHora.parse(request.getParameter("txtHora"));
						x.setHora(hora);						
	
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
					
					
						
					boolean status=true;
					status = negTur.insertar(x);
					request.setAttribute("estadoTurno", status);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Turnos.jsp");
					dispatcher.forward(request, response);
					
		    }
	}

}
