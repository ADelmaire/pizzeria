<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="ressources/css/pizza-infos.css"/>
<title>Insert title here</title>
</head>
<body>
<c:import url="menu.jsp"></c:import>

<h1>Infos pizza</h1>
<div id="conteneur">
		<div id="nom">${pizza.libelle} </div>
		<div>
			<img alt="" src="${pizza.urlImage}">
		</div>

		<div class="infos">
			<ul>
				<li>${pizza.reference}</li>
				<li>${pizza.description}</li>
				<li>${pizza.prix} euros</li>
			</ul>
		</div>
		<div id="liens">
		<a href="supprimer?id=${pizza.id}">Supprimer</a><br/>
		<a href="modifier?id=${pizza.id}">Modifier</a>
		<br>
		<a href="pizzas">Retour</a><br/>
		</div>
	</div>

</body>
</html>