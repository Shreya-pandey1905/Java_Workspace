<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <style>

        body{
            background-color:#f4f1ea;
        }

        .navbar{
            background-color:#0f2027 !important;
        }

        .navbar-brand i{
            color:#d4af37;
            margin-right:8px;
        }

        .btn-logout-nav{
            border:1px solid #d4af37;
            color:#d4af37;
            background:transparent;
            font-weight:600;
        }

        .btn-logout-nav:hover{
            background-color:#d4af37;
            color:#0f2027;
        }

        .welcome-banner{
            background-color:#0f2027;
            color:#fff;
            border-radius:16px;
            padding:30px 35px;
        }

        .welcome-banner .sub{
            color:#d4af37;
            font-weight:600;
            letter-spacing:0.5px;
        }

        .section-title{
            font-weight:700;
            color:#0f2027;
            margin:35px 0 15px;
            font-size:1.05rem;
            text-transform:uppercase;
            letter-spacing:0.5px;
        }

        .action-card{
            display:flex;
            align-items:center;
            gap:16px;
            border:none;
            border-radius:14px;
            padding:22px 20px;
            background:#fff;
            text-decoration:none;
            color:#0f2027;
            box-shadow:0 2px 10px rgba(15,32,39,0.08);
            transition:all 0.2s ease;
            height:100%;
        }

        .action-card:hover{
            transform:translateY(-4px);
            box-shadow:0 8px 20px rgba(15,32,39,0.15);
            color:#0f2027;
        }

        .action-icon{
            width:52px;
            height:52px;
            min-width:52px;
            border-radius:12px;
            display:flex;
            align-items:center;
            justify-content:center;
            font-size:22px;
            color:#fff;
        }

        .icon-navy{ background-color:#0f2027; }
        .icon-gold{ background-color:#d4af37; }
        .icon-teal{ background-color:#2c5364; }
        .icon-slate{ background-color:#203a43; }

        .action-card .title{
            font-weight:600;
            font-size:1rem;
            margin-bottom:2px;
        }

        .action-card .desc{
            font-size:0.8rem;
            color:#6c757d;
        }

        .danger-card{
            border:1.5px solid #dc3545;
        }

        .danger-card .action-icon{
            background-color:#dc3545;
        }

        .danger-card .title{
            color:#dc3545;
        }

        footer.app-footer{
            text-align:center;
            padding:25px 0;
            color:#6c757d;
            font-size:0.85rem;
        }

    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">
        <a class="navbar-brand fw-bold d-flex align-items-center" href="#">
            <i class="bi bi-bank2 fs-4"></i>
            Elite Bank
        </a>

        <a href="logout" class="btn btn-logout-nav btn-sm px-3">
            <i class="bi bi-box-arrow-right"></i>
            Logout
        </a>
    </div>
</nav>

<div class="container mt-4 mb-5">

    <div class="welcome-banner shadow-sm">
        <div class="sub">DASHBOARD</div>
        <h2 class="mb-1 mt-1">
            Welcome back,
         <%
                    String name=(String) session.getAttribute("name_key");
                    if(name!=null)
                    {
                      %>

            <span class="text-primary">  <%= name%> </span>!
                      <%
                      }
                      %>
        </h2>
        <p class="mb-0 text-white-50">
            Here's what you can do with your account today.
        </p>
    </div>

    <div class="section-title">Transactions</div>
    <div class="row g-3">

        <div class="col-md-4">
            <a href="deposit.jsp" class="action-card">
                <div class="action-icon icon-navy">
                    <i class="bi bi-piggy-bank-fill"></i>
                </div>
                <div>
                    <div class="title">Deposit</div>
                    <div class="desc">Add funds to your account</div>
                </div>
            </a>
        </div>

        <div class="col-md-4">
            <a href="withdraw.jsp" class="action-card">
                <div class="action-icon icon-slate">
                    <i class="bi bi-cash-stack"></i>
                </div>
                <div>
                    <div class="title">Withdraw</div>
                    <div class="desc">Withdraw available balance</div>
                </div>
            </a>
        </div>

        <div class="col-md-4">
            <a href="transfer.jsp" class="action-card">
                <div class="action-icon icon-gold">
                    <i class="bi bi-arrow-left-right"></i>
                </div>
                <div>
                    <div class="title">Transfer Money</div>
                    <div class="desc">Send funds to another account</div>
                </div>
            </a>
        </div>

    </div>

    <div class="section-title">Account</div>
    <div class="row g-3">

        <div class="col-md-4">
            <a href="ProfileServlet" class="action-card">
                <div class="action-icon icon-teal">
                    <i class="bi bi-person-fill"></i>
                </div>
                <div>
                    <div class="title">My Profile</div>
                    <div class="desc">View and edit your details</div>
                </div>
            </a>
        </div>

        <div class="col-md-4">
            <a href="BalanceServlet" class="action-card">
                <div class="action-icon icon-navy">
                    <i class="bi bi-wallet2"></i>
                </div>
                <div>
                    <div class="title">Check Balance</div>
                    <div class="desc">View current account balance</div>
                </div>
            </a>
        </div>

        <div class="col-md-4">
            <a href="resetPassword.jsp" class="action-card">
                <div class="action-icon icon-gold">
                    <i class="bi bi-shield-lock-fill"></i>
                </div>
                <div>
                    <div class="title">Reset Password</div>
                    <div class="desc">Update your login credentials</div>
                </div>
            </a>
        </div>

    </div>

    <div class="section-title">History & Records</div>
    <div class="row g-3">

        <div class="col-md-4">
            <a href="TransactionServlet" class="action-card">
                <div class="action-icon icon-slate">
                    <i class="bi bi-clock-history"></i>
                </div>
                <div>
                    <div class="title">Transaction History</div>
                    <div class="desc">View all past transactions</div>
                </div>
            </a>
        </div>

        <div class="col-md-4">
            <a href="MiniStatementServlet" class="action-card">
                <div class="action-icon icon-teal">
                    <i class="bi bi-file-earmark-text-fill"></i>
                </div>
                <div>
                    <div class="title">Mini Statement</div>
                    <div class="desc">Quick view of recent activity</div>
                </div>
            </a>
        </div>

        <div class="col-md-4">
            <a href="AuditServlet" class="action-card">
                <div class="action-icon icon-navy">
                    <i class="bi bi-journal-check"></i>
                </div>
                <div>
                    <div class="title">Audit Logs</div>
                    <div class="desc">Review account activity logs</div>
                </div>
            </a>
        </div>

    </div>

    <div class="section-title">Other</div>
    <div class="row g-3">

        <div class="col-md-4">
            <a href="BeneficiaryServlet" class="action-card">
                <div class="action-icon icon-gold">
                    <i class="bi bi-people-fill"></i>
                </div>
                <div>
                    <div class="title">Beneficiaries</div>
                    <div class="desc">Manage saved payees</div>
                </div>
            </a>
        </div>

        <div class="col-md-4">
            <a href="logout" class="action-card danger-card">
                <div class="action-icon">
                    <i class="bi bi-box-arrow-right"></i>
                </div>
                <div>
                    <div class="title">Logout</div>
                    <div class="desc">Sign out of your account</div>
                </div>
            </a>
        </div>

    </div>

</div>

<footer class="app-footer">
    © 2026 Elite Bank. Safe • Secure • Reliable
</footer>

</body>
</html>
