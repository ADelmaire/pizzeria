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
 * Servlet implementation class ModifierPizzaServlet
 */
@WebServlet("/modifier")
public class ModifierPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   PizzaBusiness pizzabz = new PizzaBusiness();
   
    public ModifierPizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS = request.getParameter("id");
		int id = Integer.parseInt(idS);
		
		Pizza pizza = pizzabz.findOne(id);
		request.setAttribute("pizza", pizza);
		
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/pages/modifier-pizza.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS = request.getParameter("id");
		int id = Integer.parseInt(idS);
		String numeroS = request.getParameter("numero");
		int numero = Integer.parseInt(numeroS);
		String description = request.getParameter("description");
		String reference = request.getParameter("reference");
		String libelle = request.getParameter("libelle");
		String prixS = request.getParameter("prix");
		int prix = Integer.parseInt(prixS);
		String urlImage = request.getParameter("urlImage");
		
		boolean ok =pizzabz.modifier(id, numero, description, reference, libelle, prix, urlImage);
		if (ok) {
		response.sendRedirect("infos?id="+id);
		} else {
			response.sendRedirect("modifier?id="+id);
		}
	}

}
