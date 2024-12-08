<%@page import="classes.JDBC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Product</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen p-8">
    <div class="max-w-2xl mx-auto bg-white rounded-lg shadow-md p-8">
        <h1 class="text-3xl font-bold mb-6 text-center text-blue-600">Edit Product</h1>

        <form method="post" action="barangServlet?action=update" class="space-y-4">
            <input type="hidden" name="id" value="<%= request.getAttribute("id") %>">

            <div>
                <label for="name" class="block text-sm font-medium text-gray-700">Name</label>
                <input type="text" id="name" name="name" 
                       value="<%= request.getAttribute("name") %>" 
                       required 
                       class="mt-1 block w-full rounded-md border-gray-300 shadow-sm 
                       focus:border-blue-300 focus:ring focus:ring-blue-200 
                       focus:ring-opacity-50">
            </div>

            <div>
                <label for="category" class="block text-sm font-medium text-gray-700">
                    Category</label>
                <input type="text" id="category" name="category" 
                       value="<%= request.getAttribute("category") %>" 
                       required 
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
                          focus:ring-opacity-50"><%= request.getAttribute("description") %>
                </textarea>
            </div>

            <div>
                <label for="price" class="block text-sm font-medium text-gray-700">Price</label>
                <input type="number" id="price" name="price" step="0.01" 
                       value="<%= request.getAttribute("price") %>" 
                       required 
                       class="mt-1 block w-full rounded-md border-gray-300 shadow-sm 
                       focus:border-blue-300 focus:ring focus:ring-blue-200 
                       focus:ring-opacity-50">
            </div>

            <div>
                <label for="stock" class="block text-sm font-medium text-gray-700">Stock</label>
                <input type="number" id="stock" name="stock" 
                       value="<%= request.getAttribute("stock") %>" 
                       required 
                       class="mt-1 block w-full rounded-md border-gray-300 shadow-sm 
                       focus:border-blue-300 focus:ring focus:ring-blue-200 
                       focus:ring-opacity-50">
            </div>

            <div class="flex items-center justify-between">
                <button type="submit" class="bg-blue-500 hover:bg-blue-600 text-white font-bold 
                        py-2 px-4 rounded focus:outline-none focus:shadow-outline">
                    Update Product
                </button>
                <a href="product/view.jsp" class="text-blue-500 hover:text-blue-700">
                    Back to Product List</a>
            </div>
        </form>
    </div>
</body>
</html>

