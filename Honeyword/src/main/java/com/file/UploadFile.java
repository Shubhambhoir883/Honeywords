/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.file;

import com.db.dbconn;
import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class UploadFile extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        String usdesc = "", acdesc = "", insert_logs = "",username="",ip="";
        try {
            /* TODO output your page here. You may use following sample code. */
            Statement st = dbconn.connect();
            String path = new File("C:\\xyz").getCanonicalPath();
            System.out.println(""+path);
            MultipartRequest multipartRequest = new MultipartRequest(request, path,17571860);
            File file = multipartRequest.getFile("file");
            System.out.println("file name:" + file);
            System.out.println("file name:" + file.getName());
            float f=(float)file.length()/1024;
            String file_name = file.getName();
            System.out.println("Successfully Uploaded File");
            String id = (String) session.getAttribute("id");
            String insert_sql = "INSERT INTO files(name,user_id,filesize)VALUES('" + file_name + "','" + id +"',"+f+ ")";
            st.executeUpdate(insert_sql);
            username = (String)session.getAttribute("username");
            ip = (String)session.getAttribute("ip");
            usdesc = username+" is going to upload file";
            acdesc = username + " upload file " +file_name+" from"+ ip + " address";
            insert_logs = "INSERT INTO logs(user_desc,action_desc)VALUES('" + usdesc + "','" + acdesc + "')";
            int ins_rs = st.executeUpdate(insert_logs);
            if (ins_rs != 0) {
                System.out.println("Inserted Successfully Log of Hacker1");
            } else {
                System.out.println("Not Inserted Successfully Log of Hacker1");
            }
            session.setAttribute("flash_message", "File is Uploade Successfully");
            session.setAttribute("flash_type", "success");
            response.sendRedirect("uploadFile.jsp");
            st.close();
        }
          finally {
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
            Logger.getLogger(UploadFile.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UploadFile.class.getName()).log(Level.SEVERE, null, ex);
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