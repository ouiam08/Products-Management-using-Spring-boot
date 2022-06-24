<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
	<form action="saveProduit" method="post">
	<pre>
	nom : <input type="text" name="nomProduit">
	prix : <input type="text" name="prixProduit">
	date création : <input type="date" name="date">
	<input type="submit" value="ajouter">
	</pre>
	</form>
	${msg}
	<br/>
	<br/>
	<a href="ListeProduits">ListeProduits</a>
		
</body>
</html>