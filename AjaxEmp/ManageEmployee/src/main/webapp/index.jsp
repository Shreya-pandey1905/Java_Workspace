<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employees</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet"
integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
crossorigin="anonymous">

<!-- Bootstrap JS Bundle (includes Popper) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
crossorigin="anonymous"></script>

    <link rel="stylesheet"
          href="https://cdn.datatables.net/2.3.4/css/dataTables.dataTables.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <script src="https://cdn.datatables.net/2.3.4/js/dataTables.min.js"></script>

    <script src="emp.js"></script>
</head>

<body>

<input type="text" id="search" placeholder="Search employee">
<br>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" id="modalBtn">
  Add Employees
</button>

<!-- Modal -->
<div class="modal fade" id="addEmployeeModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Add Employee</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
    <form id="addEmployeeForm">

      <div class="mb-3">
        <label for="name" class="form-label">Employee Name</label>
        <input type="text" id="name" name="name" class="form-control" placeholder="Enter employee name">
      </div>

      <div class="mb-3">
        <label for="salary" class="form-label">Salary</label>
        <input type="number" id="salary" name="salary" class="form-control" placeholder="Enter salary">
      </div>

      <div class="mb-3">
        <label for="mid" class="form-label">Manager</label>
          <select id="mid" name="mid" class="form-select">
            <option value="">Select manager</option>
          </select>
      </div>

    <button type="submit" class="btn btn-primary">Add Employee</button>

    </form>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

<table id="emptable">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Salary</th>
            <th>Manager</th>
        </tr>
    </thead>

    <tbody id="empdata">
    </tbody>
</table>

</body>
</html>