<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="classes.JDBC, java.sql.ResultSet"%>
<%  JDBC db = new JDBC(); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - CRUD Barang</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex flex-col items-center justify-center">
    <div class="bg-white p-8 rounded-lg shadow-md max-w-md w-full">
        <h1 class="text-3xl font-bold mb-6 text-center text-blue-600">CRUD Barang</h1>
        
        <form action="LoginServlet" method="POST" class="space-y-4">
            <div>
                <label for="username" class="block text-sm font-medium text-gray-700">Username</label>
                <input type="text" id="username" name="username" placeholder="admin" required
                       class="mt-1 block w-full px-3 py-2 bg-white border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500">
            </div>
            <div>
                <label for="password" class="block text-sm font-medium text-gray-700">Password</label>
                <input type="password" id="password" name="password" placeholder="admin" required
                       class="mt-1 block w-full px-3 py-2 bg-white border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500">
            </div>
            <div>
                <button type="submit"
                        class="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-blue-600 hover:bg-blue-700 
                        focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500">
                    Login
                </button>
            </div>
        </form>

        <% 
            String error = request.getParameter("error");
            if (error != null) { 
        %>
        <div class="mt-4 p-4 bg-red-100 text-red-700 rounded-md">
            <p><%= error %></p>
        </div>
        <% } %>
        
        <div class="bg-white rounded-lg shadow-md p-6 my-6">
            <h2 class="text-xl font-semibold mb-4">Database Connection Status</h2>
            <div class="p-4 rounded-md <%= db.isConnected ? "bg-green-100 text-green-700" : "bg-red-100 text-red-700" %>">
                <p>
                    <strong>STATUS:</strong> 
                    <%= db.isConnected ? db.message : "Gagal terkoneksi ke database; " + db.message %>
                </p>
            </div>
        </div>
    </div>
</body>
</html>
