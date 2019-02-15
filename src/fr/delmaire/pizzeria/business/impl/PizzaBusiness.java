package fr.delmaire.pizzeria.business.impl;

import java.util.ArrayList;

import fr.delmaire.pizzeria.bean.Pizza;
import fr.delmaire.pizzeria.business.IPizzaBusiness;
import fr.delmaire.pizzeria.repository.impl.PizzaRepository;

public class PizzaBusiness implements IPizzaBusiness{
	PizzaRepository pzr = new PizzaRepository();

	@Override
	public ArrayList<Pizza> findAll() {
		ArrayList<Pizza> liste = pzr.findAll();
				
		return liste;
	}

	@Override
	public Pizza findOne(int id) {
		Pizza pizza = pzr.findOne(id);
		return pizza;
	}

	@Override
	public boolean modifier(int id, int numero, String description, String reference, String libelle, int prix,
			String urlImage) {
		boolean b= pzr.modifier (id, numero, description, reference, libelle, prix, urlImage);
		return b;
	}

	@Override
	public void supprimerPizza(int id) {
		pzr.supprimerPizza(id);
		
	}

	@Override
	public boolean ajouterPizza(int numero, String description, String reference, String libelle, int prix,
			String urlImage) {
		boolean b = pzr.ajouterPizza(numero, description, reference, libelle, prix, urlImage);
		return b;
	}

}
