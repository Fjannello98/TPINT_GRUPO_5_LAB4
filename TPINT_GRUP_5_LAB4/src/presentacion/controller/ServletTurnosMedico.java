package presentacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Usuario;
import negocio.TurnoNeg;
import negocioImpl.TurnoNegImpl;

/**
 * Servlet implementation class ServletTurnosMedico
 */
@WebServlet("/ServletTurnosMedico")
public class ServletTurnosMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final TurnoNeg negTur = new TurnoNegImpl();   
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
			request.getRequestDispatcher("TurnosMedico.jsp?buscarLista=1").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
