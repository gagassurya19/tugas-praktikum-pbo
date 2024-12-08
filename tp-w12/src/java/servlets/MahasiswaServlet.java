package servlets;

import classes.JDBC;
import java.io.IOException;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "MahasiswaServlet", urlPatterns = {"/MahasiswaServlet"})
public class MahasiswaServlet extends HttpServlet {

    // Calling processRequest inside doGet and doPost methods
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.isEmpty()) {
            processRequest(request, response);  // Call processRequest method
            return;
        }

        JDBC db = new JDBC();
        try {
            if (action.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                db.runUpdate("DELETE FROM mahasiswa WHERE id = " + id);
                response.sendRedirect("index.jsp");

            } else if (action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                ResultSet rs = db.runQuery("SELECT * FROM mahasiswa WHERE id = " + id);
                if (rs.next()) {
                    request.setAttribute("id", rs.getInt("id"));
                    request.setAttribute("nama", rs.getString("nama"));
                    request.setAttribute("jurusan", rs.getString("jurusan"));
                    request.setAttribute("angkatan", rs.getInt("angkatan"));
                    request.setAttribute("ipk", rs.getDouble("ipk"));
                }
                request.getRequestDispatcher("edit.jsp").forward(request, response);
            }
        } catch (Exception e) {
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
            if (action.equals("create")) {
                String nama = request.getParameter("nama");
                String jurusan = request.getParameter("jurusan");
                int angkatan = Integer.parseInt(request.getParameter("angkatan"));
                double ipk = Double.parseDouble(request.getParameter("ipk"));

                String query = "INSERT INTO mahasiswa (nama, jurusan, angkatan, ipk) VALUES ('" +
                        nama + "', '" + jurusan + "', " + angkatan + ", " + ipk + ")";
                db.runUpdate(query);
                response.sendRedirect("index.jsp");

            } else if (action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String nama = request.getParameter("nama");
                String jurusan = request.getParameter("jurusan");
                int angkatan = Integer.parseInt(request.getParameter("angkatan"));
                double ipk = Double.parseDouble(request.getParameter("ipk"));

                String query = "UPDATE mahasiswa SET nama = '" + nama + "', jurusan = '" +
                        jurusan + "', angkatan = " + angkatan + ", ipk = " + ipk + " WHERE id = " + id;
                db.runUpdate(query);
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp");
        }
    }

    // Process request logic that is called in both doGet and doPost
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nim = request.getParameter("nim");
        String nama = request.getParameter("nama");

        // Handle null or empty parameters
        if (nim == null || nim.isEmpty()) {
            nim = "NIM tidak diisi.";
        }
        if (nama == null || nama.isEmpty()) {
            nama = "Nama tidak diisi.";
        }

        // Set attributes to forward to JSP
        request.setAttribute("nim", "NIM Anda adalah: " + nim);
        request.setAttribute("nama", "Nama Anda adalah: " + nama);

        // Forward to index.jsp
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
