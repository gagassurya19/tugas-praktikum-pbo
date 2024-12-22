<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%
    if (session == null || session.getAttribute("username") == null) {
        response.sendRedirect("../login.jsp?error=You must log in first.");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Product</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen p-8">
    <div class="max-w-2xl mx-auto bg-white rounded-lg shadow-md p-8">
        <h1 class="text-3xl font-bold mb-6 text-center text-blue-600">Add New Product</h1>

        <form method="post" action="../barangServlet?action=create" class="space-y-4">
            <div>
                <label for="name" class="block text-sm font-medium text-gray-700">Name</label>
                <input type="text" id="name" name="name" required class="mt-1 block w-full 
                       rounded-md border-gray-300 shadow-sm focus:border-blue-300 focus:ring 
                       focus:ring-blue-200 focus:ring-opacity-50">
            </div>

            <div>
                <label for="category" class="block text-sm font-medium text-gray-700">
                    Category</label>
                <input type="text" id="category" name="category" required 
                       class="mt-1 block w-full rounded-md border-gray-300 shadow-sm 
                       focus:border-blue-300 focus:ring focus:ring-blue-200 
                       focus:ring-opacity-50">
            </div>

            <div>
                <label for="description" class="block text-sm font-medium text-gray-700">
                    Description</label>
                <textarea id="description" name="description" rows="3" 
                          class="mt-1 block w-full rounded-md border-gray-300 shadow-sm 
                          focus:border-blue-300 focus:ring focus:ring-blue-200 
                          focus:ring-opacity-50"></textarea>
            </div>

            <div>
                <label for="price" class="block text-sm font-medium text-gray-700">Price</label>
                <input type="number" id="price" name="price" step="0.01" required 
                       class="mt-1 block w-full rounded-md border-gray-300 shadow-sm 
                       focus:border-blue-300 focus:ring focus:ring-blue-200 
                       focus:ring-opacity-50">
            </div>

            <div>
                <label for="stock" class="block text-sm font-medium text-gray-700">Stock</label>
                <input type="number" id="stock" name="stock" required class="mt-1 block w-full 
                       rounded-md border-gray-300 shadow-sm focus:border-blue-300 focus:ring 
                       focus:ring-blue-200 focus:ring-opacity-50">
            </div>

            <div class="flex items-center justify-between">
                <button type="submit" class="bg-blue-500 hover:bg-blue-600 text-white font-bold 
                        py-2 px-4 rounded focus:outline-none focus:shadow-outline">
                    Add Product
                </button>
                <a href="../index.jsp" class="text-blue-500 hover:text-blue-700">
                    Back to Product List</a>
            </div>
        </form>
    </div>
</body>
</html>

