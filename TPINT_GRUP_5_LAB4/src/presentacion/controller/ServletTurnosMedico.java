package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Usuario;
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
 * Servlet implementation class ServletTurnosMedico
 */
@WebServlet("/ServletTurnosMedico")
public class ServletTurnosMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final TurnoNeg negTur = new TurnoNegImpl();
	private static final EspecialidadNeg negEsp = new EspecialidadNegImpl(); 
    private static final MedicoNeg negMed = new MedicoNegImpl();
    private static final PacienteNeg negPac = new PacienteNegImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTurnosMedico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("buscarLista") != null) {
			Usuario usuarioMedico = (Usuario)request.getSession().getAttribute("usuario");
			request.setAttribute("listaTurnosMedico", negTur.obtenerPorDniMedico(usuarioMedico.getDni()));
			request.getRequestDispatcher("/ListarTurnosMedico.jsp?buscarLista=1").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PARA CAMBIAR A PRESENTE - MEDICO
		if(request.getParameter("btnPresenteM")!=null) 
		{
			int id = Integer.parseInt(request.getParameter("idTurno"));								
			Turno turno = new Turno();
			turno = negTur.obtenerUno(id);
			
			boolean estado = negTur.cambiarEstadoPresente(id);		
				
			request.setAttribute("datosTurno", turno);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AgregarObservacion.jsp");
			dispatcher.forward(request, response);					
		}
		
		//PARA CAMBIAR A AUSENTE - MEDICO
		if(request.getParameter("btnAusenteM")!=null) 
		{
			int id = Integer.parseInt(request.getParameter("idTurno"));									
			boolean estado = negTur.cambiarEstadoAusente(id);							
			request.setAttribute("estadoTurno", estado);		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarTurnosMedico.jsp");	
			dispatcher.forward(request, response);					
		}
		
		//DATOS DE PACIENTE - AMBOS USUARIOS
		if(request.getParameter("btnPacienteM")!=null) 
		{
			String dni = request.getParameter("dniPaciente");	
			Paciente paciente = new Paciente();
			paciente = negPac.obtenerUno(dni);									
			request.setAttribute("dniPac", paciente);		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/DatosPaciente.jsp");	
			dispatcher.forward(request, response);					
		}
		
		
		//PARA AGREGAR OBSERVACION - AMBOS USUARIOS
		if(request.getParameter("btnAgregarObservacion")!=null) 
		{
			int id = Integer.parseInt(request.getParameter("idTurno"));								
			Turno turno = new Turno();
			turno = negTur.obtenerUno(id);
			turno.setObservacion(request.getParameter("txtObservacion"));	
			
			boolean estado = negTur.agregarObservacion(turno);					
			request.setAttribute("estadoObservacionTurno", estado);			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AgregarObservacion.jsp");
			dispatcher.forward(request, response);					
		}
	}

}