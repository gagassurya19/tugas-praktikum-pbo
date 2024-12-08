<%-- 
    Document   : index
    Created on : 7 Dec 2024, 20.47.53
    Author     : gagas
--%>

<%@page import="classes.JDBC, java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CRUD Barang</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex flex-col items-center justify-center">
    <div class="bg-white p-8 rounded-lg shadow-md max-w-md w-full">
        <h1 class="text-3xl font-bold mb-6 text-center text-blue-600">CRUD Barang</h1>
        
        <div class="mb-6">
            <h3 class="text-xl font-semibold mb-2">Database Connection Status</h3>
            <div class="p-4 rounded-md <%
                JDBC db = new JDBC();
                if (db.isConnected) {
                    out.print("bg-green-100 text-green-700");
                } else {
                    out.print("bg-red-100 text-red-700");
                }
            %>">
                <p>
                    <strong>STATUS:</strong> 
                    <%
                    if (db.isConnected) {
                        out.print(db.message);
                    } else {
                        out.print("Gagal terkoneksi ke database; " + db.message);
                    }
                    %>
                </p>
            </div>
        </div>

        <div class="text-center">
            <a href="product/view.jsp" 
               class="inline-block bg-blue-500 hover:bg-blue-600 text-white font-bold 
               py-2 px-4 rounded transition duration-300">
                View Products
            </a>
        </div>
    </div>
</body>
</html>

