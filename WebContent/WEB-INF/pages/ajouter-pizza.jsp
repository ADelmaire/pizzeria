<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href= "ressources/css/ajouter-pizza.css"/>
<title>ajout pizza</title>
</head>
<body>

<h1>Ajouter une pizza</h1>

<div>
<form action="ajouter" method= "post" id="form">
<fieldset>
<legend>Nouvelle pizza</legend>
		<p>
		<label for="numero">Numéro:</label>
		<input type="text" id="numero" name="numero" class="bloc"/>
		</p>
		<p>
		<label for="description">Description:</label>
		<input type="text" id="description" name="description" class="bloc"/>
		</p>
		<p>
		<label for="reference">Référence:</label>
		<input type="text" id="reference" name="reference" class="bloc"/>
		</p>
		<p>
		<label for="libelle">Libellé:</label>
		<input type="text" id="libelle" name="libelle" class="bloc"/>
		</p>
		<p>
		<label for="prix">Prix:</label>
		<input type="text" id="prix" name="prix" class="bloc"/>
		</p>
		<p>
		<label for="urlImage">Photo:</label>
		<input type="text" id="urlImage" name="urlImage" class="bloc"/>
		</p>
		</fieldset>
		<input type="submit" value="envoyer" class="bouton"/>
		<input type="reset" value="annuler" class="bouton"/>
		
</form>
</div>

</body>
</html>