<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Bank Login</title>

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
            align-items:center;
            justify-content:center;
        }

        .login-card{
            width:100%;
            max-width:500px;
            border:none;
            border-radius:18px;
        }

        .card-header{
            border-radius:18px 18px 0 0 !important;
            padding:25px;
            background-color:#0f2027 !important;
        }

        .form-control{
            height:48px;
        }

        .form-control:focus{
            border-color:#d4af37;
            box-shadow:0 0 0 0.25rem rgba(212,175,55,0.25);
        }

        .input-group-text{
            background-color:#f4f1ea;
            color:#0f2027;
        }

        .btn-login{
            height:48px;
            font-size:17px;
            font-weight:600;
            background-color:#0f2027;
            border-color:#0f2027;
        }

        .btn-login:hover{
            background-color:#203a43;
            border-color:#203a43;
        }

        .logo{
            font-size:55px;
            color:#d4af37;
        }

        a.fw-semibold{
            color:#0f2027;
        }

        a.fw-semibold:hover{
            color:#d4af37;
        }

    </style>

</head>

<body>

<div class="container">

    <div class="card login-card shadow-lg mx-auto">

        <div class="card-header bg-primary text-white text-center">

            <div class="logo">
                <i class="bi bi-bank2"></i>
            </div>

            <h2 class="mt-2 mb-0">Welcome Back</h2>

            <small>Login to your bank account</small>

        </div>

        <div class="card-body p-4">

            <form action="login" method="post">

                <div class="mb-3">

                    <label class="form-label">
                        Email Address
                    </label>

                    <div class="input-group">

                        <span class="input-group-text">
                            <i class="bi bi-envelope-fill"></i>
                        </span>

                        <input type="email"
                               name="email"
                               class="form-control"
                               placeholder="Enter your email"
                               required>

                    </div>

                </div>

                <div class="mb-4">

                    <label class="form-label">
                        Password
                    </label>

                    <div class="input-group">

                        <span class="input-group-text">
                            <i class="bi bi-lock-fill"></i>
                        </span>

                        <input type="password"
                               name="password"
                               class="form-control"
                               placeholder="Enter your password"
                               required>

                    </div>

                </div>

                <button type="submit"
                        class="btn btn-primary btn-login w-100">

                    <i class="bi bi-box-arrow-in-right"></i>
                    Login

                </button>

            </form>

            <hr>

            <p class="text-center mb-0">

                Don't have an account?

                <a href="register.jsp"
                   class="text-decoration-none fw-semibold">

                    Register

                </a>

            </p>

        </div>

    </div>

</div>

</body>
</html>
