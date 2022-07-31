<%-- 
    Document   : listFiles
    Created on : 17 Aug, 2015, 4:47:42 PM
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
                            String users_sql = "SELECT * FROM decoy";
                            Statement st = dbconn.connect();
                            ResultSet rs = st.executeQuery(users_sql);
                        %>
                        <table class="table table-responsive" style="text-align: center">
                            <thead>
                                <tr style="color: red;background-color: yellow">
                                    <td>Id</td>
                                    <td>Name Of File</td>
                                    <td>Created Time</td>
                                    <td>Action</td>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    while (rs.next()) {%>
                                <tr>
                                    <td><%=rs.getString("id")%></td>
                                    <td><%=rs.getString("name")%></td>
                                    <td><%=rs.getString("created_time")%></td>
                                    <td><a href="Download?file_name=<%=rs.getString("name")%>"><input type="button" class="alert-success" value="Download" /></a></td>
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