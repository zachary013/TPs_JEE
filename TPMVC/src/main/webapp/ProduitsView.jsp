<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Liste des Produits</title>
</head>
<body>
<form action="controleur.do" method="post">
    Mot Clé: <input type="text" name="motCle" />
    <input type="submit" value="Rechercher" />
</form>

<table border="1" width="80%">
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Prix</th>
    </tr>
    <c:forEach var="p" items="${produits}">
        <tr>
            <td>${p.idProduit}</td>
            <td>${p.nomProduit}</td>
            <td>${p.prix}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>