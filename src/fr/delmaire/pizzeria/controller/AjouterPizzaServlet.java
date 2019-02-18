package fr.delmaire.pizzeria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.delmaire.pizzeria.business.impl.PizzaBusiness;

/**
 * Servlet implementation class AjouterPizzaServlet
 */
@WebServlet("/ajouter")
public class AjouterPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PizzaBusiness pz = new PizzaBusiness();
    
    public AjouterPizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	this.getServletContext()
	.getRequestDispatcher("/WEB-INF/pages/ajouter-pizza.jsp")
	.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String numeroString = request.getParameter("numero");
		int numero = 0;
		try {
			numero = Integer.parseInt(numeroString);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("ajouter");
			return;
		}
		
		String description = request.getParameter("description");
		String reference = request.getParameter("reference");
		String libelle = request.getParameter("libelle");
		
		String prixString = request.getParameter("prix");
		int prix = 0;
		try {
			prix = Integer.parseInt(prixString);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("ajouter");
			return;
		}
		
		String urlImage = request.getParameter("urlImage");
	
		if(description.equals("")
				|| reference.equals("")
				|| libelle.equals("")	
				|| urlImage.equals("")
				) {
			response.sendRedirect("ajouter");
			return;
		}
		
		boolean ok =pz.ajouterPizza(numero, description, reference, libelle, prix, urlImage);
		
		if (ok) {
			
		response.sendRedirect("pizzas");
		} else {
			response.sendRedirect("ajouter");
		}
		
	}
	

}
