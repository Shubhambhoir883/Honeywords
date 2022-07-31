<%-- 
    Document   : navigation
    Created on : 12 Aug, 2015, 6:36:38 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--header--> 
<div id="top-nav" class="navbar navbar-static-top navbar-inverse">
    <div class="container-fluid" >
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Dashboard</a>
        </div>
        <%
            String user_typ = session.getAttribute("type").toString();
            if (user_typ.equals("Admin")) {
        %>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-user"></i> Admin <span class="caret"></span></a>
                    <ul id="g-account-menu" class="dropdown-menu" role="menu">
                        <li><a href="#">My Profile</a></li>
                    </ul>
                </li>
                <li><a href="logout.jsp"><i class="glyphicon glyphicon-lock"></i> Logout</a></li>
                <li><a href="uploadDecoyFile.jsp"><i class="glyphicon glyphicon-user"></i> Upload Decoy File </a></li>
                <li><a href="listUsersFiles.jsp"><i class="glyphicon glyphicon-tent"></i> List Users Files</a></li>
                <li><a href="listUsers.jsp"><i class="glyphicon glyphicon-tent"></i> List Users</a></li>
                <li><a href="viewLogs.jsp"><i class="glyphicon glyphicon-tent"></i> View Logs</a></li>
            </ul>
        </div>
        <%        } else if (user_typ.equals("User")) {
        %>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="uploadFile.jsp"><i class="glyphicon glyphicon-user"></i>Upload File </a></li>\
                   <li><a href="#"><i class="glyphicon glyphicon-user"></i> User </a></li>
                <li><a href="logout.jsp"><i class="glyphicon glyphicon-lock"></i> Logout</a></li>
                 
            </ul>
        </div>
        <%        } else if (user_typ.equals("Hacker")) {
        %>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><i class="glyphicon glyphicon-user"></i> User </a></li>
                <li><a href="uploadFile.jsp"><i class="glyphicon glyphicon-user"></i>Upload File </a></li>\
                <li><a href="logout.jsp"><i class="glyphicon glyphicon-lock"></i> Logout</a></li>
            </ul>
        </div>
        <%            }
        %>
    </div>
    <!-- /container -->
</div>
<!-- /Header -->
