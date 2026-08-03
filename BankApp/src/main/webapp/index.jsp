<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Banking Application</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <style>

        body{
            background: linear-gradient(135deg,#0f2027,#203a43,#2c5364);
            min-height:100vh;
            display:flex;
            justify-content:center;
            align-items:center;
        }

        .welcome-card{
            max-width:700px;
            width:100%;
            border:none;
            border-radius:20px;
        }

        .logo{
            font-size:70px;
            color:#d4af37;
        }

        h1.text-primary{
            color:#0f2027 !important;
        }

        .btn-custom{
            width:180px;
            height:48px;
            font-size:17px;
            font-weight:600;
        }

        .btn-primary{
            background-color:#0f2027;
            border-color:#0f2027;
        }

        .btn-primary:hover{
            background-color:#203a43;
            border-color:#203a43;
        }

        .btn-outline-primary{
            color:#0f2027;
            border-color:#0f2027;
        }

        .btn-outline-primary:hover{
            background-color:#0f2027;
            border-color:#0f2027;
            color:#ffffff;
        }

        .card-footer{
            background-color:#f4f1ea !important;
            border-top:1px solid #d4af37;
        }

    </style>

</head>

<body>

<div class="container">

    <div class="card welcome-card shadow-lg mx-auto">

        <div class="card-body text-center p-5">

            <div class="logo mb-3">
                <i class="bi bi-bank2"></i>
            </div>

            <h1 class="fw-bold text-primary">
                Welcome to Elite Bank
            </h1>

            <p class="text-muted mt-3 fs-5">
                Manage your account securely and conveniently.
                Register as a new customer or sign in to access
                banking services like balance inquiry, deposits,
                withdrawals, fund transfers, and more.
            </p>

            <div class="d-flex justify-content-center gap-3 mt-4">

                <a href="login.jsp"
                   class="btn btn-primary btn-custom">

                    <i class="bi bi-box-arrow-in-right"></i>
                    Sign In

                </a>

                <a href="register.jsp"
                   class="btn btn-outline-primary btn-custom">

                    <i class="bi bi-person-plus-fill"></i>
                    Sign Up

                </a>

            </div>

        </div>

        <div class="card-footer text-center">

            <small class="text-muted">
                © 2026 Secure Bank. Safe • Secure • Reliable
            </small>

        </div>

    </div>

</div>

</body>
</html>
