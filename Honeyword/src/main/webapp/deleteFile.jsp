<%@page import="com.db.dbconn"%>
<%@page import="java.sql.Statement"%>
<%
int i=0;
System.out.println(""+request.getParameter("fileid"));
int fid=Integer.parseInt(request.getParameter("fileid"));
Statement st=dbconn.connect();
String sql ="delete from files where id="+fid;
i=st.executeUpdate(sql);
response.sendRedirect("listUsersFiles.jsp");    
%>