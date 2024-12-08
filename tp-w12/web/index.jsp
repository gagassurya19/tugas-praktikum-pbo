<%@page import="classes.JDBC, java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Mahasiswa</title>
    </head>
    <body>
        <h1>CRUD Mahasiswa</h1>
        
        <h3>Database Connection Status</h3>
        <%
            JDBC db = new JDBC();
            if (db.isConnected) {
                out.print("STATUS: " + db.message);
            } else {
                out.print("STATUS: Gagal terkoneksi ke database");
            }
        %>
        
        <br/><br/>
        <h3>MASUKAN DATA ANDA</h3>
        <form method="get" action="MahasiswaServlet">
            NIM: <input type="text" name="nim" required />
            Nama: <input type="text" name="nama" required />
            <input type="submit" value="Kirim"/>
        </form>
        
        <%
            String nim = (String) request.getAttribute("nim");
            String nama = (String) request.getAttribute("nama");

            if (nim != null && nama != null) {
                out.print("<p>" + nim + "</p>");
                out.print("<p>" + nama + "</p>");
            } 
        %>
        
        <br/><br/>
        <h3>Form Tambah Mahasiswa</h3>
        <form method="post" action="MahasiswaServlet?action=create">
            Nama: <input type="text" name="nama" required/><br/>
            Jurusan: <input type="text" name="jurusan" required/><br/>
            Angkatan: <input type="number" name="angkatan" required/><br/>
            IPK: <input type="text" name="ipk" required/><br/>
            <input type="submit" value="Tambah"/>
        </form>
        
        <br/>
        <h3>Data Mahasiswa</h3>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nama</th>
                <th>Jurusan</th>
                <th>Angkatan</th>
                <th>IPK</th>
                <th>Opsi</th>
            </tr>
            <%
                if (db.isConnected) {
                    ResultSet rs = db.runQuery("SELECT * FROM mahasiswa");

                    if (!rs.isBeforeFirst()) { // Jika tabel kosong
                        out.print("<tr><td colspan='6'>Tidak ada data</td></tr>");
                    } else {
                        while (rs.next()) {
                            out.print("<tr>");
                            out.print("<td>" + rs.getInt("id") + "</td>");
                            out.print("<td>" + rs.getString("nama") + "</td>");
                            out.print("<td>" + rs.getString("jurusan") + "</td>");
                            out.print("<td>" + rs.getInt("angkatan") + "</td>");
                            out.print("<td>" + rs.getDouble("ipk") + "</td>");
                            out.print("<td>"
                                    + "<a href='MahasiswaServlet?action=edit&id=" + rs.getInt("id") + "'>Edit</a> | "
                                    + "<a href='MahasiswaServlet?action=delete&id=" + rs.getInt("id") + "'>Hapus</a>"
                                    + "</td>");
                            out.print("</tr>");
                        }
                    }
                } else {
                    out.print("<tr><td colspan='6'>Gagal menghubungkan ke database</td></tr>");
                }
            %>
        </table>
    </body>
</html>
