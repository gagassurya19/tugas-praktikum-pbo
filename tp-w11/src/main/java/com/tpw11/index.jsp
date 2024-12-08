<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tugas Pendahuluan - JSP</title>
    <!-- Link Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container-custom {
            display: flex;
            margin-top: 20px;
        }
        .image-section {
            width: 30%;
            background-color: lightblue;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
            text-align: center;
        }
        .content-section {
            width: 70%;
            padding: 20px;
            border-left: 1px dashed gray;
        }
        .tabs {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <div class="container-custom">
        <!-- Left Image Section -->
        <div class="image-section">
            <p>gambar</p>
        </div>

        <!-- Right Content Section -->
        <div class="content-section">
            <!-- Tabs -->
            <ul class="nav nav-tabs tabs">
                <li class="nav-item">
                    <a class="nav-link active" href="#">TAB 1</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">TAB 2</a>
                </li>
            </ul>

            <!-- Text Input -->
            <div class="input-group">
                <textarea class="form-control" rows="3"></textarea>
                <button class="btn btn-secondary" type="button">send</button>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
