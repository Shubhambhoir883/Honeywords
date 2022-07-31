/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auth;

import com.alert.Mail;
import com.db.dbconn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class Login extends HttpServlet {
	
	Mail send_mail = new Mail();

    public static int count = 0;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        String email = "", password = "", passwordHash = "", check_sql = "", id = "", honeyHashed = "", pos = "", username = "", phone = "", acdesc = "", usdesc = "";
        String insert_logs = "";
        Statement st,st1,st2;
        st = st1 = st2 = null;
       String event = null;
       
       String error ="Username or Password is invalid";
        try {
               String ipAddress = "";
           ipAddress = request.getHeader("X-FORWARDED-FOR");
           session.setAttribute("ip", ipAddress);
            st = dbconn.connect();
       
            boolean flag1=false,flag2=false;
            email = request.getParameter("email");
            password = request.getParameter("password");
            passwordHash = (String) HashData.generateHash(password);
           
            
            String check_sql_1 = "SELECT * FROM users WHERE email='" + email + "'";
            ResultSet rs1 = st.executeQuery(check_sql_1);
            
            int countrow=0;
           
			if(rs1.next())
			{
             event=rs1.getString("event_login");
             System.out.println("fetched username "+rs1.getString("username"));
			}
			
			 System.out.println("  event: " +event);
			
			if(event!=null) 
			{
			countrow= Integer.parseInt(event);
            System.out.println("  event: later on parsing " +countrow);
			}
           
            
       //     System.out.println("  after: ++"+count);
			
			 check_sql = "SELECT * FROM users WHERE email='" + email + "'";
	            ResultSet rs = st.executeQuery(check_sql);
            
	        //	System.out.println("loop  "+passwordHash+""+pos+" and"+username);  
	        	
	        	
	        	
            

            	
                if (rs.next()) {
                	System.out.println("  inside : ++rs"+count);
                	
                    id = rs.getString("id");
                    username = rs.getString("username");
                    phone = rs.getString("phone");
                    honeyHashed = rs.getString("password");
                    pos = rs.getString("position");
                    String[] honeyPassList = honeyHashed.split(",");
                    
                    
                    System.out.println("hashesh "+honeyPassList.length);
                    
                    //System.out.println("hashesh "+Arrays.toString(honeyPassList));
                    
                   
                    
                   // System.out.println("loop  "+passwordHash+" position  "+pos);  
                
                    forLoop:for (int i = 0; i < honeyPassList.length; i++) 
              {
                    
                    	
                  
                
                    	
                        if ((honeyPassList[i].equals(passwordHash)) && i != Integer.parseInt(pos)) {
                        	
                        	
                        	System.out.println("in 1st");
                        	
          
                            if (ipAddress == null) {
                                ipAddress = request.getRemoteAddr();
                            }
                            count = 0;
                            
                          //  System.out.println("Some one going to try your password combination. before");

                            
                            session.setAttribute("username", "Hacker");
                            usdesc = "Hacker Who Know Password Partially";
                            acdesc = "Hacker is trying to access " + username + " account having IP Address as " + ipAddress;
                            send_mail.sendAlertMail(email, username, ipAddress);
                      //      System.out.println("Some one going to try your password combination.");
                            st1 = dbconn.connect();
                            insert_logs = "INSERT INTO logs(user_desc,action_desc)VALUES('" + usdesc + "','" + acdesc + "')";
                            int ins_rs = st1.executeUpdate(insert_logs);
                            if (ins_rs != 0) {
                                System.out.println("Inserted Successfully Log of Hacker");
                            } else {
                                System.out.println("Not Inserted Successfully Log of Hacker");
                            }
                            flag2=true;
                            
                        } else if (honeyPassList[Integer.parseInt(pos)].equals(passwordHash)  && countrow <3) 
                        	{
                            System.out.println("checking honeypassList of pos to password hash here >>>>>>>>>>>");
                            count = 0;
                            
                            String sqlupdate="update users set event_login='" + count + "' where email='" + email +"'";
                            
                            if( st1==null)
                            {
                            	 st1 = dbconn.connect();
                            }
                            int row1 = st1.executeUpdate(sqlupdate);
                            
                            session.setAttribute("type", "User");
                            session.setAttribute("id", id);
                            session.setAttribute("username", username);
                          flag1=true;
                          
                          break forLoop; 
                        	}
                        
                        else if (honeyPassList[Integer.parseInt(pos)].equals(passwordHash)  && countrow >=3) {
                        	
                        	send_mail.sendMail(email, username);
                        	
                        	System.out.println("in 3rd");
                            count = 0;
                            session.setAttribute("type", "Hacker");
                            session.setAttribute("username", "Hacker1");
                            usdesc = "Someone Who Attempt Three time Password";
                            acdesc = "Someone is trying to access " + username + " account having IP Address as " + ipAddress + "and attempt password combination three times";
                            st2 = dbconn.connect();
                            insert_logs = "INSERT INTO logs(user_desc,action_desc)VALUES('" + usdesc + "','" + acdesc + "')";
                            int ins_rs = st2.executeUpdate(insert_logs);
                            if (ins_rs != 0) {
                                System.out.println("Inserted Successfully Log of Hacker1");
                            } else {
                                System.out.println("Not Inserted Successfully Log of Hacker1");
                            }
                            response.sendRedirect("Hacker.jsp");
                            System.out.println("Send user to Decoy file Page");
                            break forLoop; 
                        }
                        
                       
                 }
                    
                }
                  
                    if(flag2)
                    {
               
                        countrow++;
                        String sqlupdate="update users set event_login='" + countrow + "' where email='" + email +"'";
                        
                        if( st1==null)
                        {
                        	 st1 = dbconn.connect();
                        }
                        int row1 = st1.executeUpdate(sqlupdate);
                        
                        session.setAttribute("Invalid", error);
                        
                        response.sendRedirect("login.jsp");
                        
                    }
                    
                    else if(flag1)
                   {
                    	System.out.println("triggered success");
                    	response.sendRedirect("dashboard.jsp");
                   }
                    
                  
                
              else {
            	  	System.out.println("triggered failure");
            	    countrow++;
                    String sqlupdate="update users set event_login='" + countrow + "' where email='" + email +"'";
                    
                    if( st1==null)
                    {
                    	 st1 = dbconn.connect();
                    }
                    int row1 = st1.executeUpdate(sqlupdate);
                    
                    session.setAttribute("message","F");
                    
                    session.setAttribute("Invalid", error);
                    
                    
                    System.out.println("rows updated "+row1);

                    response.sendRedirect("login.jsp");
//                           Mail.sendAlertMail(email, username, ipAddress);
                }
             
          

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            st.close();
            st1.close();
            st2.close();
          //  out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
        }

    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
