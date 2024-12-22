package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import classes.JDBC;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        JDBC jdbc = new JDBC();

        if (!jdbc.isConnected) {
            response.sendRedirect("login.jsp?error=" + jdbc.message);
            return;
        }

        boolean isValidUser = false;

        try {
            String query = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet rs = jdbc.runQuery(query);

            if (rs != null && rs.next()) {
                isValidUser = true;
            }

            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            response.sendRedirect("login.jsp?error=An error occurred: " + e.getMessage());
            return;
        } finally {
            jdbc.disconnect();
        }

        if (isValidUser) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(30 * 60); // session aktif selama 30 menit
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp?error=Invalid username or password.");
        }
    }
}
