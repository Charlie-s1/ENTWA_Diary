/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_diary;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Charlie Smith
 */
@WebServlet(name = "signIn", urlPatterns = {"/signIn"})
public class signIn extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int count =  0;
        String id = "";
        try{
            //query db for user input
            String query = "SELECT * FROM USERINFO WHERE userName = '" 
                + request.getParameter("userName") + "'"
                + "and password = '"
                + request.getParameter("password") + "'";
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/onlineDiary","onlineDiary","onlineDiary");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query); 
            
            //get user information
            while (rs.next()){
                for (int i=1; i<=rs.getMetaData().getColumnCount(); i++){
                    System.out.print(rs.getString(i) + " " + rs.getMetaData().getColumnName(i));
                    if ("USERID".equals(rs.getMetaData().getColumnName(i))){
                        id = rs.getString(i);
                    }
                }
                count = rs.getInt(1);
            }
        }
        catch(SQLException e){
            System.out.println("cannot connecct to SQL");
            throw new Error("no connection?", e);
        }
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.print(id);
        }
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
