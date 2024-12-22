<%@page import="classes.JDBC, java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%
    if (session == null || session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp?error=You must log in first.");
        return;
    }
    
    JDBC db = new JDBC();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Products - CRUD Barang</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen">
    <nav class="bg-blue-600 text-white p-4">
        <div class="container mx-auto flex justify-between items-center">
            <h1 class="text-2xl font-bold">CRUD Barang</h1>
            <div>
                <span class="mr-4">Welcome, <%= session.getAttribute("username") %>!</span>
                <a href="LogoutServlet" class="bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded transition duration-300">Logout</a>
            </div>
        </div>
    </nav>

    <main class="container mx-auto mt-8 p-4">
        <div class="bg-white rounded-lg shadow-md p-6 mb-6">
            <h2 class="text-xl font-semibold mb-4">Database Connection Status</h2>
            <div class="p-4 rounded-md <%= db.isConnected ? "bg-green-100 text-green-700" : "bg-red-100 text-red-700" %>">
                <p>
                    <strong>STATUS:</strong> 
                    <%= db.isConnected ? db.message : "Gagal terkoneksi ke database; " + db.message %>
                </p>
            </div>
        </div>
        </div>
        
        <!-- Include view.jsp -->
        <jsp:include page="product/view.jsp" />
    </main>
</body>
</html>