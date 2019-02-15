package fr.delmaire.pizzeria.business;

import java.util.ArrayList;

import fr.delmaire.pizzeria.bean.Pizza;

public interface IPizzaBusiness {

public ArrayList<Pizza> findAll();

public Pizza findOne(int id);

public boolean modifier (int id, int numero, String description, String reference, String libelle, int prix, String urlImage);

public void supprimerPizza(int id);

public boolean ajouterPizza (int numero, String description, String reference, String libelle, int prix, String urlImage);

}
