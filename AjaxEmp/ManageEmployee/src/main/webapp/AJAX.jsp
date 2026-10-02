<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
      href="https://cdn.datatables.net/2.3.4/css/dataTables.dataTables.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script src="https://cdn.datatables.net/2.3.4/js/dataTables.js"></script>

<script src="${pageContext.request.contextPath}/emp.js"></script>

<script src="emp.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Salary</th>
      <th scope="col">Reporting Manager</th>
    </tr>
  </thead>
  <tbody id="empdata">
    
  </tbody>
</table>


</body>
</html>