<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Inscription</title>
</head>
<body>
<form action="valider.jsp" method="post">
    <table>
        <tr><td>Nom:</td><td><input type="text" name="nom"/></td></tr>
        <tr><td>Prénom:</td><td><input type="text" name="prenom"/></td></tr>
        <tr><td>Adresse:</td><td><input type="text" name="adresse"/></td></tr>
        <tr><td>Mot de Passe:</td><td><input type="password" name="motDePasse"/></td></tr>
    </table>
    <input type="submit" value="Nouvel utilisateur"/>
</form>
<a href="index.html">Accueil</a>
</body>
</html>
