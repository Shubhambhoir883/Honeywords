<%-- 
    Document   : listUsersFiles
    Created on : 14 Aug, 2015, 11:29:15 AM
    Author     : user
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.db.dbconn"%>
<%@page import="java.sql.Statement"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!--        <style>
                    body{
                        background-image: url("img/hw.png");
                    }
                </style>-->
        <%@include file="header.jsp" %>
    </head>
    <body>
        <%@include file="navigation.jsp" %>

        <!-- Main -->
        <div class="container-fluid" >
            <div class="row" >
                <!-- Menu List-->
                <%@include file="menu.jsp" %>
                <!-- Dashboard Contain-->
                <div class="col-sm-9">
                    <a href="dashboard.jsp"><strong><i class="glyphicon glyphicon-dashboard"></i> My Dashboard</strong></a>
                    <hr>
                    <b style="text-align: center;color: #337ab7;tab-size: 25px">Users Files List</b>
                    <div class="row" style="height: 200px;overflow: scroll;border: 1px solid #0088cc;margin-left: auto;margin-right: auto;">
                        <%
                            String users_sql = "SELECT * FROM files";
                            Statement st = dbconn.connect();
                            ResultSet rs = st.executeQuery(users_sql);
                        %>
                        <table class="table table-responsive" style="text-align: center">
                            <thead>
                                <tr style="color: red;background-color: yellow">
                                    <td>Id</td>
                                    <td>Name Of File</td>
                                    <td>User Id</td>
                                    <td>Size</td>
                                    <td>Created Time</td>
                                    <td>Operation</td>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    while (rs.next()) {
        String id=rs.getString("id");
        %>
                                <tr>
                                    <td><%=id%></td>
                                    <td><%=rs.getString("name")%></td>
                                    <td><%=rs.getString("user_id")%></td>
                                     <td><%=rs.getString("filesize")%>KB</td>
                                    <td><%=rs.getString("created_time")%></td>
                                    <td><a  class="btn-primary" href="deleteFile.jsp?fileid=<%=id%>">delete</a></td>
                                </tr>
                                <%   }
                                %>
                            </tbody>
                        </table>
                    </div>
                    <hr>
                </div>
            </div>
        </div>
        <!-- /Main -->
    </body>
</html>