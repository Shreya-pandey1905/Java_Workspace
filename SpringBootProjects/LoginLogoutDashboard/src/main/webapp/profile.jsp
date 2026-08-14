<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>





<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body{
        background-color: #f8f9fa;
    }

    .profile-card{
        max-width: 600px;
        margin: 80px auto;
        border-radius: 15px;
        border: none;
    }

    .card-header{
        background-color: #212529;
        color: white;
        border-radius: 15px 15px 0 0 !important;
    }

    .profile-icon{
        font-size: 70px;
    }
</style>

</head>
<body>

<div class="container">

    <div class="card shadow profile-card">

        <div class="card-header text-center py-3">
            <h3>User Dashboard</h3>
        </div>

        <div class="card-body text-center">

            <div class="profile-icon mb-3">
                👤
            </div>

            <h2 class="mb-3">
                Welcome to your Dashboard,
                       <%
                        String email=(String) session.getAttribute("email_key");
                        if(email!=null)
                        {
                          %>

                <span class="text-primary">  <%= email%> </span>!
                          <%
                          }
                          %>

            </h2>

            <hr>


            <div class="mt-4">
                <a href="logout" class="btn btn-dark">
                    Logout
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