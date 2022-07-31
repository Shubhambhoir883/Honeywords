<%-- 
    Document   : uploadDecoyFile
    Created on : 13 Aug, 2015, 3:20:05 PM
    Author     : user
--%>
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
                    <div class="row" style="border: 1px solid #0088cc;margin-left: auto;margin-right: auto;">
                        <div style="margin-left: auto;margin-right: auto;width: 300px;text-align: center;color: #23527c">
                            <%@include file="flash.jsp" %>
                            <h3><b>Upload File to System.</b></h3>
                        </div>
                        <div class="container thumbnail well" style="margin-left: auto;margin-right: auto;width: 300px">
                            <form enctype="multipart/form-data" action="UploadDecoy" method="post">
                                <input type="file" name="file"><br>
                                <input type="submit" value="Upload File">
                            </form>
                        </div>
                    </div>
                    <hr>
                </div>
            </div>
        </div>
        <!-- /Main -->
    </body>
</html>