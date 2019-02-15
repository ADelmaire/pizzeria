package fr.delmaire.pizzeria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.delmaire.pizzeria.business.impl.PizzaBusiness;

/**
 * Servlet implementation class SupprimerPizzaServlet
 */
@WebServlet("/supprimer")
public class SupprimerPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PizzaBusiness pz = new PizzaBusiness();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerPizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS = request.getParameter("id");
		int id = Integer.parseInt(idS);
		
		pz.supprimerPizza(id);
		
		response.sendRedirect("pizzas");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
