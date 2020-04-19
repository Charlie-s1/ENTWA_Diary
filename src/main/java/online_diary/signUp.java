/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_diary;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Charlie Smith
 */
@WebServlet(name = "signUp", urlPatterns = {"/signUp"})
public class signUp extends HttpServlet {   
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException {
        String id = "";
        try {
            String insert = "insert into USERINFO (userName, fname, lname, address, phone, email, password) values ('" 
                + request.getParameter("userName") + "','"
                + request.getParameter("fName") + "','"
                + request.getParameter("lName") + "','"
                + request.getParameter("add") + "','"
                + request.getParameter("phone") + "','"
                + request.getParameter("email") + "','"
                + request.getParameter("pass") + "'"
                + ")";
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/onlineDiary","onlineDiary","onlineDiary");
            Statement st = con.createStatement();
            st.executeUpdate(insert);
            
            String query = "Select * from userInfo where userName = '"
                + request.getParameter("userName") + "'"
                + "and password = '"
                + request.getParameter("pass") + "'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                for (int i=1; i<=rs.getMetaData().getColumnCount(); i++){
                    if ("USERID".equals(rs.getMetaData().getColumnName(i))){
                        id = rs.getString(i);
                    }
                }
            }
        }
        catch(SQLException e){
            System.out.println("cannot connecct to SQL");
            throw new Error("no connection?", e);
        } 
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            System.out.println("ID = " + id);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(signUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   * @throws java.sql.SQLException
   */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(signUp.class.getName()).log(Level.SEVERE, null, ex);
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
