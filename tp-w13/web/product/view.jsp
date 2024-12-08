<%@page import="classes.JDBC, java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product List</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen p-8">
    <div class="max-w-6xl mx-auto bg-white rounded-lg shadow-md p-8">
        <h1 class="text-3xl font-bold mb-6 text-center text-blue-600">Product List</h1>
        
        <!-- Flex container with justify-between -->
        <div class="flex justify-between mb-4"> 
            <div>
                <a href="../index.jsp" class="bg-blue-500 hover:bg-blue-600 text-white font-bold 
                   py-2 px-4 rounded inline-flex items-center">
                    Back to home
                </a>
            </div>
            <div>
                <a href="add.jsp" class="bg-green-500 hover:bg-green-600 text-white font-bold py-2 
                   px-4 rounded inline-flex items-center">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 mr-2" viewBox="0 0 20 
                         20" fill="currentColor">
                        <path fill-rule="evenodd" d="M10 5a1 1 0 011 1v3h3a1 1 0 110 2h-3v3a1 1 0 
                              11-2 0v-3H6a1 1 0 110-2h3V6a1 1 0 011-1z" clip-rule="evenodd" />
                    </svg>
                    Add New Product
                </a>
            </div>
        </div>

        <div class="overflow-x-auto">
            <table class="min-w-full bg-white">
                <thead class="bg-gray-800 text-white">
                    <tr>
                        <th class="py-3 px-4 text-left">ID</th>
                        <th class="py-3 px-4 text-left">Name</th>
                        <th class="py-3 px-4 text-left">Category</th>
                        <th class="py-3 px-4 text-left">Description</th>
                        <th class="py-3 px-4 text-left">Price</th>
                        <th class="py-3 px-4 text-left">Stock</th>
                        <th class="py-3 px-4 text-left">Created At</th>
                        <th class="py-3 px-4 text-left">Actions</th>
                    </tr>
                </thead>
                <tbody class="text-gray-700">
                    <%
                        JDBC db = new JDBC();
                        ResultSet rs = db.runQuery("SELECT * FROM product");
                        while (rs.next()) {
                    %>
                    <tr class="hover:bg-gray-100">
                        <td class="py-3 px-4"><%= rs.getInt("id") %></td>
                        <td class="py-3 px-4"><%= rs.getString("name") %></td>
                        <td class="py-3 px-4"><%= rs.getString("category") %></td>
                        <td class="py-3 px-4"><%= rs.getString("description") %></td>
                        <td class="py-3 px-4">Rp<%= rs.getBigDecimal("price") %></td>
                        <td class="py-3 px-4"><%= rs.getInt("stock") %></td>
                        <td class="py-3 px-4"><%= rs.getTimestamp("created_at") %></td>
                        <td class="py-3 px-4">
                            <a href="../barangServlet?action=edit&id=<%= rs.getInt("id") %>" 
                               class="text-blue-500 hover:text-blue-700 mr-2">Edit</a>
                            <a href="../barangServlet?action=delete&id=<%= rs.getInt("id") %>" 
                               class="text-red-500 hover:text-red-700" 
                               onclick="return confirm('Are you sure you want to delete this \n\
                                    product?')">Delete</a>
                        </td>
                    </tr>
                    <%
                        }
                        db.disconnect();
                    %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>

