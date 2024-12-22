/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import classes.JDBC;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 *
 * @author gagas
 */
@WebServlet(name = "barangServlet", urlPatterns = {"/barangServlet"})
public class barangServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JDBC db = new JDBC();
        String action = request.getParameter("action");
        
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            if(action.equals("delete")){
                db.runUpdate("DELETE FROM product WHERE id = " + id);
                response.sendRedirect("index.jsp");
            }
            
            if(action.equals("edit")) {
                ResultSet rs = db.runQuery("SELECT * FROM product WHERE id =" + id);
                if(rs.next()) {
                    request.setAttribute("id", rs.getInt("id"));
                    request.setAttribute("name", rs.getString("name"));
                    request.setAttribute("category", rs.getString("category"));
                    request.setAttribute("description", rs.getString("description"));
                    request.setAttribute("price", rs.getBigDecimal("price"));
                    request.setAttribute("stock", rs.getInt("stock"));
                }
                request.getRequestDispatcher("product/edit.jsp").forward(request, response);
            }
        } catch(Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JDBC db = new JDBC();
        String action = request.getParameter("action");
        
        try {
            String name = request.getParameter("name");
            String category = request.getParameter("category");
            String description = request.getParameter("description");
            BigDecimal price = new BigDecimal(request.getParameter("price"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            
            if(action.equals("create")) {
                String query = "INSERT INTO product (name, category, description, price, stock) "
                        + "VALUES ('" + name + "', '" + category + "', '" + description + "', " 
                        + price + ", " + stock + ")";
                db.runUpdate(query);
                response.sendRedirect("index.jsp");
            } 
            
            if(action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String query = "UPDATE product SET name = '" + name + "', category = '" + category 
                                + "', description = '" + description + "', price = " + price 
                                + ", stock = " + stock + " WHERE id = " + id;
                db.runUpdate(query);
                response.sendRedirect("index.jsp");
            }
        } catch(Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
