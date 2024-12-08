/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import java.sql.*;

/**
 *
 * @author gagas
 */
public class JDBC {
    Connection con;
    Statement stmt;
    public boolean isConnected;
    public String message;
    
    public JDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp_12", "root", "Abcabc123#");
            stmt = con.createStatement();
            isConnected = true;
            message = "DB connected";
        } catch(Exception e) {
            isConnected = false;
            message = e.getMessage();
        }
    }
    
    public void disconnect() {
        try {
            stmt.close();
            con.close();
        } catch(Exception e) {
            message = e.getMessage();
        }
    }
    
    public ResultSet runQuery(String query) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch(Exception e){
            message = e.getMessage();
        }
        return rs;
    }
    
    public int runUpdate(String query) {
        int result = 0;
        try {
            result = stmt.executeUpdate(query); // Use executeUpdate for non-SELECT queries
        } catch(Exception e){
            message = e.getMessage();
        }
        return result;
    }
}


