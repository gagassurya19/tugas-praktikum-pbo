<%@page import="classes.JDBC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Mahasiswa</title>
    </head>
    <body>
        <h1>Edit Mahasiswa</h1>
        
        <form method="post" action="MahasiswaServlet?action=update">
            <input type="hidden" name="id" value="<%= request.getAttribute("id") %>" />
            Nama: <input type="text" name="nama" value="<%= request.getAttribute("nama") %>" required/><br/>
            Jurusan: <input type="text" name="jurusan" value="<%= request.getAttribute("jurusan") %>" required/><br/>
            Angkatan: <input type="number" name="angkatan" value="<%= request.getAttribute("angkatan") %>" required/><br/>
            IPK: <input type="text" name="ipk" value="<%= request.getAttribute("ipk") %>" required/><br/>
            <input type="submit" value="Update"/>
        </form>
        
        <a href="index.jsp">Kembali ke Halaman Utama</a>
    </body>
</html>
