<%@ page errorPage="/WEB-INF/erreur.jsp" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Authentification</title>
</head>
<body>
<form action="bienvenue.jsp" method="post">
    <table border="1">
        <tr>
            <td><b>Nom</b></td>
            <td><input type="text" name="nom"></td>
        </tr>
        <tr>
            <td><b>Prénom</b></td>
            <td><input type="text" name="prénom"></td>
        </tr>
        <tr>
            <td><b>Mot de passe</b></td>
            <td><input type="password" name="motDePasse"></td>
        </tr>
    </table>
    <p><input type="submit" value="Valider"></p>
</form>
</body>
</html>