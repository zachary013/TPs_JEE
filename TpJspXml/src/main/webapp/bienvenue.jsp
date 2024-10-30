<%@ page errorPage="/WEB-INF/erreur.jsp" import="bdd.*" %>
<jsp:useBean id="utilisateur" class="bdd.Personne" scope="session">
    <jsp:setProperty name="utilisateur" property="*" />
</jsp:useBean>

<html lang="fr">
<head>
    <title>Bienvenue</title>
</head>
<body>
<h1>Bonjour :</h1>
<strong><%= utilisateur.getNom() %></strong>
<strong><%= utilisateur.getPrenom() %></strong>
<strong><%= ", Votre identifiant est " + utilisateur.identificateur() %></strong>
<strong><%= ", et votre mot de passe est " + utilisateur.getMotDePasse() %></strong>
<%
    session.removeAttribute("utilisateur");
%>
</body>
</html>