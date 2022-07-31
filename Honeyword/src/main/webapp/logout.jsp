<%-- 
    Document   : logout
    Created on : 10 Aug, 2015, 3:14:19 PM
    Author     : chetan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session.setAttribute("id", "00");
    session.setAttribute("session_id", "");
    session.setAttribute("UserType", "");
    session.setAttribute("flash_message", "");
    session.setAttribute("flash_type", "");
    
    session.invalidate();
    
%>

<h1>You have Successfully logout</h1>
<a href="login.jsp">click here to go login page</a>

</html>