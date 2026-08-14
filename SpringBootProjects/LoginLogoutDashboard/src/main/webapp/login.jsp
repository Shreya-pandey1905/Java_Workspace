<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background-color: #f8f9fa;
        height: 100vh;
    }

    .login-card {
        border-radius: 15px;
        border: none;
    }

    .card-header {
        background-color: #e9f7ef;
        color: #2d6a4f;
        border-bottom: none;
        border-radius: 15px 15px 0 0 !important;
    }

    .btn-login {
        background-color: #74c69d;
        border: none;
    }

    .btn-login:hover {
        background-color: #52b788;
    }

    a {
        color: #40916c;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }
</style>

</head>
<body>

<div class="container h-100">
    <div class="row justify-content-center align-items-center h-100">

        <div class="col-md-5">

            <div class="card shadow login-card">

                <div class="card-header text-center py-3">
                    <h3>User Login</h3>
                </div>

                <div class="card-body p-4">

                    <form action="login" method="post">

                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input
                                type="email"
                                class="form-control"
                                name="email"
                                placeholder="Enter your email"
                                required>
                        </div>

                        <div class="mb-4">
                            <label class="form-label">Password</label>
                            <input
                                type="password"
                                class="form-control"
                                name="password"
                                placeholder="Enter your password"
                                required>
                        </div>

                        <div class="d-grid">
                            <button type="submit" class="btn btn-login text-white">
                                Login
                            </button>
                        </div>

                    </form>

                    <div class="text-center mt-3">
                        Don't have an account?
                        <a href="register.jsp">Register here</a>
                    </div>

                </div>

                <div class="card-footer text-center text-muted bg-white">
                    © 2026 User Management System
                </div>

            </div>

        </div>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>