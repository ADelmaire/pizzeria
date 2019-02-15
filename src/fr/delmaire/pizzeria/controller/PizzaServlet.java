package fr.delmaire.pizzeria.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.delmaire.pizzeria.bean.Pizza;
import fr.delmaire.pizzeria.business.impl.PizzaBusiness;


@WebServlet("/pizzas")
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  PizzaBusiness pz = new PizzaBusiness();
	
    public PizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Pizza> pizzas = pz.findAll();
		request.setAttribute("pizzas", pizzas);
		
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/pages/pizzas.jsp")
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
