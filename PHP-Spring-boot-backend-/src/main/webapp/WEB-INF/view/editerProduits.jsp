<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="updateProduit" method="post">
		<pre>
		id : <input type="text" name="idProduit" value="${produit.idProduit}">
		nom :<input type="text" name="nomProduit" value="${produit.nomProduit}">
		prix :<input type="text" name="prixProduit" value="${produit.prixProduit}">
		Date création :
		<fmt:formatDate pattern="yyyy-MM-dd" value="${produit.dateCreation}" var="formatDate" />
		<input type="date" name="date" value="${formatDate}"></input>
		<input type="submit" value="Modifier">
		</pre>
		</form>
		<br/>
		<br/>
		<a href="ListeProduits">ListeProduits</a>
				
</body>
</html>