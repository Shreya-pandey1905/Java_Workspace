<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    // Invalidate the current session
    session.invalidate();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body{
        background-color: #f8f9fa;
        height: 100vh;
    }

    .logout-card{
        max-width: 650px;
        margin: 80px auto;
        border-radius: 15px;
        border: none;
    }

    .card-header{
        background-color: #212529;
        color: white;
        border-radius: 15px 15px 0 0 !important;
    }

    .btn-custom{
        width: 140px;
    }
</style>

</head>
<body>

<div class="container">

    <div class="card shadow logout-card">

        <div class="card-header text-center py-3">
            <h3>Logged Out Successfully</h3>
        </div>

        <div class="card-body text-center p-5">

            <h1 class="display-6 mb-3">👋 Thank You!</h1>

            <p class="lead">
                Thank you for using our application.
            </p>

            <p class="text-muted mb-4">
                You have been logged out successfully. We hope to see you again soon!
            </p>

            <div class="d-flex justify-content-center gap-3">
                <a href="login.jsp" class="btn btn-dark btn-custom">
                    Login
                </a>

                <a href="register.jsp" class="btn btn-outline-dark btn-custom">
                    Register
                </a>
            </div>

        </div>

        <div class="card-footer text-center text-muted">
            © 2026 User Management System
        </div>

    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>