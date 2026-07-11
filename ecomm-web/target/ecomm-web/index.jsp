<%@ page import="jakarta.ejb.EJB" %>
<%@ page import="lk.kaushalya.ecomm.user.remote.TestRemote" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %><%--
  Created by IntelliJ IDEA.
  User: Welcome
  Date: 06/06/2026
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ecomm-WEB</title>
</head>
<body>
<%!
    @EJB
    private TestRemote testRemote;
%>
<h1><strong>Welcome to Ecomm-WEB  ||  indeex.JSP Page</strong></h1>
<%
   try {
       InitialContext ic = new InitialContext();
       TestRemote tr = (TestRemote) ic.lookup("java:global/ecomm-user-1.0/TestSessionBean");
       tr.test();
   } catch (NamingException e) {
       throw new RuntimeException(e);
   }
%>

<h4><strong>=========| J2EE Multi Modules |=========</strong></h4>
</body>
</html>
