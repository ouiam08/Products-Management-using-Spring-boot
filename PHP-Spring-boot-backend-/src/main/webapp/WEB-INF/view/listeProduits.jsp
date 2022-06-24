<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 >
	Liste des Produits
	</h1>
	<table >
	<tr>
	<th>ID</th><th>Nom Produit</th><th>Prix</th><th>Suppression<th>Edition</th>
	</tr>
	<c:forEach items="${produits}" var="p">
	<tr>
	<td>${p.idProduit }</td>
	<td>${p.nomProduit }</td>
	<td>${p.prixProduit }</td>
	<td><a onclick="return confirm('Etes-voussûr ?')" href="supprimerProduit?id=${p.idProduit }">Supprimer</a></td>
	<td><a href="modifierProduit?id=${p.idProduit }">Edit</a></td>
	</tr>
	</c:forEach>
	</table>
	
		
</body>
</html>