<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="ressources/css/pizzas.css"/>
<title>accueil</title>
</head>
<body>
<c:import url="menu.jsp"></c:import>

<h1>Nos pizzas</h1>

<div id="conteneur">
<c:forEach items="${pizzas}" var="pizza">
	<div class = "blocIndiv">
	<a href="infos?id=${pizza.id}"><img alt="" src="${pizza.urlImage}"/></a>
	<br/>
	<p class="infos">
	${pizza.libelle}<br/>
	${pizza.prix} €
	</p>
	</div>
</c:forEach>
</div>
<br>
<a href="ajouter">Ajouter une pizza</a>

</body>
</html>