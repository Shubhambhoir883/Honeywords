<%-- 
    Document   : viewUserFiles
    Created on : 14 Aug, 2015, 1:30:01 PM
    Author     : user
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.db.dbconn"%>
<%@page import="java.sql.Statement"%>
<!DOCTYPE html>
<html lang="en">
    <head>
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
                            Statement st, st1;
                            st = st1 = null;
                            String usdesc = "", acdesc = "", insert_logs = "", username = "", ip = "";
                            String id = (String) session.getAttribute("id");
                            String users_sql = "SELECT * FROM files WHERE user_id=" + id;
                            st = dbconn.connect();
                            st1=dbconn.connect();
                            ResultSet rs = st.executeQuery(users_sql);
                            username = (String) session.getAttribute("username");
                            ip = (String) session.getAttribute("ip");
                            usdesc = username + " view his file";
                            acdesc = username + " view files from" + ip + " address";
                            insert_logs = "INSERT INTO logs(user_desc,action_desc)VALUES('" + usdesc + "','" + acdesc + "')";
                            int ins_rs = st1.executeUpdate(insert_logs);
                            if (ins_rs != 0) {
                                System.out.println("Inserted Successfully Log of Hacker1");
                            } else {
                                System.out.println("Not Inserted Successfully Log of Hacker1");
                            }
                            st1.close();
                        %>
                        <table class="table table-responsive" style="text-align: center">
                            <thead>
                                <tr style="color: red;background-color: yellow">
                                    <td>Sr.No</td>
                                    <td>Name Of File</td>
                                    <td>Action</td>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    int i = 1;
                                    while (rs.next()) {%>
                                <tr>
                                    <td><%=i++%></td>
                                    <td id="txtname"><%=rs.getString("name")%></td>
                                    <td><a href="DownloadFile?file_name=<%=rs.getString("name")%>"><input type="button" class="alert-success" value="Download" /></a></td>
                                </tr>
                                <%   }
                                    st.close();
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