/*
 * To change this template, choose Tools | Templates

* and open the template in the editor.
 */
package com.auth;

import com.alert.Mail;
import com.db.dbconn;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class Register extends HttpServlet {
     String key = "E1BB465D57CAE7ACDBBE8091F9CE83DF";

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
            throws ServletException, IOException {
        String username, password, email, gender, phone, position, passwordHash, insert_sql, SecKey, lastid = null;
        String originalHoneyWords = "";
        HashMap<String, String> resultPass = new HashMap<String, String>();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            username = request.getParameter("username");
            password = request.getParameter("password");
            email = request.getParameter("email");
               phone = request.getParameter("phone");
            gender = request.getParameter("myradio");
//            SecretKey SecKey1 = null;
//         AES.encrypt(password, SecKey1);
            System.out.println("------------AES Encryption--------------------------------");
            String crp = AesEncrypt.encrypt(password, key);
            System.out.println("crp:-"+crp);
             System.out.println("\n\n------------SHA Encryption--------------------------------");
            passwordHash = (String) HashData.generateHash(password);
            int pos = (int) (Math.random() * 19);
            resultPass = (HashMap<String, String>) HoneyWordGenerator.generator(pos, password);
            passwordHash = resultPass.get("hash");
            originalHoneyWords = resultPass.get("real");
            
            System.out.println(" Original honeyword   "+originalHoneyWords.toString());
            
            position = "" + pos;
//           
//            SecKey = AES.getSecretKeys().toString();

           // Mail.sendMail(email, username);

//            System.out.println(" SecKey " + SecKey);
//            insert_sql = "INSERT INTO users(username, password, email, gender, phone, position, secretKey) VALUES('" + username + "','" + passwordHash + "','" + email + "','" + gender + "','" + phone + "','" + position + "','" + SecKey + "')";
            insert_sql = "INSERT INTO users(username, password,aespass,email, gender, phone, position) VALUES('" + username + "','" + passwordHash + "','" + crp + "','" + email + "','" + gender + "','" + phone + "','" + position + "')";
          
            Statement st = dbconn.connect();
            System.out.println("st: " + st);
//            int rs = st.executeUpdate(insert_sql);
            int rs = st.executeUpdate(insert_sql);
            ResultSet rs1 = dbconn.connect().executeQuery("select max(id) as id from users");
            while (rs1.next()) {
                lastid = rs1.getString("id");
            }

            System.out.println("Last Inserted Key is: " + rs);
            if (rs != 0) {
              //  String outputFile = getServletContext().getRealPath("/") + "password/" + lastid + ".txt";
            	 File outputFile = new File("C:\\xyz\\Create.txt");
                System.out.println(outputFile+"c2 change");
                PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
                writer.println(originalHoneyWords);
                writer.close();
                System.out.println("Inserted Successfully");
                response.sendRedirect("login.jsp");
            } else {
                System.out.println("Not Inserted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
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


        } catch (Exception ex) {
            Logger.getLogger(Register.class
                    .getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(Register.class
                    .getName()).log(Level.SEVERE, null, ex);
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
