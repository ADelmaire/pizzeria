package fr.delmaire.pizzeria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.delmaire.pizzeria.bean.Pizza;
import fr.delmaire.pizzeria.business.impl.PizzaBusiness;

/**
 * Servlet implementation class PizzaInfosServlet
 */
@WebServlet("/infos")
public class PizzaInfosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   PizzaBusiness pz = new PizzaBusiness();
	
    public PizzaInfosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS = request.getParameter("id");
		int id = Integer.parseInt(idS);
		
		Pizza pizza = pz.findOne(id);
		request.setAttribute("pizza", pizza);
		
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/pages/pizza-infos.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
