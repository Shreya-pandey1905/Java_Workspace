<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body{
        background: linear-gradient(135deg, #0d6efd, #6f42c1);
        height: 100vh;
    }

    .welcome-card{
        max-width: 600px;
        border-radius: 15px;
    }

    .btn-custom{
        width: 140px;
    }
</style>

</head>
<body>

<div class="container h-100">
    <div class="row justify-content-center align-items-center h-100">

        <div class="col-md-7">
            <div class="card shadow-lg text-center welcome-card mx-auto">
                <div class="card-body p-5">

                    <h1 class="display-5 text-primary mb-3">
                        Welcome!
                    </h1>

                    <p class="lead text-secondary">
                        Welcome to our User Management System.
                    </p>

                    <p class="text-muted mb-4">
                        Register to create a new account or log in if you already have one.
                    </p>

                    <div class="d-flex justify-content-center gap-3">
                        <a href="register.jsp" class="btn btn-success btn-lg btn-custom">
                            Register
                        </a>

                        <a href="login.jsp" class="btn btn-primary btn-lg btn-custom">
                            Login
                        </a>
                    </div>

                </div>

                <div class="card-footer text-muted">
                    © 2026 User Management System
                </div>
            </div>
        </div>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>