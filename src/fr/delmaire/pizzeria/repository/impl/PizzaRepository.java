package fr.delmaire.pizzeria.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fr.delmaire.pizzeria.bean.Pizza;
import fr.delmaire.pizzeria.repository.IPizzaRepository;

public class PizzaRepository implements IPizzaRepository{

	@Override
	public ArrayList<Pizza> findAll() {
		ArrayList<Pizza> listePizzas = new ArrayList<Pizza>();
		try {

			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cinema", "root", "");	
			Statement st = cnx.createStatement();

			ResultSet resultat = st.executeQuery("SELECT id, numero, description, reference, libelle, prix,urlImage FROM pizzeria");

			while (resultat.next()) {
				int id = resultat.getInt("id");
				int numero = resultat.getInt("numero");
				String description = resultat.getString("description");
				String reference = resultat.getString("reference");
				String libelle = resultat.getString("libelle");
				int prix = resultat.getInt("prix");
				String urlImage = resultat.getString("urlImage");

				Pizza p = new Pizza(id, numero, description, reference, libelle, prix, urlImage);
				listePizzas.add(p);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return listePizzas;
	}

	@Override
	public Pizza findOne(int id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cinema", "root", "");
			Statement st = cnx.createStatement();

			ResultSet resultat = st.executeQuery("SELECT id, numero, description, reference, libelle, prix, urlImage from pizzeria WHERE id=" +id);

			while (resultat.next()) {
				int iduser = resultat.getInt("id");
				int numero = resultat.getInt("numero");
				String description = resultat.getString("description");
				String reference = resultat.getString("reference");
				String libelle = resultat.getString("libelle");
				int prix = resultat.getInt("prix");
				String urlImage = resultat.getString("urlImage");

				Pizza p = new Pizza(iduser, numero, description, reference, libelle, prix, urlImage);
				return p;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean modifier(int id, int numero, String description, String reference, String libelle, int prix,
			String urlImage) {
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cinema", "root", "");
				
				PreparedStatement ps = cnx.prepareStatement(
						"UPDATE pizzeria SET numero = ? ,  description = ?, reference = ? , libelle = ? , prix = ? , urlImage =  ? WHERE id = ?");
				
				ps.setInt(1, numero);
				ps.setString(2, description);
				ps.setString(3, reference);
				ps.setString(4, libelle);
				ps.setInt(5, prix);
				ps.setString(6, urlImage);
				ps.setInt(7, id);
				
				ps.executeUpdate();
				return true;
				
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}

	@Override
	public void supprimerPizza(int id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/essaiPizza", "root", "");
			Statement st = cnx.createStatement();

			st.executeQuery("DELETE FROM pizzeria WHERE id="+id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public boolean ajouterPizza(int numero, String description, String reference, String libelle, int prix,
			String urlImage) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cinema","root","");

			PreparedStatement ps = cnx.prepareStatement("INSERT INTO pizzeria ("
					+ "numero, description, reference, libelle, prix, urlImage) "
					+ "VALUES(?,?,?,?,?,?) ");

			ps.setInt(1, numero);
			ps.setString(2, description);
			ps.setString(3, reference);
			ps.setString(4, libelle);
			ps.setInt(5, prix);
			ps.setString(6, urlImage);

			ps.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
