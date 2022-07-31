<%-- 
    Document   : menu
    Created on : 25 Jul, 2015, 11:33:26 AM
    Author     : chetan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="col-sm-3">
    <!-- Left column -->
    <a href="#"><strong><i class="glyphicon glyphicon-wrench"></i> Tools</strong></a>
    <hr>
    <ul class="nav nav-stacked">
        <%  String user_typ1 = session.getAttribute("type").toString();
//            String session_id1 = session.getAttribute("session_id").toString();
            if (user_typ1.equals("Admin")) {
        %>
        <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#userMenu"> Dash Board Action<i class="glyphicon glyphicon-chevron-down"></i></a>
            <ul class="nav nav-stacked collapse in" id="userMenu">
                <li class="active"> <a href="dashboard.jsp"><i class="glyphicon glyphicon-home"></i> Home </a></li>
                <li><a href="uploadDecoyFile.jsp"><i class="glyphicon glyphicon-user"></i> Upload Decoy File </a></li>
                <li><a href="listUsersFiles.jsp"><i class="glyphicon glyphicon-tent"></i> List Users Files</a></li>
                <li><a href="listUsers.jsp"><i class="glyphicon glyphicon-tent"></i> List Users</a></li>
                <li><a href="viewLogs.jsp"><i class="glyphicon glyphicon-tent"></i> View Logs</a></li>
            </ul>
        </li>
        <%        } else if (user_typ1.equals("User")) {
        %>
        <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#userMenu"> Dash Board <i class="glyphicon glyphicon-chevron-down"></i></a>
            <ul class="nav nav-stacked collapse in" id="userMenu">
                <li class="active"> <a href="dashboard.jsp"><i class="glyphicon glyphicon-home"></i> Home </a></li>
                <li><a href="uploadFile.jsp"><i class="glyphicon glyphicon-user"></i> Upload File </a></li>
                <li><a href="viewUserFiles.jsp"><i class="glyphicon glyphicon-tent"></i> View Files</a></li>
            </ul>
        </li>
        <%            } else if (user_typ1.equals("Hacker")) {
        %>
        <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#userMenu"> Billing <i class="glyphicon glyphicon-chevron-down"></i></a>
            <ul class="nav nav-stacked collapse in" id="userMenu">
                <li class="active"> <a href="dashboard.jsp"><i class="glyphicon glyphicon-home"></i> Home </a></li>
                <li><a href="listFiles.jsp"><i class="glyphicon glyphicon-user"></i> View Files </a></li>
            </ul>
        </li>
        <% }%>
    </ul>
    <hr style="color: wheat; border: 1px solid">
</div>