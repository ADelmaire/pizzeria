<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="ressources/css/modifier-pizza.css"/>
<title>modification</title>
</head>
<body>
<h1>Modifier les infos</h1>

<div>
<form action="modifier" method= "post" id="form">
<fieldset>
<legend>Modifications d'infos pizza</legend>

		<input type="text" id="id" name="id" value="${pizza.id}" hidden="hidden" />
		<label for="numero">Numéro:</label>
		<input type="text" id="numero" name="numero" class="bloc" value="${pizza.numero}" />
		<br>
		<label for="description">Description:</label>
		<input type="text" id="description" name="description" value="${pizza.description}" class="bloc"/>
		<br>
		<label for="reference">Référence:</label>
		<input type="text" id="reference" name="reference" value="${pizza.reference}" class="bloc"/>
		<br>
		<label for="libelle">Libellé:</label>
		<input type="text" id="libelle" name="libelle" value="${pizza.libelle}" class="bloc"/>
		<br>
		<label for="prix">prix:</label>
		<input type="text" id="prix" name="prix" value="${pizza.prix}" class="bloc"/>
		<br>
		<label for="urlImage">Photo:</label>
		<input type="text" id="urlImage" name="urlImage" value="${pizza.urlImage}" class="bloc"/>
		<br>
		</fieldset>
		<input type="submit" value="modifier" class="bouton">
		<input type="reset" value="annuler" class="bouton">
		
</form>
</div>

</body>
</html>
