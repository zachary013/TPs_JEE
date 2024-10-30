<%@ page language="java" import="JavaBeans.UserBean" %>
<% UserBean user = (UserBean) session.getAttribute("utilisateur"); %>
<form action="TraiterLoginServlet" method="POST">
    <p>Login: <input type="text" name="login" value="<%=user.getLogin()%>" maxlength="15" /></p>
    <p>Password: <input type="password" name="password" value="<%=user.getPassword()%>" maxlength="15" /></p>
    <p><input type="submit" value="OK" /></p>
    <%
        String val = "modification";
        session.setAttribute("page", val);
    %>
</form>
