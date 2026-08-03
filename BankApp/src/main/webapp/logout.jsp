<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Logout Successful</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <style>

        body{
            background:linear-gradient(135deg,#0f2027,#203a43,#2c5364);
            min-height:100vh;
            display:flex;
            align-items:center;
            justify-content:center;
        }

        .logout-card{
            width:100%;
            max-width:550px;
            border:none;
            border-radius:18px;
        }

        .card-header{
            background:#0f2027 !important;
            border-radius:18px 18px 0 0 !important;
            padding:30px;
        }

        .success-icon{
            font-size:70px;
            color:#d4af37;
        }

        .btn-user{
            background:#0f2027;
            border-color:#0f2027;
            font-weight:600;
            height:48px;
        }

        .btn-user:hover{
            background:#203a43;
            border-color:#203a43;
        }

        .btn-admin{
            background:#d4af37;
            border-color:#d4af37;
            color:#0f2027;
            font-weight:600;
            height:48px;
        }

        .btn-admin:hover{
            background:#c49b20;
            border-color:#c49b20;
            color:white;
        }

        .btn-home{
            border:2px solid #0f2027;
            color:#0f2027;
            font-weight:600;
            height:48px;
        }

        .btn-home:hover{
            background:#0f2027;
            color:white;
        }

    </style>

</head>

<body>

<div class="container">

    <div class="card logout-card shadow-lg mx-auto">

        <div class="card-header text-center text-white">

            <i class="bi bi-check-circle-fill success-icon"></i>

            <h2 class="mt-3 mb-2">
                Logout Successful
            </h2>

            <p class="mb-0">
                Thank you for banking with us.
            </p>

        </div>

        <div class="card-body p-4 text-center">

            <h5 class="mb-3">
                You have been securely logged out.
            </h5>

            <p class="text-muted mb-4">
                Choose how you'd like to continue.
            </p>

            <div class="d-grid gap-3">

                <a href="login.jsp"
                   class="btn btn-user text-white">

                    <i class="bi bi-person-fill"></i>
                    User Login

                </a>

                <a href="adminLogin.jsp"
                   class="btn btn-admin">

                    <i class="bi bi-shield-lock-fill"></i>
                    Admin Login

                </a>

                <a href="index.jsp"
                   class="btn btn-home">

                    <i class="bi bi-house-door-fill"></i>
                    Home

                </a>

            </div>

        </div>

    </div>

</div>

</body>
</html>