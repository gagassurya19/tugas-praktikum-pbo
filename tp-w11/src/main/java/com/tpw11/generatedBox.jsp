<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Latihan - JSP</title>
    <!-- Link Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .square-box {
            background-color: lightblue;
            margin: 10px;
            width: 100px;
            height: 100px;
            display: inline-block;
        }
        .header, .footer {
            background-color: gray;
            color: white;
            text-align: center;
            padding: 10px 0;
        }
    </style>
</head>
<body>
    <!-- Header -->
    <div class="header">
        <h2>Header</h2>
    </div>

    <!-- Input Section -->
    <div class="container mt-4">
        <form action="generateBox.jsp" method="get">
            <label for="boxInput" class="form-label">Masukkan jumlah box:</label>
            <input type="number" id="boxInput" name="boxCount" class="form-control mb-3" placeholder="Contoh: 5" min="1" />
            <button type="submit" class="btn btn-primary">Generate</button>
        </form>

        <!-- Square Box Container -->
        <div id="boxContainer" class="mt-4">
            <%
                // Ambil input dari parameter
                String boxCountParam = request.getParameter("boxCount");
                if (boxCountParam != null) {
                    try {
                        int boxCount = Integer.parseInt(boxCountParam);
                        for (int i = 0; i < boxCount; i++) {
            %>
                            <div class="square-box"></div>
            <%
                        }
                    } catch (NumberFormatException e) {
                        out.println("<p class='text-danger'>Input tidak valid!</p>");
                    }
                }
            %>
        </div>
    </div>

    <!-- Footer -->
    <div class="footer">
        <p>Footer</p>
    </div>
</body>
</html>
