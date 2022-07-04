package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.MedicoNeg;
import negocioImpl.MedicoNegImpl;


@WebServlet("/ServletMedicos")
public class ServletMedicos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
				//Se quiere insertar entonces cargo la lista de categorias
				//request.setAttribute("listaCat", negCat.obtenerTodos());
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/InsertarArticulos.jsp");
				//dispatcher.forward(request, response);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
