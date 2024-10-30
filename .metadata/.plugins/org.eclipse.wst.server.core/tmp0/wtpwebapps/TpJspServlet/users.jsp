<%@ page language="java" import="JavaBeans.UserBean" %>
<% UserBean user = (UserBean) session.getAttribute("utilisateur"); %>
<p>Votre Login est : <%=user.getLogin()%></p>
<p>Votre Password est : <%=user.getPassword()%></p>
<a href="modifier.jsp">Modifier</a>
