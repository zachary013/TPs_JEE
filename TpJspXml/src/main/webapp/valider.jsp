<%@ page errorPage="/WEB-INF/erreur.jsp" import="bdd.*" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Validation</title>
</head>
<body>
<jsp:useBean id="utilisateur" class="bdd.Personne" scope="session">
    <jsp:setProperty name="utilisateur" property="*" />
    <h3>Informations Utilisateur</h3>
    <table border="1">
        <tr>
            <td><b>Nom</b></td>
            <td><jsp:getProperty name="utilisateur" property="nom" /></td>
        </tr>
        <tr>
            <td><b>Prénom</b></td>
            <td><jsp:getProperty name="utilisateur" property="prenom" /></td>
        </tr>
        <tr>
            <td><b>Mot de passe</b></td>
            <td><jsp:getProperty name="utilisateur" property="motDePasse" /></td>
        </tr>
        <tr>
            <td><b>Adresse</b></td>
            <td><jsp:getProperty name="utilisateur" property="adresse" /></td>
        </tr>
    </table>

    <h3 align="center">
        <%
            if (!utilisateur.enregistrer()) {
                out.println("<script>alert('Utilisateur déjà existant!'); window.location.href='inscription.jsp';</script>");
                session.removeAttribute("utilisateur");
            } else {
                out.println("<script>alert('Nouveau utilisateur enregistré!'); window.location.href='inscription.jsp';</script>");
            }
        %>
    </h3>
</jsp:useBean>
</body>
</html>